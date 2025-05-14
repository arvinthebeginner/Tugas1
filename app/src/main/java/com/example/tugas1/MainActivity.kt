package com.example.tugas1
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tugas1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnLogin.setOnClickListener {
            val fullname = binding.editFullname.text.toString()
            val username = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            val confirm = binding.editConfirm.text.toString()

            if (fullname.isNotBlank() && username.isNotBlank() && password.isNotBlank() && password == confirm) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            } else if(password != confirm){
                Toast.makeText(this, "password tidak sama dengan konfirmasi!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "data tidak boleh ada yang kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
