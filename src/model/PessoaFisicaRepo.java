/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PessoaFisicaRepo {
    
    private ArrayList<PessoaFisica> pessoas;
    
    public PessoaFisicaRepo(){
        pessoas = new ArrayList<>();
    }
    
    public void inserir(PessoaFisica pessoa){
        pessoas.add(pessoa);
    }
    
    public void alterar(PessoaFisica pessoa){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getId() == pessoa.getId()){
            pessoas.set(i, pessoa);
            return;
            }
        }
    }
    
    public void excluir(int id){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getId() == id){
            pessoas.remove(i);
            return;
            }
        }
    }
    
    public PessoaFisica obter( int id){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getId() == id){
                return pessoas.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<PessoaFisica> obterTodos(){
        return pessoas;
    }
    
}
