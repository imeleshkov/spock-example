package flow.common

import org.jsoup.nodes.Element

/**
 * This object represents Your basket section
 */
class Basket extends ElementWrapper {

    private final static String PRODUCT_TITLE_SELECTOR = ".ee-upgrade-title"
    private final static String PRODUCT_CAPACITY_SELECTOR = ".ee-upgrade-spec-capacity"
    private final static String PRODUCT_COLOUR_SELECTOR = ".ee-upgrade-spec-colour"
    private final static String PAY_TODAY_SELECTOR = ".pay-today-total"
    private final static String MONTHLY_COST_SELECTOR = ".pay-monthly-total-value"

    Basket(Element element) {
        super(element)
    }

    /**
     * Returns the title portion of the name of shown phone.
     * @return
     */
    String getPhoneTitle() {
        return find(PRODUCT_TITLE_SELECTOR).text()
    }

    /**
     * Returns the capacity portion of the name of shown phone.
     * @return
     */
    String getPhoneCapacity() {
        return find(PRODUCT_CAPACITY_SELECTOR).text()
    }

    /**
     * Returns the colour portion of the name of shown phone.
     * @return
     */
    String getPhoneColour() {
        return find(PRODUCT_COLOUR_SELECTOR).text()
    }

    /**
     * Returns pay today total value from basket section
     * @return
     */
    Money getPayToday() {
        Element priceElem = find(PAY_TODAY_SELECTOR)
        return MoneyBuilder.fromElement(priceElem).build()
    }

    /**
     * Returns monthly cost total value from basket section
     * @return
     */
    Money getMonthlyCost() {
        Element priceElem = find(MONTHLY_COST_SELECTOR)
        return MoneyBuilder.fromElement(priceElem).build()
    }

    BasketTestData getTestData() {
        return BasketTestData.getBuilder()
                .title(getPhoneTitle())
                .phoneCapacity(getPhoneCapacity())
                .phoneColour(getPhoneColour())
                .payToday(getPayToday())
                .monthlyCost(getMonthlyCost())
                .build()
    }
}
