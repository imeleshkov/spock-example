package flow.acquisition.pages

import flow.common.PaymentDetailsResponseDocument
import org.jsoup.nodes.Document

/**
 * This object represents response document of payment details submit request for Acquisition flow
 */
class AcquisitionPaymentDetailsResponseDocument extends PaymentDetailsResponseDocument {

    AcquisitionPaymentDetailsResponseDocument(Document page) {
        super(page)
    }

    @Override
    boolean checkFormAction() {
        return find('form').attr('action').contains('tccRedirect')
    }
}
