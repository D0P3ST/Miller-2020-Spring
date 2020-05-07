package com.example.classapp

import android.app.Activity
//import android.app.FragmentTransaction
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import androidx.fragment.app.FragmentTransaction as FragmentTransaction

class Main2Activity : AppCompatActivity(), ChampFragment.OnFragmentInteractionListener {



    lateinit var rivalFragment: ChampFragment
    lateinit var seerivalFragment: RivalFragment
    var names = arrayListOf<String>()
    var balance = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        ObjectBox.init(this)


        val logout: Button = findViewById(R.id.action_button2)


        logout.setOnClickListener{

            val returnIntent: Intent = Intent()
            returnIntent.putExtra("returneduser", UserModal("asd", "asddd", "fgh", LoggedIn = false))
//            returnIntent.putExtra("returneduser", UserModal(user.Username, user.Email, user.Password, LoggedIn = false))

            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        rivalFragment = ChampFragment()
        addrival.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, rivalFragment)
                .addToBackStack("main")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }

        seerivalFragment = RivalFragment()
        seerivals.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, seerivalFragment)
                .addToBackStack("main")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        }

       // rivalFragment = ChampFragment.newInstance(1)
        //fragment_user = UserFragment.newInstance("param 1", "param 2")




    }

    fun onListFragmentInteraction(item: Rival?) {
        TODO("Not yet implemented")
    }

//    fun read_json(){
//        var json : String? = null
//
//        try{
//            val inputString: InputStream = assets.open("rival.json")
//            json = inputString.bufferedReader().use{it.readText()}
//
//            var jsonar = JSONArray(json)
//
//            for(i in 0..jsonar.length()-1){
//                var jsonobject = jsonar.getJSONObject(i)
//                names.add(jsonobject.getString("name"))
//                balance.add(jsonobject.getString("balance"))
//            }
//
//            var adpt = ArrayAdapter(this,android.R.layout.simple_list_item_1,names)
//            //json_list.adapter = adpt
//
//            //json_list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//            //    Toast.makeText(applicationContext, "The current balance of this Rival is:" + balance[position],Toast.LENGTH_LONG).show()
//            //}
//
//        } catch (e: IOException){
//
//        }
//    }



//    fun genRival(){
//
//            supportFragmentManager.beginTransaction().replace(R.id.container, itemFragment)
//                .addToBackStack(itemFragment.toString()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
//    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("Not yet implemented")
    }
}
