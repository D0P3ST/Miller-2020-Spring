package com.example.classapp

import android.app.Activity
//import android.app.FragmentTransaction
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.classapp.Fragments.ChampFragment
import com.example.classapp.Fragments.UserFragment
import com.example.classapp.Fragments.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_main2.*
import org.json.JSONArray
import java.io.IOException
import java.io.InputStream
import java.util.*
import androidx.fragment.app.FragmentTransaction as FragmentTransaction

class Main2Activity : AppCompatActivity(), ChampFragment.OnListFragmentInteractionListener {



    lateinit var itemFragment: ChampFragment
    //lateinit var fragment_user: UserFragment
    var names = arrayListOf<String>()
    var balance = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val newRival: Rival = Rival(rivalName = "Zehanort", rivalDescription = "dark wizard, trying to steal your girl", rivalyStart = Date(),
            age = 22, weight = 145, height = "6 foot", networth = 1000 )
        RivalManager.addRival(newRival)

        val user: UserModal = intent.getSerializableExtra("user") as UserModal

//        val userTextView: TextView = findViewById(R.id.user1)
//        val emailTextView: TextView = findViewById(R.id.email1)
//        userTextView.text = user.Username
//        emailTextView.text = user.Email
        val logout: Button = findViewById(R.id.action_button2)

        logout.setOnClickListener{

            val returnIntent: Intent = Intent()
            returnIntent.putExtra("returneduser", UserModal("asd", "asddd", "fgh", LoggedIn = false))
//            returnIntent.putExtra("returneduser", UserModal(user.Username, user.Email, user.Password, LoggedIn = false))

            addrival.setOnClickListener{
                genRival()
            }

            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        itemFragment = ChampFragment.newInstance(1)
        //fragment_user = UserFragment.newInstance("param 1", "param 2")




    }

    fun onListFragmentInteraction(item: Rival?) {
        TODO("Not yet implemented")
    }

    fun read_json(){
        var json : String? = null

        try{
            val inputString: InputStream = assets.open("rival.json")
            json = inputString.bufferedReader().use{it.readText()}

            var jsonar = JSONArray(json)

            for(i in 0..jsonar.length()-1){
                var jsonobject = jsonar.getJSONObject(i)
                names.add(jsonobject.getString("name"))
                balance.add(jsonobject.getString("balance"))
            }

            var adpt = ArrayAdapter(this,android.R.layout.simple_list_item_1,names)
            //json_list.adapter = adpt

            //json_list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            //    Toast.makeText(applicationContext, "The current balance of this Rival is:" + balance[position],Toast.LENGTH_LONG).show()
            //}

        } catch (e: IOException){

        }
    }



    fun genRival(){

            supportFragmentManager.beginTransaction().replace(R.id.container, itemFragment)
                .addToBackStack(itemFragment.toString()).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("Not yet implemented")
    }

    override fun onListFragmentInteraction(uri: Uri){

    }
}
