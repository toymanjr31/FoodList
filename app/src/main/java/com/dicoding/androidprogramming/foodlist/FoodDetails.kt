package com.dicoding.androidprogramming.foodlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FoodDetails : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val actionbar = supportActionBar
        actionbar!!.title = "Details"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvSetName: TextView = findViewById(R.id.tv_item_name)
        val tvSetDetails: TextView = findViewById(R.id.tv_item_detail)
        val imgSetPhoto: ImageView = findViewById(R.id.img_item_photo)

        val iName = intent.getStringExtra(EXTRA_NAME)
        val iDetails = intent.getStringExtra(EXTRA_DETAILS)
        val iImg = intent.getIntExtra(EXTRA_IMAGE, 0)

        tvSetName.text = iName
        Glide.with(this)
            .load(iImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetDetails.text = iDetails

        val btnShare: Button = findViewById(R.id.btn_share)
        btnShare.setOnClickListener{
            val message = tvSetDetails.text
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to: "))
        }
    }

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAILS = "extra_details"
        const val EXTRA_IMAGE = "extra_image"
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}