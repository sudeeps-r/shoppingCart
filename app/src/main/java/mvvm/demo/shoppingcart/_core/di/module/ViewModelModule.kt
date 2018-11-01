package mvvm.demo.shoppingcart._core.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import mvvm.demo.shoppingcart._core.di.scope.AppScope
import mvvm.demo.shoppingcart._core.di.scope.FragmentScope
import mvvm.demo.shoppingcart._core.di.scope.ViewModelKey
import mvvm.demo.shoppingcart._core.di.scope.ViewScope
import mvvm.demo.shoppingcart.view.cart.CartViewModel
import mvvm.demo.shoppingcart.view.product_details.ProductDetailsViewModel
import mvvm.demo.shoppingcart.view.product_list.ProductViewModel
import mvvm.demo.shoppingcart.view.profile.GuestViewModel
import mvvm.demo.shoppingcart.view.profile.LoginViewModel
import mvvm.demo.shoppingcart.view.profile.ProfileViewModel
import mvvm.demo.shoppingcart.view.profile.SignupViewModel
import mvvm.demo.shoppingcart.view.promo.PromoViewModel
import javax.inject.Singleton

/**
 * Created by Sudeep SR on 13/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    abstract fun provideProductViewModel(productViewModel: ProductViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductDetailsViewModel::class)
    abstract fun provideProductDetailsViewModel(productDetail: ProductDetailsViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(GuestViewModel::class)
    abstract fun provideGuestViewModel(guestViewModel: GuestViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun provideLoginViewModel(guestViewModel: LoginViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignupViewModel::class)
    abstract fun provideSignUpViewModel(guestViewModel: SignupViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun provideProfileViewModel(profileViewModel: ProfileViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PromoViewModel::class)
    abstract fun providePromoViewModel(promoViewModel:PromoViewModel):ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CartViewModel::class)
    abstract fun provideCartViewModel(cartViewModel: CartViewModel):ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: AppViewModelFactory): ViewModelProvider.Factory

}