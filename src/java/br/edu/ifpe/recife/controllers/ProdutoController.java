/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.classes.Produto;
import br.edu.ifpe.recife.model.dao.ManagerDao;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author melo
 */

@ManagedBean
@SessionScoped
public class ProdutoController {
    
    private Produto cadastro;
    private Produto selecao;
    
    @PostConstruct
    public void init(){
        this.cadastro = new Produto();
    }
    
    public String insert(){
        ManagerDao.getCurrentInstance().insert(this.cadastro);
//        repositorios.RepositorioProduto.getCurrentInstance().inserir(cadastro);
                
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Produto "+this.cadastro.getNome() +" cadastrado com sucesso!"));

        this.cadastro = new Produto();
        return "apresentaprodutos.xhtml";
    }
    
    public List<Produto> readAll(){
    
        String query = "select p from Produto p";
        return ManagerDao.getCurrentInstance().read(query, Produto.class);
    }

    public Produto getCadastro() {
        return cadastro;
    }

    public void setCadastro(Produto cadastro) {
        this.cadastro = cadastro;
    }    

    public Produto getSelecao() {
        return selecao;
    }

    public void setSelecao(Produto selecao) {
        this.selecao = selecao;
    }
    
    
    
}
