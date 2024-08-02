import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manualdependencychallenges.AppContainer
import com.example.manualdependencychallenges.LoginContainer
import com.example.manualdependencychallenges.LoginUserData
import com.example.manualdependencychallenges.R

/**
 * Created by Varun Singh
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginData: LoginUserData
    private lateinit var appContainer: AppContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        appContainer = (application as MainApplication).appContainer
        // login flow ko start karega.Populate loginContainer in AppContainer
        appContainer.loginContainer = LoginContainer(appContainer.repository)

        loginViewModel = appContainer.loginContainer!!.loginViewModelFactory.create()

        /*using elvis operator*/
        // loginData = appContainer.loginContainer?.loginUserData?:throw IllegalStateException("LoginContainer is null")

        /*using let*/
        // loginData = appContainer.loginContainer?.let { it.loginUserData } ?: throw IllegalStateException("LoginContainer is null")

        /*using run*/
        loginData = appContainer.loginContainer?.run { loginUserData }
            ?: throw IllegalStateException("LoginContainer is null")

        /*using also*/
        // (appContainer.loginContainer?.run { loginUserData }?:throw java.lang.IllegalStateException("LoginContainer is null")).also { loginData =it }

    }

    override fun onDestroy() {
        // Login flow is finishing
        // Removing the instance of loginContainer in the AppContainer
        appContainer.loginContainer = null
        super.onDestroy()
    }

    /*Like LoginActivity, login fragments can access the LoginContainer
     from AppContainer and use the shared LoginUserData instance.*/
}