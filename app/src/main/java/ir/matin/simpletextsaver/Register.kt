package ir.matin.simpletextsaver

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ir.matin.simpletextsaver.databinding.FragmentRegisterBinding

const val USERNAME_KEY = "username_key"
const val PASSWORD_KEY = "password_key"
const val SHARED_PREF = "shared_prefs"

class Register : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedpreferences: SharedPreferences





    private var username: String? = null
    private var password: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edtUsername = binding.edtUserName.text
        val edtPassword = binding.edtPassword.text
        sharedpreferences = this.requireActivity()
            .getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)
        username = sharedpreferences.getString("EMAIL_KEY", null)
        password = sharedpreferences.getString("PASSWORD_KEY", null)

        binding.btnLogin.setOnClickListener {
            if (edtPassword?.length==0 && edtUsername?.length==0) {
                //if block
                Toast.makeText(context, "Please Enter Username and Password", Toast.LENGTH_SHORT)
                    .show()

            } else {
                //else block
                val editor = sharedpreferences.edit()

                // below two lines will put values for
                // email and password in shared preferences.
                editor.putString(USERNAME_KEY, edtUsername.toString())
                editor.putString(PASSWORD_KEY, edtPassword.toString())

                // to save our data with key and value.
                editor.apply()


                Toast.makeText(context, "You Create Your Account! Wellcome", Toast.LENGTH_SHORT).show()

            }


        }

    }


}