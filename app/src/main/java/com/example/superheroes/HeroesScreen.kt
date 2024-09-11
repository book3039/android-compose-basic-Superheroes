package com.example.superheroes

import SuperheroesTheme
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroRepository

class HeroesScreen {

    @Composable
    fun SuperHeroList(
        heroes: List<Hero>,
        modifier: Modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium),
                    vertical = dimensionResource(id = R.dimen.padding_small)
                )
        ) {
            items(heroes) {hero ->
                SuperHeroItem(hero = hero)
            }
        }
    }

    @Composable
    fun SuperHeroItem(
        hero: Hero,
        modifier: Modifier = Modifier
    ) {
        Card(
            elevation = CardDefaults.cardElevation(2.dp),
            modifier = modifier
        ) {
            Row(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .sizeIn(minHeight = 72.dp)
            ) {
                SuperHeroInformation(
                    heroNameRes = hero.nameRes,
                    heroDescriptionRes = hero.descriptionRes,
                    modifier = Modifier.weight(1f)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .size(72.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    SuperHeroImage(
                        heroImage = hero.imageRes,
                    )
                }

            }

        }
    }

    @Composable
    fun SuperHeroInformation(
        @StringRes heroNameRes: Int,
        @StringRes heroDescriptionRes: Int,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = stringResource(id = heroNameRes),
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                text = stringResource(id = heroDescriptionRes),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
    }

    @Composable
    fun SuperHeroImage(
        @DrawableRes heroImage: Int,
    ) {

        Image(
            painter = painterResource(id = heroImage),
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.TopCenter,
            contentDescription = stringResource(id = R.string.description1),
        )
    }

    @Preview
    @Composable
    fun SuperHeroItemPreview() {
        SuperheroesTheme {

        }
    }

}