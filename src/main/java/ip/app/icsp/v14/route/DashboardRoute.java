package ip.app.icsp.v14.route;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.Route;
import ip.app.icsp.v14.ApplicationLayout;

@Route( value = "ui", layout = ApplicationLayout.class)
public class DashboardRoute extends Composite<Div> {

    public DashboardRoute()
    {
        this.getContent().add(new Label("Hello World"));
    }

}