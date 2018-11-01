package mvvm.demo.shoppingcart.view.product_details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.product_details.*
import mvvm.demo.shoppingcart.R
import mvvm.demo.shoppingcart._core.di.component.Injectable
import mvvm.demo.shoppingcart.view.product_details.ProductDetailsViewModel
import mvvm.demo.shoppingcart.view.product_details.service.ProductDetailsRepository
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.util.BaseView
import javax.inject.Inject

/**
 * Created by Sudeep SR on 31/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class ProductDetails : BaseView(), Injectable {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var productDetailsViewModel: ProductDetailsViewModel

    private lateinit var product: Product

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.product_details, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.productDetailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductDetailsViewModel::class.java)
        this.init()
    }

    private fun init() {

        this.product = ProductDetailsArgs.fromBundle(arguments).prodDetails
        this.productDetailsViewModel.fetProductDetails(1)
        this.productDetailsViewModel.getProductLiveData().observe(this, Observer {
            it -> title.text = it.title;description.text = it.desc
        })
    }

}