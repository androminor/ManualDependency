import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manualdependencychallenges.R

/**
 * Created by Varun Singh
 */
class ThreeUserActivityWithFactory : AppCompatActivity() {
    private lateinit var useViewModel: YourViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val appContainer = (application as MainApplication).appContainer
        /*we dont need to explicitely call appContainer.repository*/
        //useViewModel = YourViewModel(appContainer.repository)

        useViewModel = appContainer.factoryUser.create()

        /*This approach is better than the previous one,
        but there are still some challenges to consider:
        You have to manage com.example.manualdependencychallenges.AppContainer yourself,
        creating instances for all dependencies by hand.

        There is still a lot of boilerplate code.
        You need to create factories or parameters by hand
        depending on whether you want to reuse an object or not.*/
    }
}