import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2.data.DashboardResponse
import com.example.assessment2.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
) : ViewModel() {

    // LiveData to observe dashboard data
    val dashboardData: MutableLiveData<DashboardResponse?> = MutableLiveData()

    // Function to fetch dashboard data using the keypass
    fun getDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val response = dashboardRepository.getDashboardData(keypass)
                if (response.isSuccessful) {
                    dashboardData.postValue(response.body())
                } else {
                    dashboardData.postValue(null)  // Handle failure by posting null
                }
            } catch (e: Exception) {
                dashboardData.postValue(null)  // Post null on failure
            }
        }
    }
}
