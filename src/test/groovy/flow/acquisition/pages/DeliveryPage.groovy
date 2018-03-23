package flow.acquisition.pages

import flow.common.CSRFToken
import flow.common.PageWithCart
import org.jsoup.nodes.Document

/**
 * This page object represents the Delivery page.
 */
class DeliveryPage extends PageWithCart {

    private DeliveryPage(Document page) {
        super(page)
    }

    @Override
    CSRFToken getToken() {
        String value = element.select('input[name=CSRFToken]').attr('value')
        String name = element.select('input[name=CSRFToken]').attr('name')
        return new CSRFToken(name, value)
    }

}
