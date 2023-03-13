package e_card.e_cardaddress.adresschange.loginfirebasedemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import e_card.e_cardaddress.adresschange.loginfirebasedemo.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.signIn.setOnClickListener {
            signUpUser()
        }
        binding.backPage.setOnClickListener {
            var i = Intent(this, SignIn::class.java)
            startActivity(i)
        }
    }

    private fun signUpUser() {
        val email: String = binding.edtEmail.text.toString()
        val password: String = binding.edtPassword.text.toString()
        val conformPassword: String = binding.edtConformPassword.text.toString()

        if (email.isBlank() || password.isBlank() || conformPassword.isBlank()) {
            Toast.makeText(this, "Email and Password Empty....", Toast.LENGTH_SHORT).show()
            return
        }
        if (password != conformPassword) {
            Toast.makeText(this, "Password and Conform Password no match....", Toast.LENGTH_SHORT)
                .show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this)
        {
            if (it.isSuccessful) {
                Toast.makeText(this, "LOGIN SUCCESSFULLY", Toast.LENGTH_SHORT).show()
                var i = Intent(this, SignIn::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "-Error-", Toast.LENGTH_SHORT).show()
            }
        }
    }
}