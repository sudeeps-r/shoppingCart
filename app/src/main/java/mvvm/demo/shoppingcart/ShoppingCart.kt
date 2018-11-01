package mvvm.demo.shoppingcart

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import mvvm.demo.shoppingcart._core.api.HttpClient
import mvvm.demo.shoppingcart._core.di.component.AppComponent
import mvvm.demo.shoppingcart._core.di.component.DaggerAppComponent
import mvvm.demo.shoppingcart._core.di.component.Injectable
import mvvm.demo.shoppingcart._core.di.module.AppModule
import mvvm.demo.shoppingcart._core.di.module.DBModule
import javax.inject.Inject

/**
 * Created by Sudeep SR on 07/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
class ShoppingCart : Application(), HasActivityInjector {

    private val tagName:String= "product_list"

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector


    override fun onCreate() {
        super.onCreate()
        component.inject(this)
        this.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks{
            override fun onActivityPaused(activity: Activity?) {

            }

            override fun onActivityResumed(activity: Activity?) {

            }

            override fun onActivityStarted(activity: Activity?) {

            }

            override fun onActivityDestroyed(activity: Activity?) {

            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

            }

            override fun onActivityStopped(activity: Activity?) {

            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
                if(activity is HasSupportFragmentInjector){
                   AndroidInjection.inject(activity)
                }

                if(activity is AppCompatActivity){
                print("inside app compact")
                    activity.supportFragmentManager.registerFragmentLifecycleCallbacks(object :FragmentManager.FragmentLifecycleCallbacks(){

                        override fun onFragmentCreated(fm: FragmentManager, f: Fragment, savedInstanceState: Bundle?) {
                           Log.e(tagName,"fragment created"+f.javaClass.kotlin)
                            if(f is Injectable){
                                Log.e(tagName,"fragment inject")
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    },true)
                }
            }

        })

    }


    val component: AppComponent by lazy {
        DaggerAppComponent.builder().context(this).build()
    }
}