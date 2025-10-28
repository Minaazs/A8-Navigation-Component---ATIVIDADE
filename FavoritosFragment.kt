package com.example.livrostore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.livrostore.databinding.FragmentFavoritosBinding

class FavoritosFragment : Fragment() {
    
    private var _binding: FragmentFavoritosBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Aqui você pode adicionar lógica para mostrar favoritos
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
