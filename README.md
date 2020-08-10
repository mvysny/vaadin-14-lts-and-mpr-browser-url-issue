# Steps to reproduce browser URL issue

1. Build project
2. Start
3. Navigate to 'http://localhost:8080/reference-vaadin-14-lts'  
    **Result:** Redirect triggered in `ContextRootRedirectListener` and browser displays URL http://localhost:8080/reference-vaadin-14-lts/ui (this is expected)
4. Refresh the browser using either
    * `F5`
    * `Str+R`
    * `Browser Refresh Button`  
    **Result**: No redirect triggered in `ContextRootRedirectListener` (since path is already `ui`), but browser displays URL http://localhost:8080/reference-vaadin-14-lts/
