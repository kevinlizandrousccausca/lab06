

package com.example.nuevo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nuevo.ui.theme.NuevoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NuevoTheme {
                // Crear NavController
                val navController = rememberNavController()
                // Definir NavHost con rutas
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        CustomScaffold(navController = navController)
                    }
                    composable("profile") {
                        UserProfileScreen()
                    }
                    composable("settings") {
                        SettingsScreen()
                    }
                    composable("favorites") {
                        FavoritesScreen()
                    }
                    composable("trash") {
                        TrashScreen()
                    }
                }
            }
        }
    }
}

// Scaffold personalizado que utiliza el NavController para la navegación
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold(navController: NavController) {
    Scaffold(
        // Barra superior
        topBar = { CustomTopBar(navController = navController) },

        // Barra inferior
        bottomBar = { CustomBottomBar(navController = navController) },

        // Botón flotante personalizado
        floatingActionButton = { CustomFAB() },

        // Contenido principal
        content = { padding ->
            CustomContent(padding)
        }
    )
}

// TopAppBar personalizada que navega al perfil cuando se presiona el icono de la cuenta
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar(navController: NavController) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { /* Acción del menú */ }) {
                Icon(imageVector = Icons.Rounded.Menu, contentDescription = "Menu Icon")
            }
        },
        title = { Text(text = "Sample Title") },
        actions = {
            IconButton(onClick = { /* Acción de búsqueda */ }) {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = "Search Icon"
                )
            }
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Account Icon"
                )
            }
        }
    )
}

// BottomAppBar personalizada con navegación para cada botón
@Composable
fun CustomBottomBar(navController: NavController) {
    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly // Distribución uniforme
        ) {
            IconButton(onClick = { navController.navigate("settings") }) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings description")
            }
            IconButton(onClick = { navController.navigate("home") }) {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Home description",
                )
            }
            IconButton(onClick = { navController.navigate("favorites") }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorites description",
                )
            }
            IconButton(onClick = { navController.navigate("trash") }) {
                Icon(
                    Icons.Filled.Delete,
                    contentDescription = "Trash description",
                )
            }
        }
    }
}

// FloatingActionButton personalizada
@Composable
fun CustomFAB() {
    FloatingActionButton(onClick = { /* Acción del FAB */ }) {
        Text("whassap")
    }
}

// Contenido principal que utiliza el componente Greeting
@Composable
fun CustomContent(padding: PaddingValues) {
    Column(
        // Modificadores de estilo de la columna
        modifier = Modifier
            // Ocupar todo el espacio disponible
            .fillMaxSize()
            .padding(padding),

        // Contenido de la aplicación
        content = {
            Text(text = "aqui pondremos toda informacion")
        }
    )
}


// Función Greeting
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello, $name!", modifier = modifier)
}

// Pantalla de perfil del usuario
@Composable
fun UserProfileScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "User Profile", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is the profile screen.")
    }
}

// Pantalla de configuración
@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Settings", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is the settings screen.")
    }
}

// Pantalla de favoritos
@Composable
fun FavoritesScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Favorites", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is the favorites screen.")
    }
}

// Pantalla de la papelera
@Composable
fun TrashScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Trash", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "This is the trash screen.")
    }
}

// Vista previa del Scaffold en el IDE
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NuevoTheme {
        val navController = rememberNavController()
        CustomScaffold(navController = navController)
    }
}