package flow.acquisition.pages

import flow.common.ThreeDSBreakoutPage
import org.jsoup.nodes.Document

/**
 * This object represents intermediate secure processing page on Acquisition flow
 */
class AcquisitionThreeDSBreakoutPage extends ThreeDSBreakoutPage {
    AcquisitionThreeDSBreakoutPage(Document page) {
        super(page)
    }

    /**
     * Method returns part of form action that represents order id
     * @return
     */
    String getOrderId() {
        return find('form').attr('action').split('/')[3]
    }
}
