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
public class PessoaJuridicaRepo {
    
    private ArrayList<PessoaJuridica> pessoas;
    
    public PessoaJuridicaRepo(){
        pessoas = new ArrayList<>();
    }
    
    public void inserir(PessoaJuridica pessoa){
        pessoas.add(pessoa);
    }
    
    public void alterar(PessoaJuridica pessoa){
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
    
    public PessoaJuridica obter(int id){
        for(int i = 0; i < pessoas.size(); i++){
            if(pessoas.get(i).getId() == id){
                return pessoas.get(i);
            }
        }
        return null;
    }
    
    public ArrayList<PessoaJuridica> obterTodos(){
        return pessoas;
    }
    
    
}
