package com.example.android_project_4a.presentation.detail

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.android_project_4a.R
import com.example.android_project_4a.domain.entity.Granblue_Character
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val characterJson = intent.getStringExtra("characterKey")
        val character = GsonBuilder().setLenient().create().fromJson(
            characterJson,
            Granblue_Character::class.java
        )

        val layout = findViewById<ConstraintLayout>(R.id.detailLayout)
        val txtName = findViewById<TextView>(R.id.charactername_txt)
        val txtAtk = findViewById<TextView>(R.id.characteratk_txt)
        val txtHp = findViewById<TextView>(R.id.characterhp_txt)
        val characterImage = findViewById<ImageView>(R.id.imageView2)
        val txtElement = findViewById<TextView>(R.id.characterelement_txt)
        val txtRace = findViewById<TextView>(R.id.characterrace_txt)
        val txtStyle = findViewById<TextView>(R.id.characterstyle_txt)
        val txtSpecialty = findViewById<TextView>(R.id.characterspecialty_txt)
        val txtGender = findViewById<TextView>(R.id.charactergender_txt)
        val txtVoice = findViewById<TextView>(R.id.charactervoice_txt)

        Picasso.get().load(character.getImgUrl()).into(characterImage)
        txtName.text = character.getName()
        txtAtk.text = String.format("MAX ATK: %s", java.lang.String.valueOf(character.getMaxATK()))
        txtHp.text = String.format("MAX HP: %s", java.lang.String.valueOf(character.getMaxHP()))
        txtElement.text = java.lang.String.format("Element: %s", character.getElement())
        txtRace.text = java.lang.String.format("Race: %s", character.getRace())
        txtStyle.text = java.lang.String.format("Style: %s", character.getStyle())
        txtSpecialty.text = java.lang.String.format("Specialty: %s", character.getSpecialty())
        txtGender.text = java.lang.String.format("Gender: %s", character.getGender())
        txtVoice.text = java.lang.String.format("Voice Actor: %s", character.getVoice_actor())

        var color = Color.WHITE
        when (character.getElement()) {

            "Dark" -> color = ContextCompat.getColor(baseContext,R.color.colorDarkElement)
            "Light" -> color = ContextCompat.getColor(baseContext,R.color.colorLightElement)
            "Fire" -> color = ContextCompat.getColor(baseContext,R.color.colorFireElement)
            "Water" -> color = ContextCompat.getColor(baseContext,R.color.colorWaterElement)
            "Earth" -> color = ContextCompat.getColor(baseContext,R.color.colorEarthElement)
            "Wind" -> color = ContextCompat.getColor(baseContext,R.color.colorWindElement)
        }
        layout.setBackgroundColor(color)
    }
}
