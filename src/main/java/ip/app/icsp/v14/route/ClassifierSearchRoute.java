package ip.app.icsp.v14.route;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;
import com.vaadin.ui.Label;
import ip.app.icsp.v14.ApplicationLayout;

@Route( value = "ui/classifier", layout = ApplicationLayout.class)
public class ClassifierSearchRoute extends Composite<Div> {

    /**
     * Constructor for the legacy route.
     */
    public ClassifierSearchRoute () {
        this.getContent().add(new LegacyWrapper( new Label("Classifier Search Route")));
    }

}