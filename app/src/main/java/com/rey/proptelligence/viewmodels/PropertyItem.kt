import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.rey.proptelligence.ApiService.CitiesInfoItem

@Composable
fun PropertyItem(property: CitiesInfoItem) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(300.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(0.5.dp, Color.Gray, shape = RoundedCornerShape(8.dp)), // Make card fill width
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), // Add elevation
        shape = RoundedCornerShape(8.dp), // Add rounded corners
        colors = CardDefaults.cardColors(containerColor = Color.White) // Set card color
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp) // Add padding within the card
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(property.propertyPhoto)
                    .crossfade(true)
                    .build(),
                contentDescription = "Property Image",
                modifier = Modifier

                    .fillMaxSize()
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(16.dp) // Add padding within the card
            ) {

                Text(text = property.propertyName, color = Color.Black, fontWeight = FontWeight.SemiBold)
                Text(text = property.description, color = Color.Black)


                Row {
                    Text(text = "Price: ", color = Color.Red, fontWeight = FontWeight.SemiBold)
                    Text(text = property.Price, color = Color.Red)
                }

                Row {
                    Text(text = "Location: ", color = Color.Black, fontWeight = FontWeight.SemiBold)
                    Text(text = property.Locality, color = Color.Black)
                }

            }


        }
    }
}