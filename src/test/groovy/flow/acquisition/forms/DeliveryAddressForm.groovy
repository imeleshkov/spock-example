package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.E2ETestUser
import flow.common.IForm

/**
 * This object represents delivery address form on anonymous checkout flow filled with data
 */
class DeliveryAddressForm implements IForm {

    private Map data
    private String action = '/delivery'

    DeliveryAddressForm(CSRFToken token) {
        this.data = [
                'CSRFToken'                  : token.value,
                'deliveryAddress.apartment'  : E2ETestUser.AcquisitionFlowUser.APARTMENT,
                'deliveryAddress.building'   : E2ETestUser.AcquisitionFlowUser.BUILDING,
                'deliveryAddress.companyname': E2ETestUser.AcquisitionFlowUser.COMPANY_NAME,
                'deliveryAddress.county'     : E2ETestUser.AcquisitionFlowUser.COUNTY,
                'deliveryAddress.line1'      : E2ETestUser.AcquisitionFlowUser.ADDRESS_LINE_ONE,
                'deliveryAddress.postalCode' : E2ETestUser.AcquisitionFlowUser.POST_CODE,
                'deliveryAddress.town'       : E2ETestUser.AcquisitionFlowUser.TOWN,
                'deliveryAddressOption'      : false,
                'deliveryAddressPostCode'    : E2ETestUser.AcquisitionFlowUser.POST_CODE
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
