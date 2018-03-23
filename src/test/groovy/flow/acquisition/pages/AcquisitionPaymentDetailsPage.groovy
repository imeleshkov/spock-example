package flow.acquisition.pages

import org.jsoup.nodes.Document

/**
 * This object represents payment details page on acquisition flow
 */
class AcquisitionPaymentDetailsPage extends PageWithAcqusitionBasket {
    AcquisitionPaymentDetailsPage(Document page) {
        super(page)
    }
}
