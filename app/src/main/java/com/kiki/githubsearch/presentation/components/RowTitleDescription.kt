package com.kiki.githubsearch.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowTitleDesc(
    title: String,
    description: String,
    modifier: Modifier = Modifier
){
    Surface(
        color = Color.White
    ) {

        Row (modifier = Modifier.padding(8.dp)) {

            Text(
                text = title,
                modifier = Modifier.weight(1f)
            )

            Spacer(Modifier.width(16.dp))

            Text(
                text = description,
                textAlign = TextAlign.End,
                modifier = Modifier.weight(3f)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowTitleBarPreview(
){
    MaterialTheme {
        RowTitleDesc("Followers", "This is Description This is DescriptionThis is Description This is DescriptionThis is Description This is DescriptionThis is Description This is Description")
    }
}