package com.example.android_project_4a.domain.entity

class Granblue_Character {
    private val name: String? = null
    private val maxHP = 0
    private val maxATK = 0
    private val element: String? = null
    private val race: String? = null
    private val style: String? = null
    private val specialty: String? = null
    private val gender: String? = null
    private val voice_actor: String? = null
    private val imgUrl: String? = null
    private val iconPath: String? = null

    fun getName(): String? {
        return name
    }

    fun getMaxHP(): Int {
        return maxHP
    }

    fun getMaxATK(): Int {
        return maxATK
    }

    fun getElement(): String? {
        return element
    }

    fun getRace(): String? {
        return race
    }

    fun getStyle(): String? {
        return style
    }

    fun getSpecialty(): String? {
        return specialty
    }

    fun getGender(): String? {
        return gender
    }

    fun getVoice_actor(): String? {
        return voice_actor
    }

    fun getImgUrl(): String? {
        return imgUrl
    }

    fun getIconPath(): String? {
        return iconPath
    }
}