package mvvm.demo.shoppingcart._core.di.module

import dagger.Module
import dagger.Provides
import mvvm.demo.shoppingcart._core.api.HttpClient
import mvvm.demo.shoppingcart._core.di.scope.AppScope
import mvvm.demo.shoppingcart.view.product_list.service.ProductApi
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

@Module (includes = [HttpClient::class])
class ServiceModule {

    @Singleton
    @Provides
    fun provideProductList( retrofit: Retrofit):ProductApi{
        return retrofit.create(ProductApi::class.java)
    }
    
}