package com.zaroslikov.roomlist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ AddTable::class],
    version = 1,
    exportSchema = false
)
abstract class FermaDatabase : RoomDatabase() {

    abstract fun fermaDao(): FermaDao

    companion object {
        @Volatile
        private var Instance: FermaDatabase? = null

        fun getDatabase(context: Context): FermaDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, FermaDatabase::class.java, "item_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}