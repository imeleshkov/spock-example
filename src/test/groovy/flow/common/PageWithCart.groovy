package flow.common

import org.jsoup.nodes.Document

/**
 * This object represents common functionality of pages with cart section
 */
class PageWithCart extends Page {



    PageWithCart(Document page) {
        super(page)
    }

    CartTotal getCartTotal() {
        def selector = '#your-basket-total'
        return new CartTotal(find(selector))
    }
}
