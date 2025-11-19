package br.com.lithiumcode.analytics_sdk

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent

object AnalyticsTracker {
    private var firebaseAnalytics: FirebaseAnalytics? = null

    fun initialize(context: Context) {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context)
    }

    fun trackEvent(screen: String, event: String, Extraparams: Map<String, String>? = null) {
        val bundle = Bundle()
        bundle.putString("screen", screen)
        bundle.putString("event", event)
        Extraparams?.forEach { (key, value) ->
            bundle.putString(key, value)
        }
        firebaseAnalytics?.logEvent(event, bundle)
    }
}

