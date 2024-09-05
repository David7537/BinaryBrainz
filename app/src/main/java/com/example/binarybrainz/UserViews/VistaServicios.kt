package com.example.binarybrainz.UserViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.binarybrainz.ImageCardVertical
import com.example.binarybrainz.ImageCardVertical
import com.example.binarybrainz.R
import com.example.binarybrainz.ui.theme.BinaryBrainzTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VistaServicios(navController: NavController, modifier: Modifier = Modifier) {
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Necesito Ayuda") },
                icon = { Icon(Icons.Filled.Info, contentDescription = null) },
                modifier = modifier.padding(8.dp),
                onClick = {})},
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp)
                    .height(50.dp),
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.clinicapenal),
                        contentDescription = "Logotipo de la Clínica Penal",
                        modifier = Modifier
                            .size(80.dp)
                            .padding(6.dp)
                    )
                },
                actions = {
                    IconButton(onClick = { navController.navigate("login_view") }) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = null)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            ImageCardVertical(
                imageId = R.drawable.clinicapenal,
                description = "Violencia Doméstica",
                onClick = { navController.navigate("mas_informacion_view/violencia_domestica") }
            )
            ImageCardVertical(
                imageId = R.drawable.clinicapenal,
                description = "Sentencia de Divorcio",
                onClick = { navController.navigate("mas_informacion_view/sentencia_divorcio") }
            )
            ImageCardVertical(
                imageId = R.drawable.clinicapenal,
                description = "Testamento",
                onClick = { navController.navigate("mas_informacion_view/testamento") }
            )
            ImageCardVertical(
                imageId = R.drawable.clinicapenal,
                description = "Pensión Alimenticia",
                onClick = { navController.navigate("mas_informacion_view/pension_alimenticia") }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaServiciosPreview() {
    BinaryBrainzTheme {
        VistaServicios(navController = rememberNavController())
    }
}
