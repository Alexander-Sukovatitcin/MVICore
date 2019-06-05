package com.badoo.mvicore.util

import com.badoo.mvicore.ModelWatcher
import com.badoo.mvicore.modelWatcher

fun <T> testWatcher(
    models: List<Model>,
    init: ModelWatcher.Builder<Model>.(result: MutableList<T>) -> Unit
): List<T> {
    val updates = mutableListOf<T>()
    val watcher = modelWatcher<Model> { init(updates) }
    models.forEach { watcher(it) }
    return updates
}
