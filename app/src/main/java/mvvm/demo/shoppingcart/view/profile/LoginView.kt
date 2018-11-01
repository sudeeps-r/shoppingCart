package mvvm.demo.shoppingcart.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import mvvm.demo.shoppingcart.R
import mvvm.demo.shoppingcart.view.util.BaseView

/**
 * Created by Sudeep SR on 14/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class LoginView:BaseView() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.login,container,false)
    }
}