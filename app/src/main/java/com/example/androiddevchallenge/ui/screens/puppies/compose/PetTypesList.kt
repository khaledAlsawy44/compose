package com.example.androiddevchallenge.ui.screens.puppies.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.screens.puppies.Pet
import com.example.androiddevchallenge.ui.screens.puppies.dummyPets
import com.example.androiddevchallenge.ui.theme.purpleColor
import com.example.androiddevchallenge.ui.theme.textColor
import com.example.androiddevchallenge.ui.theme.unSelectedItemBackGround

@Composable
fun PetsList(pets: List<Pet> = dummyPets) {
    LazyRow(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        items(pets) {
            PetItem(it)
            Spacer(modifier = Modifier.width(18.dp))
        }
    }
}


@Composable
fun PetItem(pet: Pet) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(if (pet.isSelected) purpleColor else unSelectedItemBackGround)
                .size(70.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(pet.picture),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = pet.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body1,
            color = textColor
        )

    }
}