package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.IForm
import groovy.text.SimpleTemplateEngine

/**
 * This object represents continue button hidden form on identity check page
 */
class IdentityContinueForm implements IForm {

    private Map data
    private String action = '/checkout/multi/identity-check'
    def template = new SimpleTemplateEngine().createTemplate(action).make()

    IdentityContinueForm(CSRFToken token) {
        this.data = [
                'CSRFToken': token.value,
        ]
    }

    @Override
    Map getFormData() {
        return data
    }

    @Override
    String getAction() {
        return template.toString()
    }
}
