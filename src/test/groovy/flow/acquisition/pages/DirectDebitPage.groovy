package flow.acquisition.pages

import flow.common.Page
import org.jsoup.nodes.Document

/**
 * This object represents page with direct debit fulfillment form
 */
class DirectDebitPage extends Page {
    DirectDebitPage(Document page) {
        super(page)
    }
}
