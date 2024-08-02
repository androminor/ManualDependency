import com.example.manualdependencychallenges.YourFactory

/**
 * Created by Varun Singh
 */
class LoginViewModelFactory(private val repository: UserRepository): YourFactory<Any> {
    override fun create(): LoginViewModel {
return LoginViewModel(repository)   }

}