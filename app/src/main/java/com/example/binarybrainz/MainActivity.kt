package com.example.binarybrainz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.binarybrainz.ColaboratorViews.CasosPendientes.MenuCasosPendientesScreen
import com.example.binarybrainz.ColaboratorViews.CreacionCaso.MenuPlantillas
import com.example.binarybrainz.ColaboratorViews.LoginView
import com.example.binarybrainz.StudentViews.ApartadoCasosCompartidosView
import com.example.binarybrainz.StudentViews.EditarCasosEstudiantesView
import com.example.binarybrainz.UserViews.MasInformacionView
import com.example.binarybrainz.UserViews.NecesitoAyudaView
import com.example.binarybrainz.ui.theme.BinaryBrainzTheme
import com.example.binarybrainz.UserViews.VistaServicios
import com.example.binarybrainz.ColaboratorViews.Historial.HistorialScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            BinaryBrainzTheme {
                AppNavigation()
            }
        }
    }

    @Composable
    fun AppNavigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "vista_servicios") {
            composable("vista_servicios") {
                VistaServicios(navController)
            }
            composable("login_view") {
                LoginView(navController)
            }
            composable("necesito_ayuda_view") {
                NecesitoAyudaView()
            }
            composable("apartado_casos_compartidos_view") {
                ApartadoCasosCompartidosView(navController, "Estudiante")
            }
            composable("edit_case_view/{caseId}") { backStackEntry ->
                val caseId = backStackEntry.arguments?.getString("caseId") ?: "N/A"
                EditarCasosEstudiantesView(navController, caseId)
            }
            composable(
                "mas_informacion_view/{servicioDescription}",
                arguments = listOf(navArgument("servicioDescription") { type = NavType.StringType })
            ) { backStackEntry ->
                val servicioDescription = backStackEntry.arguments?.getString("servicioDescription")
                MasInformacionView(navController, servicioDescription)
            }
            composable("menu_historial_view") {
                HistorialScreen(navController)
            }
            composable("menu_casos_pendientes_view") {
                MenuCasosPendientesScreen(navController)
            }
            composable("creacion_caso_view") {
                MenuPlantillas(navController)
            }
        }
    }
}

@Composable
fun ImageCardVertical(imageId: Int, description: String, onClick: () -> Unit) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(16.dp)
            .safeDrawingPadding(),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = description,
                    modifier = Modifier
                        .padding(16.dp)
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = description
                )
                Button(
                    modifier = Modifier.padding(8.dp),
                    onClick = onClick
                ) {
                    Text(text = "Más información")
                }
            }
        }
    }
}

@Composable
fun ImageCardHorizontal(imageId: Int, description: String, onClick: () -> Unit) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(12.dp)
            .padding(vertical = 16.dp)
            .width(300.dp)
            .safeDrawingPadding(),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = description,
                    modifier = Modifier
                        .padding(16.dp)
                )
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = description
                )
                Button(
                    modifier = Modifier.padding(8.dp),
                    onClick = onClick
                ) {
                    Text(text = "Crear")
                }
            }
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
