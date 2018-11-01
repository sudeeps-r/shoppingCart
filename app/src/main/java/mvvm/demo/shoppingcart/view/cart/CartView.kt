package mvvm.demo.shoppingcart.view.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import mvvm.demo.shoppingcart.R
import mvvm.demo.shoppingcart._core.di.component.Injectable
import mvvm.demo.shoppingcart._core.di.module.AppViewModelFactory
import mvvm.demo.shoppingcart.view.util.BaseView
import javax.inject.Inject

/**
 * Created by Sudeep SR on 14/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class CartView : BaseView(),Injectable {

    @Inject
    lateinit var viewModleFactory: ViewModelProvider.Factory

    lateinit var cartViewModel:CartViewModel



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        cartViewModel= ViewModelProviders.of(this,viewModleFactory).get(CartViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_view,container,false)
    }
}