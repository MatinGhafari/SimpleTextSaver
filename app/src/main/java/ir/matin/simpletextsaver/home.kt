package ir.matin.simpletextsaver

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import ir.matin.simpletextsaver.databinding.FragmentHomeBinding


class home : Fragment() {
 lateinit var binding:FragmentHomeBinding

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val USER_NAME = "username_key"
        const val PASSWORD_KEY = "password_key"
    }

    // variable for shared preferences.
    private lateinit var sharedpreferences: SharedPreferences



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentHomeBinding.inflate(layoutInflater,container , false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedpreferences = this.requireActivity()
            .getSharedPreferences(profile.SHARED_PREFS, Context.MODE_PRIVATE)


    }


            }

