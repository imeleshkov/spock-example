package flow.acquisition.pages

import flow.common.WebSecurePageFrame
import org.jsoup.nodes.Document

/**
 * This object represents iframe on Web secure page
 */
class AcquisitionSecurePageFrame extends WebSecurePageFrame {
    AcquisitionSecurePageFrame(Document page) {
        super(page)
    }
}
