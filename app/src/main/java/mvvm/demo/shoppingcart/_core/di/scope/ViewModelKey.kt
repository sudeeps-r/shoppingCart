package mvvm.demo.shoppingcart._core.di.scope

import androidx.lifecycle.ViewModel
import dagger.MapKey
import mvvm.demo.shoppingcart.view.util.BaseActivity
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

/**
 * Created by Sudeep SR on 08/10/18.
 * Company <Reliance Payment Solutions Ltd.>
 * Email <sudeep.sr@ril.com>
 */
@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>) {
}

