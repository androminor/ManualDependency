package com.example.manualdependencychallenges

import LocalDataSource
import LoginViewModelFactory
import RemoteDataSource
import UserRepository
import YourViewModelFactory
import com.example.manualdependencychallenges.`1issuesb4di`.YourRetrofitService

/**
 * Created by Varun Singh
 * solve the issue of reusing objects,
 * you can create your own dependencies container class
 * that you use to get dependencies
 */

//Container of objects shared across whole app


class LoginContainer(private val repository: UserRepository) {
    val loginUserData: LoginUserData
        get() {
            TODO()
        }
    val loginViewModelFactory = LoginViewModelFactory(repository)
}

/*AppContainer contains LoginContainer now*/
class AppContainer {

    private val remoteDataSource = RemoteDataSource(YourRetrofitService().retrofit)
    private val localDataSource = LocalDataSource()

    //not private
    val repository = UserRepository(remoteDataSource, localDataSource)

    //if you have supplied factory 1
    val factoryUser = YourViewModelFactory(repository)
    // if you have supplied factory 2
   // val factoryLogin = LoginViewModelFactory(repository)

    // LoginContainer will be null when the user is NOT in the login flow

    var loginContainer: LoginContainer? = null
}

//Because these dependencies are used across the whole application we will
//We will further use MainApplication that will containg com.example.manualdependencychallenges.AppContainer instance