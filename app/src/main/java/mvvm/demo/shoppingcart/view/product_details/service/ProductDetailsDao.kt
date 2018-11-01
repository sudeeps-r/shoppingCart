package mvvm.demo.shoppingcart.view.product_details.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single
import mvvm.demo.shoppingcart.view.product_details.model.ProductDetails

/**
 * Created by Sudeep SR on 31/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
@Dao
interface ProductDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetails(productDetails: ProductDetails)

    @Query("SELECT * FROM product_details WHERE _id = :id")
    fun getProductDetails( id:Int):Single<ProductDetails>
}