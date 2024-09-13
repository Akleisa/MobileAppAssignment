package com.example.assessment2.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment2.R
import com.example.assessment2.viewmodel.LoginViewModel
import android.widget.Button
import android.widget.EditText
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    // Hilt will inject the LoginViewModel
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Fetch input fields from layout
        val usernameEditText = findViewById<EditText>(R.id.et_username)
        val passwordEditText = findViewById<EditText>(R.id.et_password)

        // Handle login button click
        findViewById<Button>(R.id.btn_login).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check for empty fields
            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginViewModel.login(username, password)
            } else {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Observe the login result from ViewModel
        loginViewModel.loginResult.observe(this) { loginResponse ->
            if (loginResponse != null) {
                // Login successful
                val keypass = loginResponse.keypass
                Log.d("LoginActivity", "Login successful: keypass = $keypass")
                startDashboardActivity(keypass)
            } else {
                // Login failed
                Log.e("LoginActivity", "Login failed")
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun startDashboardActivity(keypass: String) {
        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra("keypass", keypass)
        startActivity(intent)
    }
}
