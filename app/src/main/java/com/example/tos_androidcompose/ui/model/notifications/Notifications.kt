package com.example.tos_androidcompose.ui.model.notifications

data class Notification(
    var message: String = "",
    var title: String = "",
    var code: Int = 0,
    var createdOn: String = "",
    var id: String = ""
)