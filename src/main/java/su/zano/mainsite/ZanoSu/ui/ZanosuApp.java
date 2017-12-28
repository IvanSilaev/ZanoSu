package su.zano.mainsite.ZanoSu.ui;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import su.zano.mainsite.ZanoSu.ZanosuUI;
import su.zano.mainsite.ZanoSu.util.LazyProvider;
import su.zano.mainsite.ZanoSu.util.MyTheme;
import su.zano.mainsite.ZanoSu.util.ViewConfig;
import su.zano.mainsite.ZanoSu.views.HomeView;
import su.zano.mainsite.ZanoSu.views.OnlineStreamsView;

public class ZanosuApp extends HorizontalLayout {
    private NavBar navBar;
    private Panel content;


    private Navigator navigator;

    public ZanosuApp() {
        addStyleName(MyTheme.MAIN_LAYOUT);

        setSizeFull();
        initLayouts();
        setupNavigator();
    }

    private void initLayouts() {
        navBar = new NavBar();
        content = new Panel();

        content.setSizeFull();
        content.addStyleName(MyTheme.PANEL_BORDERLESS);

        addComponents(navBar, content);
        setExpandRatio(content, 1);
    }

    private void setupNavigator() {
        navigator = new Navigator(ZanosuUI.getCurrent(), content);

        registerViews();

        navigator.addViewChangeListener(navBar);

        navigator.navigateTo(navigator.getState());
    }

    private void registerViews() {
        addView(HomeView.class);
        addView(OnlineStreamsView.class);
    }

    private void addView(Class<? extends View> viewClass) {
        ViewConfig viewConfig = viewClass.getAnnotation(ViewConfig.class);

        switch (viewConfig.createMode()) {
            case ALWAYS_NEW:
                navigator.addView(viewConfig.uri(), viewClass);
                break;
            case LAZY_INIT:
                navigator.addProvider(new LazyProvider(viewConfig.uri(), viewClass));
                break;
            case EAGER_INIT:
                try {
                    navigator.addView(viewConfig.uri(), viewClass.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }

        navBar.addView(viewConfig.uri(), viewConfig.displayName());
    }
}
