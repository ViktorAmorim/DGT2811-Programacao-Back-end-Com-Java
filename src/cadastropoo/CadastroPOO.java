/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.util.ArrayList;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author User
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        
        PessoaFisica pessoaFisica1 = new PessoaFisica(1, "Marcelo Barros", "123.456.789-01", 18);
        repo1.inserir(pessoaFisica1);
        
        PessoaFisica pessoaFisica2 = new PessoaFisica(2, "Antonio Viera", "555.421.765-02", 23);
        repo1.inserir(pessoaFisica2);
        
        
        repo1.persistir("pessoas_fisicas.bin");
        
        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("pessoas_fisicas.bin");
        
        
        ArrayList<PessoaFisica> lista = repo2.obterTodos();
        for(int i = 0; i < lista.size(); i++){
            lista.get(i).exibir();
        }
        
        
        
        
        
        
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica(1, "Frangos Assados Ldta", "12.345.678/0001-22");
        repo3.inserir(pessoaJuridica1);
        
        
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica(2,"Padaria do seu Zé", "55.321.743/0001-11");
        repo3.inserir(pessoaJuridica2);
        
        repo3.persistir("pessoas_juridicas.bin");
        
        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("pessoas_juridicas.bin");
        
        
        ArrayList<PessoaJuridica> listaPessoaJuridica = repo4.obterTodos();
        for(int i = 0; i < listaPessoaJuridica.size(); i++){
            listaPessoaJuridica.get(i).exibir();
        }
        
    }
    
}
