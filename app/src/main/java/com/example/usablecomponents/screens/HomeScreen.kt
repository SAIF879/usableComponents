package com.example.usablecomponents.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.usablecomponents.ui.theme.*

@Preview
@Composable
fun HomeScreen(){
HomeItemList()
}

@Composable
fun HomeItemList(){
    LazyColumn(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(), contentPadding = PaddingValues(bottom = 70.dp)){
        item {
            androidx.compose.material.Text(
                text = "Activity",
                    modifier = Modifier.padding(10.dp, 5.dp),
                fontSize = 25.sp
            )
        }
        item { Spacer(modifier = Modifier.size(5.dp)) }
        items(10){
            HomeItemCard()
            Row() {
                Spacer(modifier = Modifier.width(100.dp))
                androidx.compose.material.Divider(
//                    Modifier.background(BottomLineColor),
                    thickness = 0.5.dp
                )
            }
        }

    }
}


@Composable
fun HomeItemCard(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(110.dp)
        .padding(6.dp)){
         Row (verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier
             .padding(5.dp)
             .fillMaxWidth()){
       Row(verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.Start) {
           FoodImageContainer()
           Spacer(modifier = Modifier.size(10.dp))
           Column(modifier = Modifier.padding(5.dp)) {
               FoodName(name = "safjadsnfkjndsa")
               FoodLocation(location = "afjhkjdfa asdkjfhaksdjfh dafdsfdsffffff")
               Row(verticalAlignment = Alignment.CenterVertically ) {
                   FoodQuantity(quantity = "3 KG")
                   Spacer(modifier = Modifier.size(5.dp))
                   FoodLifeBox(expired = false)
               }
           }
       }
             DeleteIcon()
         }
    }
}

@Composable
fun FoodImageContainer(size : Int = 70){
    Box(modifier = Modifier
        .size(size.dp)
        .background(Color.Red) , contentAlignment = Alignment.Center , ){

    }
}
@Composable
fun FoodLocation(location : String , maxLength : Int = 14){
    androidx.compose.material.Text(
        text = if (location.length > maxLength) "${location.take(maxLength)}..." else location,
        fontSize = 15.sp,  maxLines = 1
    )
}

@Composable
fun FoodName(name : String){
Text(text = name ,)
}

@Composable
fun FoodQuantity(quantity : String){
Text(text = quantity)
}

@Composable
fun FoodLifeBox(expired : Boolean){
    Box(modifier = Modifier
        .background(if (!expired) Green100 else Red100)
        .width(60.dp)
        .height(17.dp),
        contentAlignment = Alignment.Center) {
        Text(
            text = if (!expired) "unexpired" else "expired",
            fontSize = 9.sp,
            color = if (!expired) Green600 else Red600,
        )
    }
}

@Composable
fun DeleteIcon(size : Int  = 30 , iconSize : Int  = 15){

    Box(
        modifier = Modifier
            .size(size = size.dp)
            .aspectRatio(1f)
            .background(Red500, shape = CircleShape), contentAlignment = Alignment.Center
    ) {
        androidx.compose.material.Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "check_icon",
            modifier = Modifier.size(iconSize.dp)
        )
    }
}