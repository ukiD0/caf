package com.example.champ.mainPages

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.example.champ.R
import com.example.champ.databinding.FragmentTrackBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.osmdroid.config.Configuration.getInstance
import org.osmdroid.tileprovider.tilesource.TileSourceFactory


class Track : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTrackBinding.inflate(inflater)
        R.style.TranspererntStatusBar
        val footer: BottomNavigationView = activity!!.findViewById(R.id.bottomNavigationView1)
        footer.isVisible = true

        val card: CardView = activity!!.findViewById(R.id.cardView)
        card.isVisible = false

        binding.appCompatButton2.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_track_to_view_package)
        }


//        getInstance().load(requireContext(), PreferenceManager.getDefaultSharedPreferences(requireContext()))
//        binding.map.setTileSource(TileSourceFactory.MAPNIK)


        return binding.root
    }

}