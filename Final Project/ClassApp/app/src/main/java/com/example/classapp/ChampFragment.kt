package com.example.classapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.fragment_item.view.*
import kotlinx.android.synthetic.main.fragment_item.view.BankAcc
import kotlinx.android.synthetic.main.fragment_item.view.PowerRating
import kotlinx.android.synthetic.main.fragment_item.view.RivalDesc
import kotlinx.android.synthetic.main.fragment_item.view.RivalName


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ChampFragment.OnFragmentInteractionListener] interface.
 */
class ChampFragment : Fragment() {

    // TODO: Customize parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item, container, false)

        view.SubmitButton.setOnClickListener{
        var name: String = ""
        var desc: String = ""
        var age: Int = 0
        var balance: Int = 0
        var powerrating: Int = 0
        if(RivalName != null){
            name = RivalName.text.toString()
        }
            if(RivalDesc != null){
                desc = RivalDesc.text.toString()
            }
            if(!Age.equals(0)){
                age = Age.text.toString().toInt()
                Log.d("number", "this is your rival's age: " + balance)
            }
            if(!BankAcc.equals(0)){
                balance = BankAcc.text.toString().toInt()
                Log.d("number", "this is your rival's bank account balance: " + balance)
            }
        if(!PowerRating.equals(0)){
            powerrating = PowerRating.rating.toInt()
            Log.d("number", "this is your rival's power level: " + powerrating)
        }

        if(!name.equals("") && !desc.equals("") && age != 0 && balance != 0 && powerrating != 0){
            for(i in 0 until powerrating step 1){
                var rival = Rival(0, name, desc, age, balance, powerrating)
                RivalManager.addRival(rival)
                Log.d("loop", "the database is working")
            }

        }
        else{
            //TODO: add error handling for empty string and rating
        }
            exitFrag()


    }
    // Inflate the layout for this fragment
    return view
    }

    private fun exitFrag() {
        fragmentManager?.beginTransaction()?.remove(this)?.addToBackStack("fragment transaction name, not required")
            ?.commit();
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChampFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)

                }
            }
    }
}
