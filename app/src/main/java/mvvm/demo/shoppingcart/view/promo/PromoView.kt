package mvvm.demo.shoppingcart.view.promo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import mvvm.demo.shoppingcart.R
import mvvm.demo.shoppingcart._core.di.component.Injectable
import mvvm.demo.shoppingcart.view.util.BaseView
import javax.inject.Inject

/**
 * Created by Sudeep SR on 14/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class PromoView:BaseView() ,Injectable{


    @Inject
    lateinit var viewModelFactory:ViewModelProvider.Factory
    lateinit var promoViewModel:PromoViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.promoViewModel= ViewModelProviders.of(this,this.viewModelFactory).get(PromoViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.promo,container,false)
    }
}