package su.zano.mainsite.ZanoSu.util;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

public class LazyProvider extends Navigator.ClassBasedViewProvider {

    private View view;

    public LazyProvider(String viewName, Class<? extends View> viewClass) {
        super(viewName, viewClass);
    }

    @Override
    public View getView(String viewName) {
        if(view == null) {
            view  = super.getView(viewName);
        }

        return view;
    }
}
