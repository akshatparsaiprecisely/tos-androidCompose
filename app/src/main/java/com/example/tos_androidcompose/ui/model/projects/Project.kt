package com.example.tos_androidcompose.ui.model.projects

data class Project(
    var id: String = "",
    var name: String = "",
    var wmsURL: String = "",
    var formIds: List<String> = arrayListOf(),
    var projectSummary: CollectionSummary? = null
)