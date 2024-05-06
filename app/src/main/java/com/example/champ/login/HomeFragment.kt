package com.example.champ.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.champ.BottomActivity
import com.example.champ.MainActivity
import com.example.champ.MyHelper
import com.example.champ.R
import com.example.champ.database.connect_db
import com.example.champ.databinding.FragmentHomeBinding
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.toJsonObject
import kotlinx.coroutines.launch
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put


class HomeFragment : Fragment() {
    private lateinit var db: connect_db
    lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //binding.security.movementMethod = LinkMovementMethod.getInstance()

        binding.tvSignIn.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_loginIn)
        }
        binding.google.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_bottomActivity)
            activity!!.finish()
            val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("isLogin",true)
            editor.apply()
        //activity!!.startActivity(Intent(activity, BottomActivity::class.java))
        }
        binding.SignUp.setOnClickListener {
            try {
                if (binding.fullName.text.length > 8 &&
                    binding.editText2.text.length > 8 &&
                    binding.editText3.text.contains("@") &&
                    binding.editText3.text.contains(".") &&
                    binding.editText3.text.length > 8 &&
                    binding.inpPassw.text.trim().equals(binding.inpPassw2.text.trim()) &&
                    binding.inpPassw.text.length > 4 &&
                    binding.checkPrivacy.isChecked){
                    val firs_name = binding.fullName.text.split(" ")[0]
                    val last_name = binding.fullName.text.split(" ")[1]
                    lifecycleScope.launch {
                        try {
                            db = connect_db()
                            db.getClient().auth.signInWith(Email){
                                email = binding.editText3.text.toString()
                                password = binding.inpPassw.text.toString()
                                data = buildJsonObject {
                                    put("first_name", firs_name)
                                    put("last_name", last_name)
                                    put("phone", binding.editText2.text.toString())
                                }
                            }


                            //Log.e("test", session?.email.toString())
                            checkStatus()
                        }catch (e:Exception){
                            MyHelper.alert(requireContext(), "Erorr", e.message.toString())
                        }
                    }
                }else{
                    MyHelper.alert(requireContext(), "Empty value", "Не все поля заполены верно")
                }
            }catch (e:Exception){
                MyHelper.alert(requireContext(), "Error", e.message.toString(), "Write to log file")
            }


        }
        return binding.root
    }


    suspend fun checkStatus(){
        db.getClient().auth.sessionStatus.collect{
            when(it){
                is SessionStatus.Authenticated -> {
                    Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_bottomActivity)
                    activity!!.finish()
                    val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putBoolean("isLogin", true)
                    editor.putString("email", binding.editText3.text.toString())
                    editor.putString("password", binding.inpPassw.text.toString())
                    editor.putString("token", it.session.accessToken)
                    editor.putString("user_name", it.session.user.toString())
                    editor.apply()
                }
                SessionStatus.LoadingFromStorage -> {
                }
                SessionStatus.NetworkError -> {
                    AlertDialog.Builder(requireContext())
                        .setTitle("Network error")
                        .setMessage(it.toString())
                        .setPositiveButton("Write to log") { _, _ -> }
                        .setNegativeButton("Cancel"){_, _ ->}
                        .show()
                }
                SessionStatus.NotAuthenticated -> {

                }
            }
        }
    }

}