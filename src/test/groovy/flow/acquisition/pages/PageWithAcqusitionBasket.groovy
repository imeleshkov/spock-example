package flow.acquisition.pages

import flow.common.PageWithBasket
import org.jsoup.nodes.Document

/**
 * Represents page with Acquisition flow basket.
 */
class PageWithAcqusitionBasket extends PageWithBasket {

    private final static String BASKET_SELECTOR = ".persistent-cart--movable"

    PageWithAcqusitionBasket(Document page) {
        super(page)
    }

    @Override
    AcquisitionBasket getBasket() {
        return new AcquisitionBasket(find(BASKET_SELECTOR))
    }
}
