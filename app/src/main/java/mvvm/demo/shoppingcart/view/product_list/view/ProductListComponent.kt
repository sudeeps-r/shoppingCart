package mvvm.demo.shoppingcart.view.product_list.view

import dagger.Subcomponent
import dagger.android.AndroidInjector
import mvvm.demo.shoppingcart._core.di.module.FragmentModule
import mvvm.demo.shoppingcart._core.di.scope.FragmentScope

/**
 * Created by Sudeep SR on 22/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

@FragmentScope
@Subcomponent
interface ProductListComponent : AndroidInjector<ProductList> {


}