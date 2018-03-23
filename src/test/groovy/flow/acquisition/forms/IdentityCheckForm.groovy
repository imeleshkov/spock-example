package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.IForm

/**
 * This object represents form on identity check page
 */
class IdentityCheckForm implements IForm {

    private Map data
    private String action = '/checkout/multi/identity-submit'

    IdentityCheckForm(CSRFToken token, String transactionKey, String interactiveId) {
        this.data = [
                'CSRFToken': token.value,
                'hiddenQ-1' : 'q_1',
                'hiddenQ-2' : 'q_2',
                'hiddenQ-3' : 'q_3',
                'hiddenQ-4' : 'q_4',
                'hiddenQ-5' : 'q_5',
                'interactiveId' : interactiveId,
                'questions[1]' : '5',
                'questions[2]' : '5',
                'questions[3]' : 'unselected',
                'questions[4]' : 'unselected',
                'questions[5]' : 'unselected',
                'transactionKey' : transactionKey
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
