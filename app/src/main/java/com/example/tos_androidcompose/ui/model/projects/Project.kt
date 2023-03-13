package com.example.tos_androidcompose.ui.model.projects

data class Project(
    var id: String = "",
    var name: String = "",
    var wmsURL: String = "",
    var drawable: Int = 0,
    var formIds: List<String> = arrayListOf(),
    var projectSummary: CollectionSummary? = null

)