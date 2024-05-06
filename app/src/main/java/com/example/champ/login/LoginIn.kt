package com.example.champ.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.champ.R
import com.example.champ.database.connect_db
import com.example.champ.databinding.FragmentLoginInBinding
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginIn : Fragment() {
    private lateinit var binding: FragmentLoginInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginInBinding.inflate(inflater, container, false)

        binding.LoginIn.setOnClickListener {
            val db = connect_db()
            lifecycleScope.launch(Dispatchers.Main) {
                try{
                    db.getClient().auth.signInWith(Email){
                        email = binding.emailEditTextLogin.text.toString()
                        password = binding.passwordEditTextLogin.text.toString()
                    }
                }catch (e : Exception){
                    Log.e("login", e.message.toString())
                }

                db.getClient().auth.sessionStatus.collect{
                    when(it){
                        is SessionStatus.Authenticated -> {
                            Log.e("authenticated", it.toString())
                            goto()
//                            findNavController().navigate(R.id.action_loginIn_to_homeFragment)
                        }
                        SessionStatus.LoadingFromStorage -> {
                            Log.e("loadingfromstorage", it.toString())
                        }
                        SessionStatus.NetworkError -> {
                            Log.e("neterror", it.toString())
                        }
                        SessionStatus.NotAuthenticated -> {
                            Log.e("noauth", it.toString())
                        }
                    }

                }
            }


            Navigation.findNavController(binding.root).navigate(R.id.action_loginIn_to_homeFragment)
        }
        binding.forgotPass.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_loginIn_to_forgotpassword)
        }
        return binding.root
    }
    fun goto(){
        requireActivity().supportFragmentManager.popBackStack()
        //Navigation.findNavController(binding.root).popBackStack()
    }

}