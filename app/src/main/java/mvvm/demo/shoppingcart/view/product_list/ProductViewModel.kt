package mvvm.demo.shoppingcart.view.product_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.product_list.service.ProductRepository

import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class ProductViewModel @Inject constructor(val productRepository: ProductRepository) : ViewModel() {

    private val productsMutableLiveData:MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>()
    }

    fun fetchProduct() {
        productRepository.fetchProductList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableObserver<List<Product>>(){
                    override fun onComplete() {

                    }

                    override fun onNext(t: List<Product>) {
                        print("product size"+t.size)
                       productsMutableLiveData.value=t
                    }

                    override fun onError(e: Throwable) {

                    }
                })
    }

    fun getProductList():MutableLiveData<List<Product>>{
        return this.productsMutableLiveData
    }
}