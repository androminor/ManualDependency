package com.example.manualdependencychallenges

/*If LoginViewModel is needed in more places
 in the application, having a centralized
 place where you create instances of LoginViewModel
 makes sense. You can move the creation of LoginViewModel
 to the container and provide new objects of that type with a factory.
 The code for a LoginViewModelFactory looks like this
*/

// Definition of a Factory interface with a function to create objects of a type : Generic way

interface YourFactory<T> {
    fun create():T
}