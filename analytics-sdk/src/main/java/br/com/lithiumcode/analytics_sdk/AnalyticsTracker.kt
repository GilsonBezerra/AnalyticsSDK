package br.com.lithiumcode.analytics_sdk

import android.content.Context
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent
object AnalyticsTracker {
    private var firebaseAnalytics: FirebaseAnalytics? = null

    fun initialize(context: Context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }
    fun trackEvent(name: String, params: Map<String, String>? = null) {
        firebaseAnalytics?.logEvent(name) {
            params?.forEach { (key, value) ->
                param(key, value)
            }
        }
    }

}