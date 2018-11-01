package mvvm.demo.shoppingcart._core.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.FragmentKey
import mvvm.demo.shoppingcart._core.di.scope.FragmentScope
import mvvm.demo.shoppingcart._core.di.scope.ViewScope
import mvvm.demo.shoppingcart.view.cart.CartView
import mvvm.demo.shoppingcart.view.product_details.view.ProductDetails
import mvvm.demo.shoppingcart.view.product_list.view.ProductList
import mvvm.demo.shoppingcart.view.profile.GuestView
import mvvm.demo.shoppingcart.view.profile.LoginView
import mvvm.demo.shoppingcart.view.profile.Profile
import mvvm.demo.shoppingcart.view.profile.Signup
import mvvm.demo.shoppingcart.view.promo.PromoView

/**
 * Created by Sudeep SR on 13/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

@Module(includes = [ViewModelModule::class])
abstract class FragmentModule {



    @ContributesAndroidInjector
    abstract fun contributeProductList():ProductList


    @ContributesAndroidInjector
    abstract fun contributeCart():CartView


    @ContributesAndroidInjector
    abstract fun contributeGuest():GuestView


    @ContributesAndroidInjector
    abstract fun contributeProductDetailsView():ProductDetails

    @ContributesAndroidInjector
    abstract  fun contributeLogin():LoginView


    @ContributesAndroidInjector
    abstract fun contributeSignup():Signup

    @ContributesAndroidInjector
    abstract fun contributePromo():PromoView


    @ContributesAndroidInjector
    abstract fun contributeProfile():Profile

}