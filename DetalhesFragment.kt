package com.example.livrostore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.livrostore.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {
    
    private var _binding: FragmentDetalhesBinding? = null
    private val binding get() = _binding!!
    
    // Receber os argumentos usando Safe Args
    private val args: DetalhesFragmentArgs by navArgs()
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Mostrar os detalhes do livro
        mostrarDetalhes()
        
        // Configurar o botão
        setupBotao()
    }
    
    private fun mostrarDetalhes() {
        // Pegar os dados recebidos via Safe Args
        binding.tvTituloLivro.text = args.titulo
        binding.tvAutor.text = "Autor: ${args.autor}"
        binding.tvAno.text = "Ano: ${args.ano}"
        binding.tvDescricao.text = args.descricao
    }
    
    private fun setupBotao() {
        binding.btnFavoritar.setOnClickListener {
            // Mostrar mensagem quando clicar
            Toast.makeText(
                requireContext(),
                "${args.titulo} adicionado aos favoritos!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
