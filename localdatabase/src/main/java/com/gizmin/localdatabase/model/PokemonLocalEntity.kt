package com.gizmin.localdatabase.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokemonLocalEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val isDefault: Boolean,
    val order: Int,
    val weight: Int
)