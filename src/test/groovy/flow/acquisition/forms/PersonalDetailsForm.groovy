package flow.acquisition.forms

import flow.common.CSRFToken
import flow.common.E2ETestUser
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
                'alternateDelivery'         : true,
                'currentAddress.apartment'  : E2ETestUser.AcquisitionFlowUser.APARTMENT,
                'currentAddress.building'   : E2ETestUser.AcquisitionFlowUser.BUILDING,
                'currentAddress.companyName': E2ETestUser.AcquisitionFlowUser.COMPANY_NAME,
                'currentAddress.county'     : E2ETestUser.AcquisitionFlowUser.COUNTY,
                'currentAddress.line1'      : E2ETestUser.AcquisitionFlowUser.ADDRESS_LINE_ONE,
                'currentAddress.postalCode' : E2ETestUser.AcquisitionFlowUser.POST_CODE,
                'currentAddress.town'       : E2ETestUser.AcquisitionFlowUser.TOWN,
                'currentAddressMonth'       : E2ETestUser.AcquisitionFlowUser.EMPLOYMENT_MONTH,
                'currentAddressPostCode'    : E2ETestUser.AcquisitionFlowUser.POST_CODE,
                'currentAddressYear'        : E2ETestUser.AcquisitionFlowUser.EMPLOYMENT_YEAR,
                'dobDD'                     : E2ETestUser.AcquisitionFlowUser.DAY_OF_BIRTH,
                'dobMM'                     : E2ETestUser.AcquisitionFlowUser.MONTH_OF_BIRTH,
                'dobYYYY'                   : E2ETestUser.AcquisitionFlowUser.YEAR_OF_BIRTH,
                'email'                     : E2ETestUser.AcquisitionFlowUser.EMAIL,
                'employmentType'            : 'officeBased',
                'firstName'                 : E2ETestUser.AcquisitionFlowUser.NAME.split(' ')[0],
                'lastName'                  : E2ETestUser.AcquisitionFlowUser.NAME.split(' ')[1],
                'mobileNumber'              : E2ETestUser.AcquisitionFlowUser.PHONE,
                'overseasAddress'           : false,
                'overseasCountry'           : 'unselected',
                'residentialStatus'         : 'livesWithParents',
                'startMonthOfBank'          : E2ETestUser.AcquisitionFlowUser.EMPLOYMENT_MONTH,
                'startMonthOfEmployment'    : E2ETestUser.AcquisitionFlowUser.EMPLOYMENT_MONTH,
                'startYearOfBank'           : E2ETestUser.AcquisitionFlowUser.EMPLOYMENT_YEAR,
                'startYearOfEmployment'     : E2ETestUser.AcquisitionFlowUser.EMPLOYMENT_YEAR,
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
