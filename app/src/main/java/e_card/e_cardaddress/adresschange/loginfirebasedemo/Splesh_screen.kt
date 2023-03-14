package e_card.e_cardaddress.adresschange.loginfirebasedemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Splesh_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splesh_screen)


        Handler().postDelayed(Runnable {
            val i = Intent(this, SignIn::class.java)
            startActivity(i)
            finish()
        }, 500)
    }
}
