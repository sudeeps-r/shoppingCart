package mvvm.demo.shoppingcart.view.util

import mvvm.demo.shoppingcart.view.product_list.model.Product

/**
 * Created by Sudeep SR on 31/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
interface ProductListener {

    fun onItemSelected(product: Product)
}