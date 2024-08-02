import android.app.Application
import com.example.manualdependencychallenges.AppContainer

/**
 * Created by Varun Singh
 *
 * Note: com.example.manualdependencychallenges.AppContainer is just a regular class
 * with a unique instance shared across the app placed in your Application class.
 * However, com.example.manualdependencychallenges.AppContainer is not following
 * the singleton pattern; in Kotlin, it's not an object,
 * and in Java, it's not accessed with the typical Singleton.getInstance() method.
 *
 * Create a custom Application class that contains an com.example.manualdependencychallenges.AppContainer instance.
 */
class MainApplication:Application() {
 val appContainer = AppContainer()
}