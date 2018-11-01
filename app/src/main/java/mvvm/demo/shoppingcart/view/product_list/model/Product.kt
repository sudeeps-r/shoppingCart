package mvvm.demo.shoppingcart.view.product_list.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

@Parcelize
@Entity(tableName = "product", primaryKeys = arrayOf("_id"))
data class Product(@SerializedName("id")
                   @ColumnInfo(name = "_id") val id:String, @SerializedName("title") val title:String, @SerializedName("desc") val desc:String): Parcelable {
    override fun toString(): String {
        return "Product(id='$id', title='$title', desc='$desc')"
    }
}

data class Products(@SerializedName("products") val products:List<Product>){

}