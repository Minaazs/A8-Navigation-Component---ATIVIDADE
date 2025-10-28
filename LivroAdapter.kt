package com.example.livrostore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livrostore.databinding.ItemLivroBinding

class LivroAdapter(
    private val livros: List<Livro>,
    private val onClick: (Livro) -> Unit
) : RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {
    
    // Classe que representa cada item da lista
    inner class LivroViewHolder(private val binding: ItemLivroBinding) :
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(livro: Livro) {
            // Mostrar os dados do livro
            binding.tvTitulo.text = livro.titulo
            binding.tvAutor.text = livro.autor
            
            // Quando clicar no item
            binding.root.setOnClickListener {
                onClick(livro)
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        // Criar o layout do item
        val binding = ItemLivroBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LivroViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        // Mostrar o livro na posição atual
        holder.bind(livros[position])
    }
    
    override fun getItemCount(): Int {
        // Quantidade de livros
        return livros.size
    }
}
