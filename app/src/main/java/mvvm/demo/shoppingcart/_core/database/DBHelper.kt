package mvvm.demo.shoppingcart._core.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import mvvm.demo.shoppingcart.view.product_details.model.ProductDetails
import mvvm.demo.shoppingcart.view.product_details.service.ProductDetailsDao
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.product_list.service.ProductDao

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
@Database(version = 2,entities = arrayOf(Product::class,ProductDetails::class))
abstract class DBHelper:RoomDatabase() {

    abstract fun productDao():ProductDao

    abstract fun productDetailsDao():ProductDetailsDao
}