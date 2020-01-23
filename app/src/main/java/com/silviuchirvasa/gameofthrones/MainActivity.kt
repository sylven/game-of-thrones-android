package com.silviuchirvasa.gameofthrones

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.silviuchirvasa.gameofthrones.data.network.ApiService
import com.silviuchirvasa.gameofthrones.data.network.RestClient
import com.silviuchirvasa.gameofthrones.data.network.model.NetworkCharacter
import com.silviuchirvasa.gameofthrones.adapter.CharacterAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private var apiService: ApiService? = null

    private var adapter: CharacterAdapter?= null
    private var characters: MutableList<NetworkCharacter> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RestClient.client.create(ApiService::class.java)

        listRecyclerView!!.layoutManager = GridLayoutManager(this, 2)

        adapter = CharacterAdapter(characters) {
                val intent = Intent(this, CharacterDetailActivity::class.java)
                intent.putExtra(CharacterDetailActivity.CHARACTER, it)
                startActivity(intent)
            }
        listRecyclerView!!.adapter = adapter

        fetchCharactersList()
    }

    private fun fetchCharactersList() {
        val call = apiService!!.getCharacters()
        call.enqueue(object : Callback<List<NetworkCharacter>> {

            override fun onResponse(call: Call<List<NetworkCharacter>>, response: Response<List<NetworkCharacter>>) {
                Log.d(TAG, "Total Characters: " + response.body()!!.size)
                val characters = response.body()
                if (characters != null) {
                    this@MainActivity.characters.addAll(characters.sortedWith(compareByDescending{ it.pagerank!!.rank }))
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<NetworkCharacter>>, t: Throwable) {
                Log.e(TAG, "Got error : " + t.localizedMessage)
            }
        })
    }

}
