import androidx.lifecycle.ViewModel

/**
 * Created by Varun Singh
 * /**
 *  * ViewModel is a class that is responsible for preparing and managing the data for
 *  * an {@link android.app.Activity Activity} or a {@link androidx.fragment.app.Fragment Fragment}.
 *  * It also handles the communication of the Activity / Fragment with the rest of the application
 *  * (e.g. calling the business logic classes).
 *  * <p>
 *  * A ViewModel is always created in association with a scope (a fragment or an activity) and will
 *  * be retained as long as the scope is alive. E.g. if it is an Activity, until it is
 *  * finished.
 *  * <p>
 *  * In other words, this means that a ViewModel will not be destroyed if its owner is destroyed for a
 *  * configuration change (e.g. rotation). The new owner instance just re-connects to the existing model.
 *  * <p>
 *  * The purpose of the ViewModel is to acquire and keep the information that is necessary for an
 *  * Activity or a Fragment. The Activity or the Fragment should be able to observe changes in the
 *  * ViewModel. ViewModels usually expose this information via {@link LiveData} or Android Data
 *  * Binding. You can also use any observability construct from your favorite framework.
 *  * <p>
 *  * ViewModel's only responsibility is to manage the data for the UI. It <b>should never</b> access
 *  * your view hierarchy or hold a reference back to the Activity or the Fragment.
 *  * <p>
 *  * Typical usage from an Activity standpoint would be:
 *  * <pre>
 *  * public class UserActivity extends Activity {
 *  *
 *  *     {@literal @}Override
 *  *     protected void onCreate(Bundle savedInstanceState) {
 *  *         super.onCreate(savedInstanceState);
 *  *         setContentView(R.layout.user_activity_layout);
 *  *         final UserModel viewModel = new ViewModelProvider(this).get(UserModel.class);
 *  *         viewModel.getUser().observe(this, new Observer&lt;User&gt;() {
 *  *             {@literal @}Override
 *  *             public void onChanged(@Nullable User data) {
 *  *                 // update ui.
 *  *             }
 *  *         });
 *  *         findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
 *  *             {@literal @}Override
 *  *             public void onClick(View v) {
 *  *                  viewModel.doAction();
 *  *             }
 *  *         });
 *  *     }
 *  * }
 *  * </pre>
 *  *
 *  * ViewModel would be:
 *  * <pre>
 *  * public class UserModel extends ViewModel {
 *  *     private final MutableLiveData&lt;User&gt; userLiveData = new MutableLiveData&lt;&gt;();
 *  *
 *  *     public LiveData&lt;User&gt; getUser() {
 *  *         return userLiveData;
 *  *     }
 *  *
 *  *     public UserModel() {
 *  *         // trigger user load.
 *  *     }
 *  *
 *  *     void doAction() {
 *  *         // depending on the action, do necessary business logic calls and update the
 *  *         // userLiveData.
 *  *     }
 *  * }
 *  * </pre>
 *  *
 *  * <p>
 *  * ViewModels can also be used as a communication layer between different Fragments of an Activity.
 *  * Each Fragment can acquire the ViewModel using the same key via their Activity. This allows
 *  * communication between Fragments in a de-coupled fashion such that they never need to talk to
 *  * the other Fragment directly.
 *  * <pre>
 *  * public class MyFragment extends Fragment {
 *  *     public void onStart() {
 *  *         UserModel userModel = new ViewModelProvider(requireActivity()).get(UserModel.class);
 *  *     }
 *  * }
 *  * </pre>
 *  * </>
 *  */
 */
class YourViewModel(private val userRepository: UserRepository):ViewModel() {
    // Your ViewModel implementation


}