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
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.binarybrainz.ColaboratorViews.LoginView
import com.example.binarybrainz.ColaboratorViews.MenuABGView
import com.example.binarybrainz.StudentViews.ApartadoCasosCompartidosView
import com.example.binarybrainz.StudentViews.EditarCasosEstudiantesView
import com.example.binarybrainz.UserViews.MasInformacionView
import com.example.binarybrainz.UserViews.NecesitoAyudaView
import com.example.binarybrainz.ui.theme.BinaryBrainzTheme
import com.example.binarybrainz.UserViews.VistaPrincipal
import com.example.binarybrainz.UserViews.VistaServicios

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
            composable("vista_principal") {
                VistaPrincipal(navController)
            }
            composable("vista_servicios") {
                VistaServicios(navController)
            }
            composable("login_view") {
                LoginView(navController)
            }
            composable("necesito_ayuda_view") {
                NecesitoAyudaView()
            }
            composable("menu_abg_view") {
                MenuABGView(navController)
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
        }
    }
}

@Composable
fun ImageCard(imageId: Int, description: String, onClick: () -> Unit) {
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

@Preview(showBackground = true)
@Composable
fun VistaPrincipalPreview() {
    BinaryBrainzTheme {
        VistaPrincipal(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun VistaServiciosPreview() {
    BinaryBrainzTheme {
        VistaServicios(navController = rememberNavController())
    }
}
