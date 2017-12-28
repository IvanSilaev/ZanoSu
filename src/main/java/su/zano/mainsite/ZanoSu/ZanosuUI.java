package su.zano.mainsite.ZanoSu;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.*;
import su.zano.mainsite.ZanoSu.ui.NavBar;
import su.zano.mainsite.ZanoSu.ui.ZanosuApp;
import su.zano.mainsite.ZanoSu.util.event.NavigationEvent;

import javax.servlet.annotation.WebServlet;

@SpringUI
@SuppressWarnings("serial")
@Theme("mytheme")
@Push
public class ZanosuUI extends UI {

    private EventBus eventBus;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupEventBus();


        setContent(new ZanosuApp());
    }

    @Subscribe
    public void navigateTo(NavigationEvent view) {
        getNavigator().navigateTo(view.getViewName());
    }

    private void setupEventBus() {
        eventBus = new EventBus(((throwable, subscriberExceptionContext) -> {
            throwable.printStackTrace();
        }));

        eventBus.register(this);
    }


    public static ZanosuUI getCurrent() {
        return (ZanosuUI) UI.getCurrent();
    }

    public static EventBus getEventBus() {
        return getCurrent().eventBus;
    }

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ZanosuUI.class)
    public class ZanosuServlet extends SpringVaadinServlet {}
}
