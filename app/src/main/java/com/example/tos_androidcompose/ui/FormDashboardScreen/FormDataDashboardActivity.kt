package com.example.tos_androidcompose.ui.FormDashboardScreen

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.tos_androidcompose.ui.chats.ui.theme.TosandroidComposeTheme

class FormDataDashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TosandroidComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column (modifier = Modifier
                        .height(400.dp)
                        .fillMaxWidth()) {
                        openImagePicker()
                        documentPicker()
                    }
                }
            }
        }
    }

    @Composable
    fun openImagePicker() {
        val context = LocalContext.current
        val openFileLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri ->
            // Handle the selected file URI here
        }

        val selectedFileUri = remember { mutableStateOf<Uri?>(null) }

        Button(
            onClick = {
                // Launch the file picker
                openFileLauncher.launch("image/*")
            }
        ) {
            Text("Select a file")
        }
    }
    
    @Composable
    fun documentPicker() {
        val context = LocalContext.current
        val openDocumentLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.OpenDocument()
        ) { uri ->
            // Handle the selected document URI here
        }

        val selectedDocumentUri = remember { mutableStateOf<Uri?>(null) }

        Button(
            onClick = {
                // Launch the document picker
                openDocumentLauncher.launch(arrayOf(
                    "application/msword",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                    "application/vnd.ms-powerpoint",
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation",
                    "application/vnd.ms-excel",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                    "text/plain",
                    "text/csv",
                    "application/pdf",
                    "application/zip"
                ))
            }
        ) {
            Text("Select a document")
        }
    }
}