package flow.acquisition.forms

import flow.common.CSRFToken
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
                'deliveryAddress.apartment'  : 'Unit+1-4',
                'deliveryAddress.building'   : 'Trident+Place',
                'deliveryAddress.companyname': 'E+E+Ltd',
                'deliveryAddress.county'     : 'Hertfordshire',
                'deliveryAddress.line1'      : 'Mosquito+Way',
                'deliveryAddress.postalCode' : 'AL10+9BW',
                'deliveryAddress.town'       : 'HATFIELD',
                'deliveryAddressOption'      : false,
                'deliveryAddressPostCode'    : 'A10+9BW'
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
