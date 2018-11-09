package mvvm.demo.shoppingcart.view.product_list.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_product_row.view.*
import mvvm.demo.shoppingcart.R
import mvvm.demo.shoppingcart.view.product_list.model.Product
import mvvm.demo.shoppingcart.view.util.ProductListener

/**
 * Created by Sudeep SR on 31/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class ProductListAdapter(val productListener: ProductListener): RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>(),View.OnClickListener {
    override fun onClick(v: View?) {
        var position=v!!.getTag() as Int
        this.productListener.onItemSelected(this.products[position])
    }


    private lateinit var products:List<Product>
    private var count:Int=0

    fun addProducts( products:List<Product>){
        this.products= products
        if(this.products!=null){
            this.count=this.products.size
        }else{
            this.count=0
        }
        this.notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
         var view:View= LayoutInflater.from(parent.context).inflate(R.layout.list_product_row,parent,false)
          view.setOnClickListener(this)
         return ProductViewHolder(view)
    }

    override fun getItemCount()=this.count

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product= this.products.get(position)
        holder.title.setTextFuture(PrecomputedTextCompat.getTextFuture(product.title,TextViewCompat.getTextMetricsParams(holder.title),null))
        holder.itemView.setTag(position)

    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.prodName
    }
}