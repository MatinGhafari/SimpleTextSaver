package ir.matin.simpletextsaver

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.matin.simpletextsaver.databinding.DialogAddItemBinding
import ir.matin.simpletextsaver.databinding.FragmentHomeBinding
import ir.matin.simpletextsaver.databinding.ItemRecyclerBinding


class home : Fragment(), HomeAdapter.TextEvent {
    lateinit var binding: FragmentHomeBinding
    lateinit var textDao: Dao
    lateinit var adapter :HomeAdapter
    lateinit var itemRecycler: ItemRecyclerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemRecycler = ItemRecyclerBinding.inflate(layoutInflater)
        textDao = MyDataBase.getDataBase(requireContext()).foodDao
        showAllData()
        var data = ArrayList<Text>()
        val adapter = HomeAdapter(data , this)


        binding.btnAddText.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext()).create()
            val dialogBinding = DialogAddItemBinding.inflate(layoutInflater)
            dialog.setView(dialogBinding.root)
            dialog.setCancelable(true)
            dialog.show()

            dialogBinding.btnDone.setOnClickListener {

                if (dialogBinding.dialogEdtTitle.text!!.isNotEmpty() && dialogBinding.dialogEdtSubTitle.text!!.isNotEmpty()) {
                    val title = dialogBinding.dialogEdtTitle.text.toString()
                    val subtitle = dialogBinding.dialogEdtSubTitle.text.toString()

                    val newText = Text(title, subtitle)

                    adapter.addText(newText)
                    textDao.insertText(newText)
                    dialog.dismiss()
                    binding.recyclerview.scrollToPosition(0)
                    showAllData()


                } else {
                    Toast.makeText(
                        requireContext(),
                        "Please Enter Title and Subtitle",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


        }

        itemRecycler.btnDeleteText.setOnClickListener {

           // adapter.removeText()

        }

    }

    private fun showAllData() {
        val textData = textDao.getAllText()
        val myAdapter = HomeAdapter(ArrayList(textData) , this)
        binding.recyclerview.adapter = myAdapter
        binding.recyclerview.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }

    override fun onDeleteClick(text: Text, pos: Int) {
        val textData = textDao.getAllText()
        adapter = HomeAdapter(ArrayList(textData) , this)
        adapter.removeText(text , pos)
        textDao.deleteText(text)
        showAllData()

    }
}

