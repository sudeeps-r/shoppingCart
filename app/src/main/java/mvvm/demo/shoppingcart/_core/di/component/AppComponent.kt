package mvvm.demo.shoppingcart._core.di.component

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import mvvm.demo.shoppingcart.ShoppingCart
import mvvm.demo.shoppingcart._core.di.module.*
import mvvm.demo.shoppingcart._core.di.scope.AppScope
import javax.inject.Singleton

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
@Singleton
@Component(modules = [AndroidInjectionModule::class, ServiceModule::class,DBModule::class,AppModule::class,ActivityModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun context(context: Context):Builder

        fun build():AppComponent
    }
    fun inject(applicaitonContext:ShoppingCart)
}