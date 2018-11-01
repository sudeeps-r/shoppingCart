package mvvm.demo.shoppingcart.view.product_list.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.list_view.*
import kotlinx.android.synthetic.main.list_view.view.*
import mvvm.demo.shoppingcart.R
import mvvm.demo.shoppingcart._core.di.component.Injectable
import mvvm.demo.shoppingcart.view.product_list.ProductViewModel
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.util.BaseView
import mvvm.demo.shoppingcart.view.util.ProductListener
import javax.inject.Inject

/**
 * Created by Sudeep SR on 08/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class ProductList:BaseView() ,Injectable,ProductListener{
    override fun onItemSelected(product: Product) {
        navController().navigate(ProductListDirections.navProductList(product))
    }

    private val tagName:String= "product_list"

    @Inject
    lateinit var viewModelFactory:ViewModelProvider.Factory

    private lateinit var  productViewModel:ProductViewModel

    private val productListAdapter:ProductListAdapter= ProductListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tagName,"oncreate")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        productViewModel= ViewModelProviders.of(this,viewModelFactory).get(ProductViewModel::class.java)
        productViewModel.fetchProduct()
        Log.e(tagName,"activity created")
        init()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.e(tagName," create view")
        return inflater.inflate(R.layout.list_view,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(tagName," view created")

    }

    private fun init(){
        listView.adapter=productListAdapter

       this.productViewModel.getProductList().observe(this, Observer {
           it->
           Log.e(tagName,"prod "+it.size)
           productListAdapter.addProducts(it)
       })
    }

    fun navController()=findNavController()
}