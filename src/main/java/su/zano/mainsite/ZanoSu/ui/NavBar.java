package su.zano.mainsite.ZanoSu.ui;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import su.zano.mainsite.ZanoSu.util.MyTheme;
import su.zano.mainsite.ZanoSu.util.event.EventBus;
import su.zano.mainsite.ZanoSu.util.event.LogOutEvent;
import su.zano.mainsite.ZanoSu.util.event.NavigationEvent;

import java.util.HashMap;
import java.util.Map;

public class NavBar extends CssLayout implements ViewChangeListener {

    private Map<String, Button> buttonMap = new HashMap<>();

    public NavBar() {
        setHeight("100%");
        addStyleName(MyTheme.MENU_ROOT);
        addStyleName(MyTheme.NAVBAR);

        Label logo = new Label("<strong>Zano.su</strong>", ContentMode.HTML);
        logo.addStyleName(MyTheme.MENU_TITLE);
        addComponent(logo);

        addLogoutButton();
    }

    private void addLogoutButton() {
        Button logout = new Button("Выйти", clickEvent -> EventBus.post(new LogOutEvent()));
        addComponent(logout);

        logout.addStyleName(MyTheme.BUTTON_LOGOUT);
        logout.addStyleName(MyTheme.BUTTON_BORDERLESS);
        logout.setIcon(FontAwesome.SIGN_OUT);
    }

    public void addView(String uri, String displayName) {
        Button viewButton = new Button(displayName, clickEvent -> EventBus.post(new NavigationEvent(uri)));

        viewButton.addStyleName(MyTheme.MENU_ITEM);
        viewButton.addStyleName(MyTheme.BUTTON_BORDERLESS);
        buttonMap.put(uri, viewButton);

        addComponent(viewButton, components.size() - 1);
    }

    @Override
    public boolean beforeViewChange(ViewChangeEvent viewChangeEvent) {
        return true; // false blocks navigation, always return true here
    }

    @Override
    public void afterViewChange(ViewChangeEvent event) {
        buttonMap.values().forEach(button -> button.removeStyleName(MyTheme.SELECTED));
        Button button = buttonMap.get(event.getViewName());
        if (button != null) button.addStyleName(MyTheme.SELECTED);
    }
}
