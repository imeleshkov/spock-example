package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.E2ETestUser
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
                'accountName'  : E2ETestUser.AcquisitionFlowUser.NAME,
                'accountNumber': E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.CARD_ACCOUNT_NUMBER,
                'paymentMethod': E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.PAYMENT_METHOD.replace(' ', '_').toUpperCase(),
                'sortCode1'    : E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.SORT_CODE.substring(0, 2),
                'sortCode2'    : E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.SORT_CODE.substring(2, 4),
                'sortCode3'    : E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.SORT_CODE.substring(4, 6)
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
