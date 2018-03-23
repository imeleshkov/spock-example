package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.IForm

/**
 * This object represents fulfillment form on direct debit page
 */
class DirectDebitForm implements IForm {

    private Map data
    private String action = '/checkout/multi/direct-debit'

    DirectDebitForm(CSRFToken token) {
        this.data = [
                'CSRFToken'    : token.value,
                'accountName'  : 'John Black',
                'accountNumber': '44444444',
                'paymentMethod': 'DIRECT_DEBIT',
                'sortCode1'    : '12',
                'sortCode2'    : '12',
                'sortCode3'    : '12'
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
