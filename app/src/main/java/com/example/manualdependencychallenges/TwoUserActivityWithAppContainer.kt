import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manualdependencychallenges.R

/**
 * Created by Varun Singh
 *
 * Now you can get the instance of the com.example.manualdependencychallenges.AppContainer
 * from the application and obtain the shared of UserRepository instance
 *
 * In this way, you don't have a singleton UserRepository.
 * Instead, you have an com.example.manualdependencychallenges.AppContainer shared across all
 * activities that contains objects from the graph
 * and creates instances of those objects that other classes can consume.
 */
class TwoUserActivityWithAppContainer : AppCompatActivity() {
    private lateinit var yourViewModel: YourViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val appContainer = (application as MainApplication).appContainer
        yourViewModel = YourViewModel(appContainer.repository)
    }
}