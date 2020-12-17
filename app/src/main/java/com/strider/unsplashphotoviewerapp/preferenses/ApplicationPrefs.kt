package com.strider.unsplashphotoviewerapp.preferenses

import com.chibatching.kotpref.KotprefModel

object ApplicationPrefs : KotprefModel() {
    var accessToken by stringPref("")
    var tokenType by stringPref("")
    var scope by stringPref("")
    var createdAt by longPref(0)
}