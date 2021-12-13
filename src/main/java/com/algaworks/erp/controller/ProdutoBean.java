package com.algaworks.erp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.algaworks.erp.model.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean {

	private String nomePesquisa;
	private Produto produto;
	private Produto produtoSelecionado;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;

	public ProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produtosFiltrados = new ArrayList<Produto>();
		this.produto = new Produto();
	}

	public void salvar() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}

	public void excluirFiltrados() {
		this.produtos.remove(this.produtoSelecionado);
		this.produtosFiltrados.remove(this.produtoSelecionado);
	}

	public void fabricantePesquisaAlterada(ValueChangeEvent event) {
		this.produtosFiltrados.clear();

		for (Produto produto : this.produtos) {
			if (produto.getNome() != null
					&& produto.getNome().toLowerCase().startsWith
					(event.getNewValue().toString().toLowerCase())) {
				this.produtosFiltrados.add(produto);
			}
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

}
