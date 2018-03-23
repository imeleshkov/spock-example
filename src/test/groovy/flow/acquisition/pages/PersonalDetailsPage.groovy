package flow.acquisition.pages

import org.jsoup.nodes.Document

/**
 * This object represents personal details fulfilment page on anonymous flow
 */
class PersonalDetailsPage extends PageWithAcqusitionBasket {
    PersonalDetailsPage(Document page) {
        super(page)
    }
}
