package com.example.t2_natureapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.t2_natureapp.ui.theme.T2NatureAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            T2NatureAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NatureApp((innerPadding))
                }
            }
        }
    }
}

data class NaturalPlace(
    val name: String,
    val description: String,
    val imageUrl: String
)

val naturalPlaces = listOf(
    NaturalPlace(
        name = "Tokio",
        description = "Capital de Japón. Es una metropolis vibrante llena de tradición y y modernidad.",
        imageUrl = "https://p0.pxfuel.com/preview/605/49/307/city-and-urban-hd-wallpaper-japan-lights.jpg"
    ),
    NaturalPlace(
        name = "Noruega",
        description = "Se encuentra en la capital de Noruega, Oslo. Fue una residencia real que se convirtio en fortaleza militar",
        imageUrl = "https://p1.pxfuel.com/preview/539/76/845/akershus-fortress-at-night-norway.jpg"
    ),
    NaturalPlace(
        name = "Chichén Itzá",
        description = "Fue una ciudad de la civilización Maya, se encuentra en Yucatán, México. Aqui se pueden encontrar templos, area de juego de pelota y el Cenote Sagrado",
        imageUrl = "https://p1.pxfuel.com/preview/91/233/318/pyramid-kukulcan-maya-mexico.jpg"
    ),
    NaturalPlace(
        name = "Machu Picchu",
        description = "Ciudad Antigua que se encuentra en los Andes, en Cusco, Perú. Era un santuario religioso, centro agrícola y residencia de élite",
        imageUrl = "https://e1.pxfuel.com/desktop-wallpaper/167/295/desktop-wallpaper-machu-picchu.jpg"
    ),
    NaturalPlace(
        name = "Petra",
        description = "Antigua ciudad nabatea, se encuentra en el desierto de Jordania. Es conocida como 'la ciudad rosa' por la piedra de sus edificios",
        imageUrl = "https://e0.pxfuel.com/wallpapers/240/220/desktop-wallpaper-petra.jpg"
    ),
)

@Composable
fun NatureApp(paddingValues: PaddingValues) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(naturalPlaces) { place ->
            NaturalPlaceCard(place)
        }
    }
}

@Composable
fun NaturalPlaceCard(place: NaturalPlace) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberImagePainter(data = place.imageUrl),
                contentDescription = place.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = place.name)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = place.description)

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_7A
)
@Composable
fun GreetingPreview() {
    T2NatureAppTheme {
        NatureApp(PaddingValues(0.dp))
    }
}