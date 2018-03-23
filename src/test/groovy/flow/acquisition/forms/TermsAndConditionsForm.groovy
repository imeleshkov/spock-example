package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.IForm

/**
 * This object represents terms and conditions form
 */
class TermsAndConditionsForm implements IForm {

    private Map data
    private String action = '/checkout/multi/terms-and-conditions'

    TermsAndConditionsForm(CSRFToken token) {
        this.data = [
                'CSRFToken'    : token.value,
                '_acceptedTermsAndConditions' : [
                        '0' : 'on',
                        '1' : 'on'
                ],
                '_checkedCoverage' : 'on',
                'acceptedTermsAndConditions' : 'true',
                'checkedCoverage' : 'true'
        ]
    }

    @Override
    Map getFormData() {
        return data
    }

    @Override
    String getAction() {
        return action
    }
}
