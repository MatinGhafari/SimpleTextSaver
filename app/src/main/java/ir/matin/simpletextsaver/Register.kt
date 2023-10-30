package ir.matin.simpletextsaver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ir.matin.simpletextsaver.databinding.FragmentHomeBinding
import ir.matin.simpletextsaver.databinding.FragmentRegisterBinding





class Register : Fragment() {
   lateinit var binding:FragmentRegisterBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding= FragmentRegisterBinding.inflate(layoutInflater,container , false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}