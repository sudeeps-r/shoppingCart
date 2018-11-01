package mvvm.demo.shoppingcart.view.product_list.service

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.product_list.model.Products
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class ProductRepository @Inject constructor(private val productApi: ProductApi, private val productDao: ProductDao) {

    private lateinit var productList: List<Product>

    fun fetchProductList(): Observable<List<Product>> {
        if (!::productList.isInitialized) {
            return fetchProductsFromApi()
        }
        return Observable.concatArrayEager(fetchProductsFromDB(), fetchProductsFromApi()).debounce(2,TimeUnit.SECONDS)
    }

    private fun fetchProductsFromDB(): Observable<List<Product>> {
        return productDao.getProducts().toObservable().doOnNext {

        }
    }

    private fun fetchProductsFromApi(): Observable<List<Product>> {
        return productApi.fetchProductList().subscribeOn(Schedulers.io())
                .flatMap { it -> Observable.just(it.products) }
                .doOnNext {
                    productDao.insertProductList(it)
                    this.productList = it
                }
    }


}