package mvvm.demo.shoppingcart


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import mvvm.demo.shoppingcart.view.util.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), HasSupportFragmentInjector {


    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(tool_bar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        NavigationUI.setupActionBarWithNavController(this,findNavController(R.id.f_container))
        NavigationUI.setupWithNavController(bottom_nav_bar, findNavController(R.id.f_container))
    }

    override fun onSupportNavigateUp() = findNavController(R.id.f_container).navigateUp()
}
