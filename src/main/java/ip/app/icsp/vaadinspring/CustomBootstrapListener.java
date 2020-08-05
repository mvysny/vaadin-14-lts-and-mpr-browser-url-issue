package ip.app.icsp.vaadinspring;

import com.vaadin.flow.server.BootstrapListener;
import com.vaadin.flow.server.BootstrapPageResponse;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CustomBootstrapListener implements BootstrapListener {

    private String googleTagManagerHeader = "(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':\r\n"
            + "new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],\r\n"
            + "j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=\r\n"
            + "'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);\r\n"
            + "})(window,document,'script','dataLayer','GTM-NPGXSDX');";

    private String googleTagManagerBody = "<iframe src=\"https://www.googletagmanager.com/ns.html?id=GTM-NPGXSDX\"\n"
            + "height=\"0\" width=\"0\" style=\"display:none;visibility:hidden\"></iframe>";

    public void modifyBootstrapPage(BootstrapPageResponse response) {
        Document document = response.getDocument();

        document.title("Reference Vaadin 14 w/ MPR UI");

        document.head().prependChild(createScript(document, googleTagManagerHeader));
        document.body().prependChild(createNoScript(document, googleTagManagerBody));
    }

    private Element createNoScript(Document document, String noScriptContent) {
        return document.createElement("noscript")
                .html(noScriptContent);
    }

    private Element createScript(Document document, String scriptContent) {
        return document.createElement("script")
                .attr("type", "text/javascript")
                .text(scriptContent);
    }
}

