package mvvm.demo.shoppingcart.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.guest.*
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
class GuestView :  BaseView(),Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var guestViewModel:GuestViewModel



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.guestViewModel=ViewModelProviders.of(this,this.viewModelFactory).get(GuestViewModel::class.java)
        loginBtn.setOnClickListener {
            findNavController().navigate(GuestViewDirections.nvLoginView())
        }

        signupBtn.setOnClickListener {
            findNavController().navigate(GuestViewDirections.navSignup())
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.guest,container,false)
    }
}