package ip.app.icsp.vaadinspring;

import com.vaadin.flow.server.VaadinServlet;

import javax.servlet.ServletException;

/**
 * Custom {@link VaadinServlet} to provide the possibility to customize the system messages.
 */
@SuppressWarnings ( "serial" )
public class CustomSpringServlet extends VaadinServlet {

    @Override
    public void servletInitialized () throws ServletException {
        super.servletInitialized ();
//        getService ().setSystemMessagesProvider ( new CustomSystemMessageProvider () );
    }

}