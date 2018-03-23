package flow.acquisition.pages

import flow.common.E2ETestUser
import flow.common.Money
import flow.common.MoneyBuilder
import flow.common.OrderConfirmationPage
import org.jsoup.nodes.Document

/**
 * This object represents final order confirmation page on Acquisition flow
 */
class AcquisitionOrderConfirmationPage extends OrderConfirmationPage {

    private final static String USER_INFO_SELECTOR = '.your-details'
    private final static String BILLING_INFORMATION_DIV_SELECTOR = "${USER_INFO_SELECTOR} > div:contains(Billing information)"
    private final static String PAYMENT_DETAILS_DIV_SELECTOR = "${USER_INFO_SELECTOR} > div:contains(Payment details)"

    AcquisitionOrderConfirmationPage(Document page) {
        super(page)
    }

    /**
     * Returns user name from "Your details" section
     * @return
     */
    @Override
    String getUserName() {
        String dirtyName = element.select("${USER_INFO_SELECTOR} > div.col > p").first().text()
        String nameCleanedFromNBSP = dirtyName.replace('\u00A0\u00A0', ' ')
        String cleanName = nameCleanedFromNBSP.replace('mr ', '')
        return cleanName
    }

    /**
     * Returns ordered phone title from "Your order summary" section
     * @return
     */
    String getPhoneTitle() {
        return element.select(".prod-name").first().text()
    }

    /**
     * Returns ordered new plan from "Review your order" section
     * @return
     */
    String getNewPlan() {
        return element.select(".prod-info > div > ul").first().text()
    }

    /**
     * Returns pay today value from "Review your order" section
     * @return
     */
    Money getPayToday() {
        return MoneyBuilder.fromElement(element.select(".panel > .price").first()).build()
    }

    /**
     * Returns monthly cost from "Review your order" section
     * @return
     */
    Money getMonthlyCost() {
        return MoneyBuilder.fromElement(element.select(".panel > .price").get(1)).build()
    }
}
