package mvvm.demo.shoppingcart._core.di.component

import android.view.View
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import mvvm.demo.shoppingcart.MainActivity
import mvvm.demo.shoppingcart._core.di.module.ActivityModule
import mvvm.demo.shoppingcart._core.di.module.ViewModelModule
import mvvm.demo.shoppingcart._core.di.scope.ViewScope

/**
 * Created by Sudeep SR on 18/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */


@Subcomponent(modules = [ActivityModule::class])
interface ViewComponent  {

    //: AndroidInjector<MainActivity>
    //: AndroidInjector.Builder<MainActivity>()
    @Subcomponent.Builder
    interface  Builder {
        fun build():ViewComponent
    }

}

