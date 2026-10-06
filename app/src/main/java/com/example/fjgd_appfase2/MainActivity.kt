package com.example.fjgd_appfase2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.ui.tooling.preview.Preview
import com.example.fjgd_appfase2.ui.theme.FJGDAppFase2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FJGDAppFase2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        FormularioPeli()
                    }
                }
            }
        }
    }
}





@Preview( showBackground = true)
@Composable
fun PreviewFormulario() {
    FormularioPeli()
}



@Composable
fun FormularioPeli() {
    var titulo by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }
    var esVista by remember { mutableStateOf(false) }
    var anioEstreno by remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Registrar Película",
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título de la película") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = anioEstreno,
            onValueChange = { anioEstreno = it },
            label = { Text("Año de estreno") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = director,
            onValueChange = { director = it },
            label = { Text("Director") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )


        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = esVista,
                onCheckedChange = { esVista = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Ya vi la película")
        }

        Button(
            onClick = { },
            enabled = titulo.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Película")
        }

    }
}

