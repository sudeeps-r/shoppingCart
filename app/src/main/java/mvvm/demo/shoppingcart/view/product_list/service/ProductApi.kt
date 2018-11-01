package mvvm.demo.shoppingcart.view.product_list.service

import io.reactivex.Observable
import mvvm.demo.shoppingcart.view.product_details.model.ProductDetails
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.product_list.model.Products
import retrofit2.http.GET

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
interface ProductApi {

    @GET("/productlist")
    fun fetchProductList():Observable<Products>

    @GET("/details") //this has to be in respective folder or common service folder
    fun fetchProductDetails():Observable<ProductDetails>
}