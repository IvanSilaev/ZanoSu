package su.zano.mainsite.ZanoSu.util.event;

import su.zano.mainsite.ZanoSu.ZanosuUI;

public class EventBus {
    public static void register(final Object listener) {
        ZanosuUI.getEventBus().register(listener);
    }

    public static void unregister(final Object listener) {
        ZanosuUI.getEventBus().unregister(listener);
    }

    public static void post(final Object event) {
        ZanosuUI.getEventBus().post(event);
    }
}
