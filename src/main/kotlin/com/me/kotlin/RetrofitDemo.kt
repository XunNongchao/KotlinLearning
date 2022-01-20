package com.me.kotlin

import com.me.kotlin.entity.Repository
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubApi {
    @GET("repos/{owner}/{repo}")
    fun getRepository(
        @Path("owner") owner: String,
        @Path("repo") repo: String
    ): Call<Repository>
}

fun main() {

    val gitHubApi = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GitHubApi::class.java)

    val response = gitHubApi.getRepository("JetBrains", "Kotlin").execute()

    val body = response.body()

    if (body == null) {
        println("Error! ${response.code()} - ${response.message()}")
    } else{
        println(body.name)
        println(body.owner.login)
        println(body.stargazers_count)
        println(body.forks_count)
        println(body.html_url)
    }

}