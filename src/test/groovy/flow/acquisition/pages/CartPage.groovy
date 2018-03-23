package flow.acquisition.pages

import flow.common.PageWithCart
import org.jsoup.nodes.Document

/**
 * This page object represents the cart page.
 */
class CartPage extends PageWithCart {

    private CartPage(Document page) {
        super(page)
    }
}
