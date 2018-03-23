package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.IForm

/**
 * This object represents personal details form on checkout page
 */
class PersonalDetailsForm implements IForm {

    private Map data
    private String action = '/checkout/multi/personal-details'

    PersonalDetailsForm(CSRFToken token) {
        this.data = [
                'CSRFToken'                 : token.value,
                '_alternateDelivery'        : 'on',
                '_keepMyNumber'             : 'on',
                'alternateDelivery'         : 'true',
                'currentAddress.apartment'  : 'Unit 1-4',
                'currentAddress.building'   : 'Trident Place',
                'currentAddress.companyName': 'E E Ltd',
                'currentAddress.county'     : 'Hertfordshire',
                'currentAddress.line1'      : 'Mosquito Way',
                'currentAddress.postalCode' : 'AL10 9BW',
                'currentAddress.town'       : 'HATFIELD',
                'currentAddressMonth'       : '4',
                'currentAddressPostCode'    : 'AL10 9BW',
                'currentAddressYear'        : '2010',
                'dobDD'                     : '12',
                'dobMM'                     : '11',
                'dobYYYY'                   : '1991',
                'email'                     : 'asd@asd.com',
                'employmentType'            : 'officeBased',
                'firstName'                 : 'John',
                'lastName'                  : 'Black',
                'mobileNumber'              : '07123123123',
                'overseasAddress'           : 'false',
                'overseasCountry'           : 'unselected',
                'residentialStatus'         : 'livesWithParents',
                'startMonthOfBank'          : '5',
                'startMonthOfEmployment'    : '5',
                'startYearOfBank'           : '2014',
                'startYearOfEmployment'     : '2014',
                'titleCode'                 : 'mr'
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
