package com.example.champ.database

import android.os.Parcel
import android.os.Parcelable
import com.example.champ.models.User
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from

/**
 *
 * @since was created at 09.02.24
 * @author Valentina Korovkina
 * @param Работа с supabase client -> обработка таблицы User
 *
 * **/

class connect_db() {

    fun getClient(): SupabaseClient{
        val client = createSupabaseClient(
            supabaseUrl = "https://dczfovliwangyliweyzu.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImRjemZvdmxpd2FuZ3lsaXdleXp1Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDY1NDg1MDcsImV4cCI6MjAyMjEyNDUwN30.Zor-ZnTqyhro213PXUCmPzXp1xobFXf7FEXLgMSJbK8"
        ) {
            install(Postgrest)
            install(Auth)
        }
        return client
    }

    suspend fun getUserByI(userId:Int): User{
        val client = getClient()
        val supabaseResponse = client.from("users").select {
            filter {
                eq("id",userId)
            }
        }
        val data = supabaseResponse.decodeSingle<User>()
        return data
    }

    suspend fun getUser(): List<User>{
        val supabaseResponse = getClient().from("users").select()
        return  supabaseResponse.decodeList()
    }

    suspend fun addUser(user: User): User{
        val supabaseResponse = getClient().from("users").insert(user)
        {
        select()
        }
        return supabaseResponse.decodeSingle()
    }

    suspend fun deleteUser(userId: Int): User{
        val supabaseResponse = getClient().from("users").delete{
            filter {
                eq("id",userId)
            }
        }
        return supabaseResponse.decodeSingle()
    }

    suspend fun updateUser(user: User):User{
        val supabaseResponse = getClient().from("users").update({
            User::email setTo user.email
        }
        ){
            filter {
                User::id eq user.id
            }
            select()
        }
        return supabaseResponse.decodeSingle()
    }


}



//    Иницилизация БД -> изменение данных
//    val db = DtatBaseMethod()
//    lifecycleScope.launch {
//        val user = db.updateUser(User(id=1, email = "polivanov004@gmail.com"))
//        binding.inputname.text = user.email
//    }