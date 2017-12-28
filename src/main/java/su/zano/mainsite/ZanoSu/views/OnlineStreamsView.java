package su.zano.mainsite.ZanoSu.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import su.zano.mainsite.ZanoSu.components.VerticalSpacedLayout;
import su.zano.mainsite.ZanoSu.util.MyTheme;
import su.zano.mainsite.ZanoSu.util.ViewConfig;

@ViewConfig(uri = "/streams", displayName = "Прямые трансляции")
public class OnlineStreamsView extends VerticalSpacedLayout implements View {
    public OnlineStreamsView() {
        Label caption = new Label("Добро пожаловать " + "todo: username!");
        Label description = new Label("todo: стримы с youtube и twitch");


        addComponents(caption, description);

        caption.addStyleName(MyTheme.LABEL_HUGE);
        description.addStyleName(MyTheme.LABEL_LARGE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
