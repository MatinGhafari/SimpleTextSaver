package ir.matin.simpletextsaver

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import ir.matin.simpletextsaver.databinding.FragmentProfileBinding
import ir.matin.simpletextsaver.databinding.FragmentRegisterBinding


class profile() : Fragment() {
    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val USER_NAME = "username_key"
        const val PASSWORD_KEY = "password_key"
    }
lateinit var binding: FragmentProfileBinding
    // variable for shared preferences.
    private lateinit var sharedpreferences: SharedPreferences
    private var username: String? = null
    private var password: String? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated(view, savedInstanceState)

         sharedpreferences = this.requireActivity()
            .getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)

        username = sharedpreferences.getString(USERNAME_KEY, null)
        password = sharedpreferences.getString(PASSWORD_KEY, null)

    binding.txtUserName.text = username
        binding.txtPassword.text =password



    }



    }
