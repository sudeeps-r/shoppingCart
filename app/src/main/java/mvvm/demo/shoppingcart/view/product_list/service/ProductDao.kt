package mvvm.demo.shoppingcart.view.product_list.service

import androidx.room.*
import io.reactivex.Single
import mvvm.demo.shoppingcart.view.product_list.model.Product

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProductList( products:List<Product>)

    @Update
    fun updateProductList(products: List<Product>)

    @Query(" SELECT  * FROM product")
    fun getProducts():Single<List<Product>>
}