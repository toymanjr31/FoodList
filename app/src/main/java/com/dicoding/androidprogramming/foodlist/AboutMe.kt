package com.dicoding.androidprogramming.foodlist

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutMe : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        val actionbar = supportActionBar
        actionbar!!.title = "About Me"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val image: ImageView = findViewById(R.id.img_item_photo)

        val drawImage = R.drawable.mypic

        Glide.with(this)
            .load(drawImage)
            .apply(RequestOptions())
            .into(image)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_dial_number -> {
                val phoneNumber = "087787369920"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse(("tel:$phoneNumber")))
                startActivity(dialPhoneIntent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}