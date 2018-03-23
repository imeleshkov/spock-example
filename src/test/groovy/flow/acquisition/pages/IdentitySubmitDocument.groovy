package flow.acquisition.pages

import flow.common.Browser
import flow.common.IForm
import flow.common.Page
import groovy.json.JsonSlurper
import org.jsoup.nodes.Document

/**
 * This object represents response of continue button on identity check page
 */
class IdentitySubmitDocument extends Page {

    private static final String INTERACTIVE_ID_SELECTOR = '#interactiveId'
    private static final String TRANSACTION_KEY_SELECTOR = '#transactionKey'

    IdentitySubmitDocument(Document page) {
        super(page)
    }

    /**
     * Method returns "transaction key" field value from hidden form
     * @return
     */
    String getTransactionKey() {
        return find(TRANSACTION_KEY_SELECTOR).attr('value')
    }

    /**
     * Method returns "interactive id" field value from hidden form
     * @return
     */
    String getInteractiveId() {
        return find(INTERACTIVE_ID_SELECTOR).attr('value')
    }

    def submitForm(Browser browser, IForm form) {

        def response = browser.ajaxForm(form.getAction(), this, form.getFormData())
        def jsonSlurper = new JsonSlurper()
        def responseJson = jsonSlurper.parseText(response)
        return responseJson
    }

}
