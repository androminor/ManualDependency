import com.example.manualdependencychallenges.YourFactory

/**
 * Created by Varun Singh
 *
 * Factory for LoginViewModel.
 * Since LoginViewModel depends on UserRepository,
 * in order to create instances of
 * LoginViewModel, you need an instance of UserRepository
 * that you pass as a parameter
 */

class YourViewModelFactory(private val userRepository: UserRepository) : YourFactory<Any> {
    //UserViewModelFactory ka create() method call karte hain,
    // woh ek naya UserViewModel hai
    // object return karta hai jo userRepository se initialize hota hai.
    override fun create(): YourViewModel {
        return YourViewModel(userRepository)
    }



}