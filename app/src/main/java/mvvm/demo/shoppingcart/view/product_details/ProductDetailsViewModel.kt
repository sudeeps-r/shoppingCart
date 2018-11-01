package mvvm.demo.shoppingcart.view.product_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import mvvm.demo.shoppingcart.view.product_details.model.ProductDetails
import mvvm.demo.shoppingcart.view.product_details.service.ProductDetailsRepository
import java.util.concurrent.TimeUnit

import javax.inject.Inject

/**
 * Created by Sudeep SR on 31/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class ProductDetailsViewModel @Inject constructor(val productDetailsRepository: ProductDetailsRepository) : ViewModel() {

    private val productDetailsMutableData:MutableLiveData<ProductDetails> by lazy {
        MutableLiveData<ProductDetails>()
    }

    public fun fetProductDetails(id:Int){
        this.productDetailsRepository.fetchProductDetails(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :DisposableObserver<ProductDetails>(){
            override fun onComplete() {

            }

            override fun onNext(t: ProductDetails) {
               productDetailsMutableData.value=t
            }

            override fun onError(e: Throwable) {

            }

        })
    }

    public fun getProductLiveData():LiveData<ProductDetails>{
        return this.productDetailsMutableData
    }
}