package su.zano.mainsite.ZanoSu.views;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import su.zano.mainsite.ZanoSu.components.VerticalSpacedLayout;
import su.zano.mainsite.ZanoSu.util.MyTheme;
import su.zano.mainsite.ZanoSu.util.ViewConfig;

@ViewConfig(uri = "", displayName = "Главная страница")
public class HomeView extends VerticalSpacedLayout implements View{
    public HomeView() {
        Label caption = new Label("Добро пожаловать " + "todo: username!");
        Label description = new Label(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc eu nisl at turpis maximus varius ac eu dui. In hac habitasse platea dictumst. Nunc imperdiet massa at orci ultrices, vitae euismod justo laoreet. Fusce finibus hendrerit varius. Proin et vulputate odio. Nulla ligula arcu, ultricies quis dignissim eleifend, pharetra eu sapien. Nam quis facilisis odio. Donec non congue nulla. Aliquam eu facilisis massa. Quisque blandit, ante at semper venenatis, nisi est imperdiet sapien, vitae sollicitudin odio massa in nunc. Nullam sed dui faucibus, posuere ex nec, congue lectus. Vestibulum ullamcorper ultrices sem in fermentum. Cras consectetur eleifend diam, id vulputate ex mollis a. Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                        "\n" +
                        "Donec molestie turpis eget metus cursus, sit amet facilisis lacus facilisis. Quisque ultrices molestie mauris quis pharetra. Curabitur purus metus, sodales at hendrerit eu, finibus nec metus. Donec porttitor nisi ligula, in faucibus mauris eleifend non. Curabitur ex dolor, euismod sed condimentum sed, placerat ac elit. Nunc eleifend pulvinar lacus vehicula facilisis. Etiam a lobortis lectus. Phasellus a ligula eros. In sollicitudin egestas enim vitae lobortis. Maecenas lobortis vulputate ornare. Suspendisse mollis dolor ac feugiat congue. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Duis dignissim blandit placerat. Ut accumsan nec nisl viverra eleifend. Pellentesque hendrerit a leo vitae dictum.\n" +
                        "\n" +
                        "Ut nibh nunc, placerat vitae ipsum at, sodales interdum sem. Aliquam enim lacus, mattis mollis gravida non, facilisis quis elit. Vivamus dictum, ipsum eget egestas elementum, elit mi auctor tellus, nec auctor sem tellus non nunc. Nunc at vehicula lacus. Proin suscipit sapien augue, eget rhoncus massa semper ac. Nunc suscipit risus nulla, eget blandit sem auctor non. Nunc consectetur iaculis pulvinar. Suspendisse nec velit justo. Pellentesque semper rutrum consectetur. Praesent consectetur, nulla sit amet ornare ultrices, mauris metus lobortis augue, vitae lacinia tortor leo sit amet est. Donec tristique rutrum interdum. Cras orci erat, mollis et tristique vitae, maximus euismod tellus.\n" +
                        "\n" +
                        "Duis velit nibh, consequat a erat eu, suscipit feugiat quam. Donec tempus diam non quam eleifend, eget commodo nisi interdum. Suspendisse vitae faucibus risus. Aliquam nec efficitur turpis, quis fringilla metus. Etiam quis tortor nunc. Nunc velit augue, gravida id sagittis et, lacinia eget tellus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus porta malesuada malesuada. Vivamus nulla arcu, cursus id egestas in, egestas id turpis.\n" +
                        "\n" +
                        "Aenean ornare, nisl sed aliquam feugiat, magna augue iaculis urna, nec fermentum quam leo sed lorem. Phasellus efficitur ex tincidunt nisl convallis vulputate. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam at felis a ex mattis congue. Maecenas porttitor pulvinar magna, vitae eleifend enim tincidunt at. Integer vitae suscipit leo, vel vulputate augue. Proin et augue id enim commodo convallis sed sit amet nunc. Aliquam fringilla nisl eu sem elementum, eget auctor sapien faucibus. Nunc enim mi, tristique id lacus vitae, feugiat egestas diam. Donec nec ligula nec arcu hendrerit cursus sagittis nec tellus. Nullam feugiat ligula a mattis bibendum. Nullam nisl sem, hendrerit vitae lobortis at, interdum quis quam. Nullam non dapibus ex. Integer rutrum arcu id tortor pellentesque lobortis. Ut sed molestie velit. Nunc sed enim diam.");

        addComponents(caption, description);

        caption.addStyleName(MyTheme.LABEL_HUGE);
        description.addStyleName(MyTheme.LABEL_LARGE);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        System.out.println("Пользователь @username зашел на главную страницу!");
    }
}
