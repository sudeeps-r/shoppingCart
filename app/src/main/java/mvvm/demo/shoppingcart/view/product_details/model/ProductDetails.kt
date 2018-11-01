package mvvm.demo.shoppingcart.view.product_details.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName

/**
 * Created by Sudeep SR on 31/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
@Entity(tableName = "product_details",primaryKeys = ["_id"])
data class ProductDetails(@SerializedName("id") @ColumnInfo(name ="_id") val id:Int, @SerializedName("title")@ColumnInfo(name="tile")val title:String, @SerializedName("desc")@ColumnInfo(name = "desc")val desc:String) {

}