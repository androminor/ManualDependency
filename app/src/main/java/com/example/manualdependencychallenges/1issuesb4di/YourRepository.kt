import com.example.manualdependencychallenges.`1issuesb4di`.YourRetrofitService

/**
 * Created by Varun Singh
 */
class UserRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) {}

class LocalDataSource {}
class RemoteDataSource(
    private val loginService: YourRetrofitService
) {

}