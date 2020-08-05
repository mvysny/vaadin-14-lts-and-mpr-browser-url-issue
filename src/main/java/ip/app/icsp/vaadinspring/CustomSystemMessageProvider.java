package ip.app.icsp.vaadinspring;

import com.vaadin.flow.server.CustomizedSystemMessages;
import com.vaadin.flow.server.SystemMessages;
import com.vaadin.flow.server.SystemMessagesInfo;
import com.vaadin.flow.server.SystemMessagesProvider;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

/**
 * {@link SystemMessagesProvider} for localized system messages.
 */
@SuppressWarnings ( "serial" )
public class CustomSystemMessageProvider implements SystemMessagesProvider {

    private static final String CUSTOM_ERROR_WINDOW
        = "<div class=\"container\">"
            + "  <section class=\"notif notif-info\">"
            + "    <h1 class=\"notif-title\">{0}</h1>"
            + "    <div class=\"notif-content\">{1}</div>"
            + "    <div class=\"notif-footer\">{2}</div>"
            + "    <div class=\"notif-controls\">"
            + "      <a href=\"/\" class=\"notif-control notif-close\">Close</a>"
            + "    </div>"
            + "  </section>"
            + "</div>"
            //Hide the reason text (useless informations at this point)
            + "</div><div style=\"display:none !important;\">";

    private static final String LABEL = "<div class=\"v-label v-widget\">{0}</div>";

    private static final String BUTTON
        = "<div tabindex=\"0\" role=\"button\" class=\"v-button v-button-footerButton {1} v-widget\">"
            + "<span class=\"v-button-wrap\"><span class=\"v-icon css-icon\"></span><span class=\"v-button-caption\">{0}</span></span></div>";

    private final CustomizedSystemMessages messages = new CustomizedSystemMessages ();
    private String refreshCaption = "Refresh";

    /**
     * Constructor.
     */
    public CustomSystemMessageProvider () {
        customizeCommunicationError ();
        customizeInternalError ();
        customizeAuthenticationError ();
        customizeCookiesDisabled ();
        customizeSessionExpired ();
    }

    private void customizeCommunicationError () {
//        String caption = messages.get ();
//        String message = messages.getCommunicationErrorMessage ();
//        messages.setCommunicationErrorCaption ( StringUtils.EMPTY );
//        messages.setCommunicationErrorMessage ( getCustomErrorWindow ( caption, getLabel ( message ), getRefreshButton () ) );
    }

    private void customizeAuthenticationError () {
//        String caption = messages.getAuthenticationErrorCaption ();
//        String message = messages.getAuthenticationErrorMessage ();
//        messages.setAuthenticationErrorCaption ( StringUtils.EMPTY );
//        messages.setAuthenticationErrorMessage ( getCustomErrorWindow ( caption, getLabel ( message ), getRefreshButton () ) );
    }

    private void customizeCookiesDisabled () {
        String caption = messages.getCookiesDisabledCaption ();
        String message = messages.getCookiesDisabledMessage ();
        messages.setCookiesDisabledCaption ( StringUtils.EMPTY );
        messages.setCookiesDisabledMessage ( getCustomErrorWindow ( caption, getLabel ( message ), getRefreshButton () ) );
    }

    private void customizeSessionExpired () {
        String caption = messages.getSessionExpiredCaption ();
        String message = messages.getSessionExpiredMessage ();
        messages.setSessionExpiredCaption ( StringUtils.EMPTY );
        messages.setSessionExpiredMessage ( getCustomErrorWindow ( caption, getLabel ( message ), getRefreshButton () ) );
    }

    private void customizeInternalError () {
        String caption = messages.getInternalErrorCaption ();
        String message = messages.getInternalErrorMessage ();
        messages.setInternalErrorCaption ( StringUtils.EMPTY );
        messages.setInternalErrorMessage ( getCustomErrorWindow ( caption, getLabel ( message ), getRefreshButton () ) );
    }

    private String getLabel ( String content ) {
        return MessageFormat.format ( LABEL, content );
    }

    private String getRefreshButton () {
        return getButton ( refreshCaption, "refresh" );
    }

    @SuppressFBWarnings( "CBX_CUSTOM_BUILT_XML" )
    private String getButton ( String caption, String style ) {
        return MessageFormat.format ( BUTTON, caption, style );
    }

    @SuppressFBWarnings ( "CBX_CUSTOM_BUILT_XML" )
    private String getCustomErrorWindow ( String windowCaption, String content, String footer ) {
        return MessageFormat.format ( CUSTOM_ERROR_WINDOW, windowCaption, content, footer );
    }

    @Override
    public SystemMessages getSystemMessages ( SystemMessagesInfo systemMessagesInfo ) {
        return messages;
    }

}
