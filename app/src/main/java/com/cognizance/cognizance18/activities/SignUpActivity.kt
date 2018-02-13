package com.cognizance.cognizance18.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.cognizance.cognizance18.MainActivity
import com.cognizance.cognizance18.R
import com.cognizance.cognizance18.SessionManager
import com.cognizance.cognizance18.SignUpActivity1
import com.cognizance.cognizance18.interfaces.ApiInterface
import com.cognizance.cognizance18.models.LoginResponse
import com.cognizance.cognizance18.models.SignUpUser
import com.cognizance.cognizance18.models.User
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SignUpActivity : AppCompatActivity() {

    private val session by lazy {
        SessionManager(this)
    }


    private val BASE_URL = "https://api.cognizance.org.in/"
    private val LOG_TAG = "SignUpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val mode = intent.getStringExtra("mode")

        if (mode == "SIGN_IN") {
            sign_up_btn.text = "LOGIN"
            sign_up_head_txt.text = "Login"
            login_desc_text_view.visibility = View.GONE
            login_text_view.visibility = View.GONE
            name_edit_text.visibility = View.GONE
            mobile_edit_text.visibility = View.GONE
            sign_up_btn.setOnClickListener {
                val email = email_edit_text.text.toString()
                val password = password_edit_text.text.toString()
                login(email, password)
            }
        } else {
            login_desc_text_view.visibility = View.VISIBLE
            login_text_view.visibility = View.VISIBLE
            name_edit_text.visibility = View.VISIBLE
            mobile_edit_text.visibility = View.VISIBLE
            login_text_view.setOnClickListener{ view ->
                val intent = Intent(this@SignUpActivity, SignUpActivity::class.java).putExtra("mode", "SIGN_IN")
                startActivity(intent)
            }
            sign_up_btn.setOnClickListener {
                val name = name_edit_text.text.toString()
                val mobile = mobile_edit_text.text.toString()
                val email = email_edit_text.text.toString()
                val password = password_edit_text.text.toString()
                signUp(SignUpUser(email, password, mobile, name, "remote"))
            }
        }

    }

    private fun signUp(user: SignUpUser) {
        val call = getInterfaceService().signUp(user)
        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    session.createLoginSession(response.body())
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@SignUpActivity,
                            "Error : $response", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                Toast.makeText(this@SignUpActivity,
                        "Failed to send req : ${t?.message}", Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun login(email: String, password: String) {
        val user = User(email, password)
        val apiInterface = this.getInterfaceService()
        val service = apiInterface.authenticate(user)
        service.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    session.createLoginSession(response.body())
                    val intent = Intent(this@SignUpActivity, SignUpActivity1::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this@SignUpActivity, "Error : " + response.code(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {

            }
        })

    }

    private fun getInterfaceService(): ApiInterface {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(ApiInterface::class.java)
    }
}
