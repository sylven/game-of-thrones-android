package com.silviuchirvasa.gameofthrones

import android.app.Activity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.silviuchirvasa.gameofthrones.data.network.model.NetworkCharacter
import kotlinx.android.synthetic.main.activity_detail_character.*

class CharacterDetailActivity : Activity() {

    companion object {
        private val TAG = CharacterDetailActivity::class.java.simpleName
        const val CHARACTER = "character"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)

        val character : NetworkCharacter? = intent.getParcelableExtra(CHARACTER)
        tvName.text = character?.name

        Glide.with(this)
            .load(character?.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .dontAnimate()
            .override(333, 500) // To allow parallax effect
            .into(ivImage)

        tvHouse.text = character?.house
        tvTitles.text = character?.titles!!.joinToString(separator = "\n")
        tvActor.text = character?.actor
        tvGender.text = character?.gender
        tvFather.text = character?.father
        //tvFirstSeen.text = character?.firstSeen
        tvSiblings.text = character?.siblings!!.joinToString(separator = "\n")
        tvSpouse.text = character?.spouse!!.joinToString(separator = "\n")
        tvLovers.text = character?.lovers!!.joinToString(separator = "\n")
        tvOrigin.text = character?.origin!!.joinToString(separator = "\n")
        tvCulture.text = character?.culture!!.joinToString(separator = "\n")
        tvReligion.text = character?.religion!!.joinToString(separator = "\n")
        tvAllegiances.text = character?.allegiances!!.joinToString(separator = "\n")
        //tvSeasons.text = character?.seasons.toString()
        tvAppearences.text = character?.appearances!!.joinToString(separator = "\n")
    }

}
