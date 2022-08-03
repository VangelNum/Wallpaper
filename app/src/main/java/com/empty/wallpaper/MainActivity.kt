package com.empty.wallpaper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.*
import coil.request.ImageRequest
//import com.empty.wallpaper.ui.theme.MyRow
import com.empty.wallpaper.ui.theme.WallpaperTheme
import com.empty.wallpaper.ui.theme.itemRowModel
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Check()

        }
    }
}

@Composable
private fun Check() {
   LazyVerticalGrid(columns = GridCells.Fixed(2),
       verticalArrangement = Arrangement.spacedBy(10.dp),
       horizontalArrangement = Arrangement.spacedBy(10.dp),
       modifier = Modifier.padding(10.dp)
   ) {
       items(100){
            i ->
           Card(
               modifier = Modifier
               .aspectRatio(1f)
               .clip(RoundedCornerShape(20.dp))
               .background(Color.Green),
           ) {
               //Text(text = "Item $i")
               var temp = Random.nextInt(100,1000)
               SubcomposeAsyncImage(

                   model = "https://picsum.photos/$temp",
                   contentDescription = null
               ) {
                   val state = painter.state
                   if (state is AsyncImagePainter.State.Loading
                       || state is AsyncImagePainter.State.Error) {
                       CircularProgressIndicator()
                   } else {
                       SubcomposeAsyncImageContent()
                   }
               }


               //AsyncImage(painter = rememberAsyncImagePainter("https://picsum.photos/300/300"),
                 //  contentDescription = null)
           }
       }
   }

}
/*
@Composable
private fun Im_dow () {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(listOf(
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
            itemRowModel("https://picsum.photos/300/300"),
        ))
        {
            _,item->
            MyRow(item = item)
        }

        //Image(painter = rememberImagePainter("https://picsum.photos/300/300"),

    }


}
@Composable
private fun ListItem(name: String, prof: String) {
   Card(modifier = Modifier
       .fillMaxWidth()
       .padding(10.dp),
   shape = RoundedCornerShape(15.dp),
   elevation = 5.dp)
   {
        Box() {
           Row(verticalAlignment = Alignment.CenterVertically) {
               Image(painter = painterResource(id = R.drawable.ghoul1),
                   contentDescription = "Image",
                   contentScale = ContentScale.Crop,
                   modifier = Modifier
                       .padding(5.dp)
                       .size(64.dp)
                       .clip(CircleShape))
               Column() {
                   Text(text = "check")
                   Text(text = "check")
                   Text(text = "check")
               }

           }
        }
   }
}


 */