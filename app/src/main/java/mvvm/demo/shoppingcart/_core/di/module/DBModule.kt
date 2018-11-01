package mvvm.demo.shoppingcart._core.di.module

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import mvvm.demo.shoppingcart._core.database.DBHelper
import mvvm.demo.shoppingcart._core.di.scope.AppScope
import mvvm.demo.shoppingcart.view.product_list.service.ProductDao
import mvvm.demo.shoppingcart.view.util.SingletonHolder
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

@Module
class DBModule() {

    //     companion object : SingletonHolder<DBHelper, Context>({
//         Room.databaseBuilder(it.applicationContext,
//                 DBHelper::class.java, "shoppingcart.db")
//                 .build()
//     })
    @Singleton
    @Provides
    fun provideDatabase(context: Context): DBHelper {
        var dataBase: DBHelper = Room.databaseBuilder(context, DBHelper::class.java, "shoppingcart").fallbackToDestructiveMigration().build()
        return dataBase
    }

    @Singleton
    @Provides
    fun provideProductDao(dbHelper: DBHelper): ProductDao {
        return dbHelper.productDao()
    }

    @Singleton
    @Provides
    fun provideProductDetailsDao(dbHelper: DBHelper) = dbHelper.productDetailsDao()
}