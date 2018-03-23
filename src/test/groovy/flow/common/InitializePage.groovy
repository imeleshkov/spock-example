package flow.common

import org.jsoup.nodes.Document
import org.jsoup.nodes.FormElement

/**
 * This object represents common initialize page
 */
class InitializePage extends Page {

    private static final PAYLOAD_FORM_SELECTOR = '#initcardcapture'

    InitializePage(Document page) {
        super(page)
    }

    CleanActionForm getPayload() {
        def payloadForm = find(PAYLOAD_FORM_SELECTOR)
        return new CleanActionForm(payloadForm as FormElement)
    }
}
