package com.example.manualdependencychallenges

import LocalDataSource
import RemoteDataSource
import YourViewModel
import UserRepository
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.manualdependencychallenges.`1issuesb4di`.YourRetrofitService

class OneUserActivity : AppCompatActivity() {

    private lateinit var yourViewModel: YourViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //1.satisfy the dependencies of UserRepository
        val remoteDataSource = RemoteDataSource(YourRetrofitService().retrofit)
        val localDataSource = LocalDataSource()

        //2.Now you can create an instance of UserRepository that LoginViewModel needs
        val userRepository = UserRepository(remoteDataSource, localDataSource)

        //3.Lastly, create an instance of LoginViewModel with userRepository
        yourViewModel = YourViewModel(userRepository)

        /*There's a lot of boilerplate code above.
        If you wanted to create another instance
        of LoginViewModel in another part of the code, you'd have code duplication.

        Dependencies have to be declared in order.
         You have to instantiate UserRepository
        before LoginViewModel in order to create it.

        It's difficult to reuse objects. If you wanted to reuse UserRepository across multiple features,
        you'd have to make it follow the singleton pattern.
        The singleton pattern makes testing more difficult
        because all tests share the same singleton instance.*/


    }
}