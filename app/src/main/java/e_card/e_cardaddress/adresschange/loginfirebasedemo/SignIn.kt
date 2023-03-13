package e_card.e_cardaddress.adresschange.loginfirebasedemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import e_card.e_cardaddress.adresschange.loginfirebasedemo.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.backPage.setOnClickListener {
            var i = Intent(this, SignUp::class.java)
            startActivity(i)
        }
//
        binding.loginBtn.setOnClickListener {
            login()
        }
    }

    fun login() {
        val email: String = binding.edtEmail.text.toString()
        val password: String = binding.edtPassword.text.toString()

        if (email.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Email/Password is Empty..", Toast.LENGTH_SHORT).show()
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this)
        {
            if (it.isSuccessful) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                var i = Intent(this, MainActivity::class.java)
                startActivity(i)
            } else {
                Toast.makeText(this, "Success Failure", Toast.LENGTH_SHORT).show()

            }
        }

    }
}