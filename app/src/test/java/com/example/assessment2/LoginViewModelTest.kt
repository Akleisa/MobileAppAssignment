package com.example.assessment2

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.assessment2.data.LoginResponse
import com.example.assessment2.repository.LoginRepository
import com.example.assessment2.viewmodel.LoginViewModel
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.test.resetMain

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    // Declare testDispatcher and loginRepository
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginRepository: LoginRepository // You need this
    private val loginResultObserver: Observer<LoginResponse?> = mockk(relaxed = true)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        // Initialize the loginRepository here
        loginRepository = mockk(relaxed = true)

        // Initialize the ViewModel with the loginRepository
        loginViewModel = LoginViewModel(loginRepository)

        // Observe changes in the login result
        loginViewModel.loginResult.observeForever(loginResultObserver)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the Main dispatcher to the original one
        loginViewModel.loginResult.removeObserver(loginResultObserver)
    }

    @Test
    fun `login is successful`() = runTest(testDispatcher) {
        // Test logic goes here
    }
}
