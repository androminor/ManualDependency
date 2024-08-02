package com.example.manualdependencychallenges.`1issuesb4di`

import retrofit2.Retrofit

// Retrofit service ( Builder pattern )
class YourRetrofitService {
    val retrofit: YourRetrofitService = Retrofit.Builder()
        .baseUrl("http")
        .build()
        .create(YourRetrofitService::class.java)
}
