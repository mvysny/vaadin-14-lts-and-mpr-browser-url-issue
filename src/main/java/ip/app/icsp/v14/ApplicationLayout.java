package ip.app.icsp.v14;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.router.RouteData;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.mpr.core.MprTheme;
import com.vaadin.mpr.core.MprWidgetset;

import java.util.List;

@PWA(name = "Reference Application - Vaadin 14 w/ MPR", shortName = "Reference Vaadin 14 w/ MPR UI")
@CssImport("./styles/scss/styles.scss")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
@MprTheme("referencempr")
@MprWidgetset("referencempr.gwt.Widgetset")
public class ApplicationLayout extends Div implements RouterLayout {

    private final Div menu;

    private boolean menuOpen = true;
    private Div content;

    public ApplicationLayout() {
        this.setId("application-layout");

        content = new Div();
        content.setId("application-layout_content");

        this.add(getHeader());
        menu = getMenu();
        this.add(menu);
        this.add(content);
        this.add(getFooter());
    }

    /**
     * {@inheritDoc}
     *
     * @throws IllegalArgumentException if content is not a {@link Component}
     */
    @Override
    public void showRouterLayoutContent(HasElement content) {
        Component target = null;
        if (content != null) {
            target = content.getElement().getComponent().orElseThrow(
                    () -> new IllegalArgumentException(
                            "AppLayout content must be a Component"));
        }
        setContent(target);
    }

    private void setContent(Component target) {
        this.content.removeAll();

        if (content != null) {
            this.content.add(target);
        }
    }

    private HorizontalLayout getHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setId("application-layout_header");
        return header;
    }

    private Div getMenu() {
        final Div horizontalLayout = new Div();
        final HorizontalLayout mainMenuLayout = new HorizontalLayout();
        mainMenuLayout.setId("application-menu_main-menu");

        if (!menuOpen) {
            mainMenuLayout.addClassName("collapsed");
        }

        List<RouteData> availableRoutes = RouteConfiguration.forApplicationScope().getAvailableRoutes();
        availableRoutes.forEach(route -> {
            mainMenuLayout.add(new Anchor(route.getUrl(), route.getUrl()));
        });
        Button menuToggle = new Button("Toggle menu");
        menuToggle.addClickListener(event -> this.handleMenuToggle());
        mainMenuLayout.add(menuToggle);

        final HorizontalLayout submenuLayout = new HorizontalLayout();
        submenuLayout.setId("application-menu_sub-menu");

        horizontalLayout.setId("application-layout_menu");
        horizontalLayout.add(mainMenuLayout);
        horizontalLayout.add(submenuLayout);
        return horizontalLayout;
    }

    private void handleMenuToggle() {
        this.menuOpen = !this.menuOpen;
        if (this.menuOpen) {
            this.menu.removeClassName("collapsed");
            this.content.removeClassName("menu-collapsed");
        } else {
            this.menu.addClassName("collapsed");
            this.content.addClassName("menu-collapsed");
        }
    }

    private HorizontalLayout getFooter() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setId("application-layout_footer");
        horizontalLayout.addClassName("dashboard");
        return horizontalLayout;
    }

}
