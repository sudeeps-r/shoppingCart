package mvvm.demo.shoppingcart._core.di.module

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Database
import androidx.room.RoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap
import mvvm.demo.shoppingcart.MainActivity
import mvvm.demo.shoppingcart._core.database.DBHelper
import mvvm.demo.shoppingcart._core.di.component.ViewComponent
import mvvm.demo.shoppingcart._core.di.scope.AppScope
import javax.inject.Singleton

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */

@Module(includes = [ViewModelModule::class])
abstract class AppModule {




    /*@Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindActivityInjector(builder:ViewComponent.Builder) :AndroidInjector.Factory<out Activity>*/



}