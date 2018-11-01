package mvvm.demo.shoppingcart.view.product_details.service

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import mvvm.demo.shoppingcart.view.product_details.model.ProductDetails
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.product_list.service.ProductApi
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Sudeep SR on 31/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

class ProductDetailsRepository @Inject constructor(val productApi: ProductApi,val productDetailsDao: ProductDetailsDao){


    private lateinit var product:ProductDetails

    private fun getProdDetails(id:Int):Observable<ProductDetails>{
        return productApi.fetchProductDetails().subscribeOn(Schedulers.io()).doOnNext {
            productDetailsDao.insertDetails(it)
            this.product=it

        }
    }
    public fun fetchProductDetails(id:Int):Observable<ProductDetails>{
        if(!::product.isInitialized){
            return getProdDetails(id)
        }
        return Observable.concatArrayEager(productDetailsDao.getProductDetails(id).toObservable(),getProdDetails(id)).debounce(1,TimeUnit.SECONDS)
    }

}