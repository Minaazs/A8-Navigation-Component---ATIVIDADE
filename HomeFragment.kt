package com.example.livrostore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.livrostore.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding    
    private val listaLivros = listOf(
        Livro("Dom Casmurro", "Machado de Assis", 1899, 
            "Romance clássico da literatura brasileira sobre amor e traição."),
        Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943,
            "Fábula filosófica sobre um menino que viaja pelo universo."),
        Livro("1984", "George Orwell", 1949,
            "Distopia sobre um governo totalitário que controla tudo."),
        Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997,
            "Primeiro livro da saga do jovem bruxo Harry Potter.")
    )
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Configurar o RecyclerView
        setupRecyclerView()
    }
    
    private fun setupRecyclerView() {
        // Criar o adapter com a lista de livros
        val adapter = LivroAdapter(listaLivros) { livro ->
            // Quando clicar em um livro, navegar para detalhes
            navegarParaDetalhes(livro)
        }
        
        // Configurar o RecyclerView
        binding.recyclerViewLivros.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
    }
    
    private fun navegarParaDetalhes(livro: Livro) {
        // Usar Safe Args para passar os dados do livro
        val action = HomeFragmentDirections.actionHomeToDetalhes(
            titulo = livro.titulo,
            autor = livro.autor,
            ano = livro.ano,
            descricao = livro.descricao
        )
        
        // Navegar para o fragmento de detalhes
        findNavController().navigate(action)
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
