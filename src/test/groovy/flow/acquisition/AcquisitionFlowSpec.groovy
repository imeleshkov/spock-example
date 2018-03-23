package flow.acquisition

import flow.acquisition.forms.DirectDebitForm
import flow.acquisition.forms.PersonalDetailsForm
import flow.acquisition.forms.TermsAndConditionsForm
import flow.acquisition.pages.AcquisitionPaymentDetailsResponseDocument
import flow.acquisition.pages.AquisitionPayMonthlyPhonesPage
import flow.acquisition.pages.AcquisitionPaymentDetailsPage
import flow.acquisition.pages.CartPage
import flow.acquisition.forms.DeliveryAddressForm
import flow.acquisition.pages.DeliveryPage
import flow.acquisition.pages.DirectDebitPage
import flow.acquisition.pages.HomePage
import flow.acquisition.pages.PersonalDetailsPage
import flow.acquisition.pages.TccHostedPage
import flow.acquisition.pages.TermsAndConditionsPage
import flow.common.BasketTestData
import flow.common.Browser
import flow.common.CarouselItem
import flow.common.CheckoutPage
import flow.common.CleanActionForm
import flow.common.CommonNavigationComponent
import flow.common.E2ETestPhone
import flow.common.E2ETestUser
import flow.common.EndToEndTest
import flow.common.Gallery
import flow.common.GalleryItem
import flow.common.PaymentDetailsForm
import flow.common.PaymentFrame
import flow.common.PhoneDetailsPage
import flow.common.ServicePlanCarousel
import org.junit.experimental.categories.Category
import spock.lang.Shared
import spock.lang.Specification

/**
 * Multi step test which covers "acquisition" scenario
 */
@Category(EndToEndTest.class)
//@Stepwise
class AcquisitionFlowSpec extends Specification {

    @Shared
    Browser browser = new Browser()

    def 'An anonymous user starts at Home page'() {

        when: 'A user opens a Home page'
        HomePage homePage = browser.open(HomePage.class, false)
        CommonNavigationComponent navBar = homePage.getNavigationBar()

        then: 'the navigation bar should contain link to Pay monthly phones page'
        navBar.containsLink(Browser.getPagePath(AquisitionPayMonthlyPhonesPage.class))
    }

    def 'then goes to Pay monthly phones page '() {
        when: 'A user opens Pay monthly phones page'
        AquisitionPayMonthlyPhonesPage page = browser.open(AquisitionPayMonthlyPhonesPage.class, false)
        Gallery gallery = page.getGallery()

        then: 'a gallery should contain product tile with specific SEO Id'
        GalleryItem galleryItem = gallery.getItemByPrettyId(E2ETestPhone.AcquisitionFlowPhone.PRETTY_ID)

        and: 'tile should display correct information'
        galleryItem.title == E2ETestPhone.AcquisitionFlowPhone.TITLE
        galleryItem.monthlyCost == E2ETestPhone.AcquisitionFlowPhone.MONTHLY_COST
        galleryItem.upfrontCost == E2ETestPhone.AcquisitionFlowPhone.UPFRONT_COST
    }

    def 'then goes to Phone details page and adds bundle to cart'() {
        when: 'A user opens Phone details page'
        PhoneDetailsPage page = browser.open(PhoneDetailsPage.class, false,
                [categoryCode : E2ETestPhone.AcquisitionFlowPhone.CATEGORY,
                 seoBundleType: E2ETestPhone.AcquisitionFlowPhone.SEO_BUNDLE_TYPE,
                 prettyId     : E2ETestPhone.AcquisitionFlowPhone.PRETTY_ID
                ])
        then: 'the page should display correct phone information'
        page.phoneTitle == E2ETestPhone.AcquisitionFlowPhone.TITLE
        page.phoneCapacity == E2ETestPhone.AcquisitionFlowPhone.CAPACITY
        page.phoneColour == E2ETestPhone.AcquisitionFlowPhone.COLOUR

        and: 'the page should display list of available plans'
        ServicePlanCarousel planCarousel = page.getServicePlanCarousel()
        List<CarouselItem> carouselItems = planCarousel.getListItems()
        carouselItems.size() == 5

        and: 'the correct service plan displayed as first in carousel'
        def servicePlan = carouselItems.first()
        servicePlan.data == E2ETestPhone.AcquisitionFlowPhone.ServicePlan.DATA
        servicePlan.monthlyCost == E2ETestPhone.AcquisitionFlowPhone.ServicePlan.MONTHLY_COST
        servicePlan.handsetCost == E2ETestPhone.AcquisitionFlowPhone.ServicePlan.HANDSET_COST
        servicePlan.hasMinutes(E2ETestPhone.AcquisitionFlowPhone.ServicePlan.MINUTES)
        servicePlan.hasTexts(E2ETestPhone.AcquisitionFlowPhone.ServicePlan.TEXTS)

        and: 'a user able to add phone & service plan bundle to cart'
        def form = servicePlan.getAddBundleToCartForm()
        browser.submit(form) == CartPage.class
    }

    def 'then user lands at cart page'() {
        when: 'A user sees recently added bundle at cart page'
        CartPage page = browser.open(CartPage.class, false)

        then: 'cart page should have correct total values'
        def cartTotal = page.getCartTotal()
        cartTotal.payToday == E2ETestPhone.AcquisitionFlowPhone.ServicePlan.HANDSET_COST
        cartTotal.payMonthly == E2ETestPhone.AcquisitionFlowPhone.ServicePlan.MONTHLY_COST
    }

    def 'then user choose delivery option'() {
        when: 'A user goes to Delivery page'
        DeliveryPage page = browser.open(DeliveryPage.class, false)

        then: 'cart page should have correct total values'
        def cartTotal = page.getCartTotal()
        cartTotal.payToday == E2ETestPhone.AcquisitionFlowPhone.ServicePlan.HANDSET_COST
        cartTotal.payMonthly == E2ETestPhone.AcquisitionFlowPhone.ServicePlan.MONTHLY_COST

        and: 'user fills in delivery form with data and submit'
        DeliveryAddressForm deliveryForm = new DeliveryAddressForm(page.getToken())
        browser.submit(deliveryForm) == CheckoutPage.class
    }

    def 'User lands on multistep checkout page'() {
        when: 'personal details page opens'
        browser.open(CheckoutPage.class, false)
        PersonalDetailsPage page = browser.open(PersonalDetailsPage.class, false)

        then: 'page should have correct basket information'
        def basketTestData = BasketTestData.getBuilder()
                .title(E2ETestPhone.AcquisitionFlowPhone.TITLE)
                .phoneCapacity(E2ETestPhone.AcquisitionFlowPhone.CAPACITY)
                .phoneColour(E2ETestPhone.AcquisitionFlowPhone.COLOUR)
                .payToday(E2ETestPhone.AcquisitionFlowPhone.ServicePlan.HANDSET_COST)
                .monthlyCost(E2ETestPhone.AcquisitionFlowPhone.ServicePlan.MONTHLY_COST)
                .build()
        page.basket.testData == basketTestData

        and: 'form should redirect to direct debit page'
        PersonalDetailsForm personalForm = new PersonalDetailsForm(page.getToken())
        browser.submit(personalForm) == DirectDebitPage.class

        when: 'user lands on direct debit page'
        DirectDebitPage debitPage = browser.open(DirectDebitPage.class, false)

        then: 'page should have correct basket information'
        debitPage.basket.testData == basketTestData
        DirectDebitForm debitForm = new DirectDebitForm(debitPage.getToken())
        browser.submit(debitForm) == TermsAndConditionsPage.class

        when: 'user lands on Terms and Conditions page'
        TermsAndConditionsPage termsPage = browser.open(TermsAndConditionsPage.class, false)

        then: 'page should have correct basket information'
        termsPage.basket.testData == basketTestData
        TermsAndConditionsForm termsForm = new TermsAndConditionsForm(termsPage.getToken())
        browser.submit(termsForm) == TccHostedPage.class

        when: 'Payment page opens'
        TccHostedPage tccPage = browser.open(TccHostedPage.class, false)

        then: 'hidden initialize page loading'
        CleanActionForm payloadForm = tccPage.getPayload()

        when: 'hidden initialize page processed successfully'
        String response = browser.submitMockForRedirect(payloadForm)

        then: 'server redirects to correct page'
        response.contains("/payment")

        when: 'user finally lands on payment page'
        AcquisitionPaymentDetailsPage paymentPage = browser.open(AcquisitionPaymentDetailsPage.class, false)

        then: 'page contains correct information'
        paymentPage.basket.testData == basketTestData

        when: 'iframe loads'
        PaymentFrame frame = browser.open(PaymentFrame.class, true)

        then: 'iframe loaded correctly'
        frame.checkPaymentForm()

        when: 'the user submits payment details form'
        PaymentDetailsForm form = PaymentDetailsForm.getBuilder()
                .cardSecurityCode(E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.SECURITY_CODE)
                .creditCardNumber(E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.CARD_NUMBER)
                .creditCardType(E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.CARD_TYPE)
                .csrfToken(frame.getToken().getValue())
                .expirationMonth(E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.CARD_EXPIRE_MONTH)
                .expirationYear(E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.CARD_EXPIRE_YEAR)
                .nameOnCard(E2ETestUser.AcquisitionFlowUser.AcquisitionCreditCard.NAME_ON_CARD)
                .build()
        AcquisitionPaymentDetailsResponseDocument cardDetailsResponse = browser.submitMockForDocument(AcquisitionPaymentDetailsResponseDocument.class, form)

        then: 'response contains success form'
        cardDetailsResponse.checkFormAction()

    }


}
