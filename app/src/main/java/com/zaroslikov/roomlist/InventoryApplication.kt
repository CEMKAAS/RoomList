package com.zaroslikov.roomlist

import android.app.Application
import com.zaroslikov.roomlist.data.FermaDatabase

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    val database: FermaDatabase by lazy { FermaDatabase.getDatabase(this) }
}