package mvvm.demo.shoppingcart.view.util

/**
 * Created by Sudeep SR on 08/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
open class SingletonHolder <out T,in A>(creator:(A)->T){
    private var creator: ((A) -> T)? = creator
    @Volatile private var instance: T? = null

    fun getInstance(arg:A):T{
        val i= instance
        if(i!=null){
            return i
        }

       return synchronized(this){
            val i2=instance
             if(i2!=null){
                 i2
             }else{
                 val created= creator!!(arg)
                 instance=created
                 creator=null
                 created
             }
        }
    }
}