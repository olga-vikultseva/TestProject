package com.example.testproject.core

import java.util.*
import kotlin.properties.Delegates

class TextHolder {

    private val observers = mutableListOf<(String) -> Unit>()

    var text by Delegates.observable("Created at ${Date()}") { _, _, new ->
        observers.forEach { it(new) }
    }

    fun subscribe(listener: (String) -> Unit) {
        listener(text)
        observers.add(listener)
    }

    fun unsubscribe(listener: (String) -> Unit) {
        observers.remove(listener)
    }
}