package flow.acquisition.pages

import flow.common.Basket
import flow.common.Money
import flow.common.MoneyBuilder
import org.jsoup.nodes.Element

/**
 * This object represents Your basket section for Acquisition flow
 */
class AcquisitionBasket extends Basket {

    private final static String PRODUCT_TITLE_SELECTOR = "div.prod-info > div > .product-name"
    private final static String PRODUCT_PROPERTY_SELECTOR = "div.prod-info > div > span"
    private final static String TOTAL_COST_SELECTOR = "tr.resume > .price"

    AcquisitionBasket(Element element) {
        super(element)
    }

    /**
     * Returns the title portion of the name of shown phone.
     * @return
     */
    @Override
    String getPhoneTitle() {
        return find(PRODUCT_TITLE_SELECTOR).text()
    }

    /**
     * Returns the capacity portion of the name of shown phone.
     * @return
     */
    @Override
    String getPhoneCapacity() {
        return element.select(PRODUCT_PROPERTY_SELECTOR).first().text()
    }

    /**
     * Returns the colour portion of the name of shown phone.
     * @return
     */
    @Override
    String getPhoneColour() {
        return element.select(PRODUCT_PROPERTY_SELECTOR).get(1).text()
    }

    /**
     * Returns pay today total value from basket section
     * @return
     */
    @Override
    Money getPayToday() {
        Element priceElem = element.select(TOTAL_COST_SELECTOR).first()
        return MoneyBuilder.fromElement(priceElem).build()
    }

    /**
     * Returns monthly cost total value from basket section
     * @return
     */
    @Override
    Money getMonthlyCost() {
        Element priceElem = element.select(TOTAL_COST_SELECTOR).get(1)
        return MoneyBuilder.fromElement(priceElem).build()
    }
}
