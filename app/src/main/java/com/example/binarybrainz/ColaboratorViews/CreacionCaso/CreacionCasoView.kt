package com.example.binarybrainz.ColaboratorViews.CreacionCaso

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.binarybrainz.ImageCardHorizontal
import com.example.binarybrainz.R
import com.example.binarybrainz.components.DrawerAbogados
import com.example.binarybrainz.components.TopBarAbogados
import com.example.binarybrainz.ui.theme.BinaryBrainzTheme



@Composable
fun MenuPlantillas(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerAbogados(navController = navController, drawerState = drawerState)
        }
    ) {
        Scaffold(
            topBar = {
                TopBarAbogados(navController = navController, drawerState = drawerState)
            }
        ) { paddingValues ->
            // Contenido principal de MenuABGView
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Creacion de Casos",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                        .padding(paddingValues)
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ImageCardHorizontal(
                        imageId = R.drawable.clinicapenal,
                        description = "Crear Plantilla",
                        onClick = { }
                    )
                    ImageCardHorizontal(
                        imageId = R.drawable.clinicapenal,
                        description = "Plantilla 1",
                        onClick = { }
                    )
                    ImageCardHorizontal(
                        imageId = R.drawable.clinicapenal,
                        description = "Plantilla 2",
                        onClick = { }
                    )
                    ImageCardHorizontal(
                        imageId = R.drawable.clinicapenal,
                        description = "Plantilla 3",
                        onClick = { }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuABGViewPreview() {
    BinaryBrainzTheme {
        MenuPlantillas(navController = rememberNavController())
    }
}