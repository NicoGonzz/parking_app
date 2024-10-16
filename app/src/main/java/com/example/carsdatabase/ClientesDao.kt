    package com.example.carsdatabase

    import androidx.room.Dao
    import androidx.room.Delete
    import androidx.room.Insert
    import androidx.room.OnConflictStrategy
    import androidx.room.Query
    import androidx.room.Update
    import kotlinx.coroutines.flow.Flow

    interface ClientesDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun savePerson(client: Clientes)

        @Update
        suspend fun updateClient(client: Clientes)

        @Delete
        suspend fun deletePerson(client: Clientes)

        @Query("DELETE FROM client_table WHERE client_id= :clienId")
        suspend fun deleteClientById(clienId: Int)

        @Query("SELECT * FROM client_table")
        fun getAllData() : Flow<List<Clientes>>
    }