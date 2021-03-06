package flow.acquisition

import org.jsoup.nodes.Document

/**
 * This page object represents the home page.
 */
class HomePage extends Page {
    private static final String NAVIGATION_BAR_ID = "#eed-nav"

    private HomePage(Document page) {
        super(page)
    }

    NavigationBar getNavigationBar() {
        // duplication accepted in order to leverage power assertion statements
        assert !element.select(NAVIGATION_BAR_ID).isEmpty()
        def navBaElem = element.select(NAVIGATION_BAR_ID)
        return new NavigationBar(navBaElem.first())
    }
}
