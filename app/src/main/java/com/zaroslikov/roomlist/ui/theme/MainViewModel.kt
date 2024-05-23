package com.zaroslikov.roomlist.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.zaroslikov.roomlist.InventoryApplication
import com.zaroslikov.roomlist.data.AddTable
import com.zaroslikov.roomlist.data.FermaDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(private val fermaDao: FermaDao) : ViewModel() {


    var state by mutableStateOf(HomeUiState())
        private set


    init {
        itemNeco()
    }
//    private var itemUiState by mutableStateOf(AddDetails())


//    val itemId: Int = checkNotNull(savedStateHandle[AddProductDestination.itemIdArg])

//    fun uiState(): Flow<List<AddTable>> = fermaRepository.getAddProduct(itemId)
//    fun uiState(): Flow<List<AddTable>> = fermaRepository.getAddProduct(itemId)

//    suspend fun insertAddTable(addTable: AddTable) {
//        fermaRepository.insertAdd(addTable)
//    }

//    val sd: StateFlow<HomeUiState> =
//        fermaRepository.getAddProductAll().map { HomeUiState(it) }.stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
//            initialValue = HomeUiState()
//        )

//    suspend fun updateHome (homeUiState: HomeUiState)

//    fun getTable() = fermaRepository.getAddProduct(itemId).asLiveData(viewModelScope.coroutineContext)

//    val uiState2: LiveData<List<AddTable>> = fermaRepository.getAddProductAll2().asLiveData()
//
//    val items = fermaRepository.getAddProductAll2()
//
//    fun addItem(item: AddTable) = viewModelScope.launch(Dispatchers.IO) {
//        fermaRepository.insertAdd(item)
//    }
//
//    fun addItem2(item: AddTable) = viewModelScope.launch(Dispatchers.IO) {
//        fermaRepository.insertAdd2(item)
//    }

    fun itemNeco(): Flow<List<AddTable>> {
        return fermaDao.getAddProductAllNeco()
    }

//    fun itemNeco() {
//        viewModelScope.launch {
//            fermaDao.getAddProductAll2().collectLatest {
//                state = state.copy(
//                    itemList = it
//                )
//            }
//        }
//    }

    suspend fun insertNeco() {
        fermaDao.insertAdd(
            AddTable(
                id = 0,
                title = "dsd",
                count = 0.0,
            )
        )
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as InventoryApplication)
                MainViewModel(application.database.fermaDao())
            }
        }
    }


//    init {
//        viewModelScope.launch {
//            fermaRepository.insert(ProjectTable(
//                id = 0,
//                titleProject = "Sds",
//                dateBegin = "Sd",
//                dateFinal = "SDs",
////                            picture = picture,
//                status = 0,
//                mode = 1
//            ))
//        }
//    }
}


//    val todoList : LiveData<List<AddTable>> = fermaRepository.getAddProductAll()

//    fun insertIt() = viewModelScope.launch {
//
//        fermaRepository.insertAdd(itemUiState.toItem())
//
//    }

//    companion object {
//        private const val TIMEOUT_MILLIS = 1_000L
//    }


data class HomeUiState
    (val itemList: List<AddTable> = emptyList())


data class AddDetails(
    var id: Int = 0,
    var title: String = "",
    var count: Double = 0.0,
)

fun AddDetails.toItem(): AddTable = AddTable(
    id = id,
    title = title,
    count = count,

    )

fun AddTable.toItemDetal(): AddDetails = AddDetails(
    id = id,
    title = title,
    count = count,
)