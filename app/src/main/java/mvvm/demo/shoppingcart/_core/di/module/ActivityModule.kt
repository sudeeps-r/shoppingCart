package mvvm.demo.shoppingcart._core.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvvm.demo.shoppingcart.MainActivity
import mvvm.demo.shoppingcart._core.di.component.ViewComponent
import mvvm.demo.shoppingcart._core.di.scope.AppScope
import mvvm.demo.shoppingcart._core.di.scope.ViewScope
import mvvm.demo.shoppingcart.view.product_list.view.ProductList
import mvvm.demo.shoppingcart.view.product_list.view.ProductListComponent

/**
 * Created by Sudeep SR on 13/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
@Module
abstract class ActivityModule {


    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity():MainActivity




}