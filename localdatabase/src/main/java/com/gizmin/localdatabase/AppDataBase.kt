package com.gizmin.localdatabase

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.gizmin.localdatabase.model.PokemonLocalEntity

@Database(entities = [
    PokemonLocalEntity::class
], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao
}

@Dao
interface PokemonDao {

    @Query( "SELECT * FROM pokemonlocalentity")
    fun fetchPokemon(): List<PokemonLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPokemon(pokemonLocalEntity: PokemonLocalEntity): Long

    @Delete
    fun removePokemon(pokemonLocalEntity: PokemonLocalEntity)

    @Query("DELETE FROM pokemonlocalentity")
    fun clearPokemon()
}