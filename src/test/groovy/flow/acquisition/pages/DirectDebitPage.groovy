package flow.acquisition.pages

import org.jsoup.nodes.Document

/**
 * This object represents page with direct debit fulfillment form
 */
class DirectDebitPage extends PageWithAcqusitionBasket {
    DirectDebitPage(Document page) {
        super(page)
    }
}
