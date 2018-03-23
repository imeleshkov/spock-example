package flow.common

import flow.acquisition.pages.AcquisitionPaymentDetailsPage
import flow.acquisition.pages.AquisitionPayMonthlyPhonesPage
import flow.acquisition.pages.CartPage
import flow.acquisition.pages.DeliveryPage
import flow.acquisition.pages.DirectDebitPage
import flow.acquisition.pages.HomePage
import flow.acquisition.pages.PersonalDetailsPage
import flow.acquisition.pages.TccHostedPage
import flow.acquisition.pages.TermsAndConditionsPage
import flow.addline.pages.AddLineCheckoutPage
import flow.addline.pages.AddLineExtrasPage
import flow.addline.pages.AddLineInitPage
import flow.addline.pages.AddLineOrderConfirmationPage
import flow.addline.pages.AddLinePayMonthlyPhonesPage
import flow.addline.pages.AddLinePaymentPage
import flow.addline.pages.AddLinePersonalizedHomePage
import flow.addline.pages.AddLineWebSecurePage
import flow.upgrade.pages.RecommendationsPage
import flow.upgrade.pages.UpgradeAccessoriesPage
import flow.upgrade.pages.UpgradeCheckoutPage
import flow.upgrade.pages.UpgradeExtrasPage
import flow.upgrade.pages.UpgradeInitPage
import flow.upgrade.pages.UpgradeOrderConfirmationPage
import flow.upgrade.pages.UpgradePayMonthlyPhonesPage
import flow.upgrade.pages.UpgradePaymentPage
import flow.upgrade.pages.UpgradePersonalizedHomePage
import flow.upgrade.pages.UpgradeWebSecurePage

/**
 * This class contains full list of pages mapping
 */
class PagesPathsMap {

    final pathsMap

    PagesPathsMap() {
        this.pathsMap = [
                //Acquisition flow
                (HomePage.class)                      : '/',
                (AquisitionPayMonthlyPhonesPage.class): '/mobile-phones/pay-monthly/gallery?search=:best-sellers',
                (PhoneDetailsPage.class)              : '/$categoryCode/$seoBundleType/$prettyId/details',
                (CartPage.class)                      : '/cart',
                (DeliveryPage.class)                  : '/delivery',
                (CheckoutPage.class)                  : '/checkout',
                (PersonalDetailsPage.class)           : '/checkout/multi/personal-details',
                (DirectDebitPage.class)               : '/checkout/multi/direct-debit',
                (TermsAndConditionsPage.class)        : '/checkout/multi/terms-and-conditions',
                (AcquisitionPaymentDetailsPage.class) : '/checkout/multi/payment-details',
                (TccHostedPage.class)                 : '/checkout/multi/tccHostedPage',
                //AddLine flow
                (AddLinePersonalizedHomePage.class)   : '/auth/my-shop',
                (AddLinePayMonthlyPhonesPage.class)   : '/auth/mobile-phones/add-pay-monthly/gallery',
                (AddLineExtrasPage.class)             : '/addExtras',
                (AddLineCheckoutPage.class)           : '/addCheckout',
                (AddLineInitPage.class)               : '/addCheckout/payment',
                (AddLinePaymentPage.class)            : '/addCheckout/payment',
                (AddLineWebSecurePage.class)          : '/addCheckout/tcc3ds',
                (AddLineOrderConfirmationPage.class)  : '/addConfirmation',
                //Upgrade flow
                (UpgradePersonalizedHomePage.class)   : '/auth/my-shop',
                (RecommendationsPage.class)           : '/auth/upgrade/recommendations',
                (UpgradeAccessoriesPage.class)        : '/upgradeAccessories',
                (UpgradeExtrasPage.class)             : '/upgradeExtras',
                (UpgradeCheckoutPage.class)           : '/upgradeCheckout',
                (UpgradeInitPage.class)               : '/upgradeCheckout/payment',
                (UpgradePaymentPage.class)            : '/upgradeCheckout/payment',
                (UpgradeWebSecurePage.class)          : '/upgradeCheckout/tcc3ds',
                (UpgradeOrderConfirmationPage.class)  : '/upgradeConfirmation',
                (UpgradePayMonthlyPhonesPage.class)   : '/auth/mobile-phones/upg-pay-monthly/gallery',
                //common
                (PaymentFrame.class)                  : '/TCCDTP/showcardform',
                (WebSecurePageFrame.class)            : '/upgradeCheckout/threeDSHostedPage',
                (WebSecurePageSubmitFrame.class)      : '/mock-iif/tds_acs',
                (ThreeDSBreakoutPage.class)           : '/upgradeCheckout/threeDSBreakout'
        ]
    }
}
