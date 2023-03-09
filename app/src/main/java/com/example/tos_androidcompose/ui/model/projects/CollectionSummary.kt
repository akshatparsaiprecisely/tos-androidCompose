package com.example.tos_androidcompose.ui.model.projects

data class CollectionSummary(var discard: Int = 0,
                             var approved: Int = 0,
                             var publish: Int = 0,
                             var pending: Int = 0,
                             var reSurvey: Int = 0,
                             var collectedData: Int = 0)
