/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.util.ArrayList;
import java.util.Scanner;
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
        
        
        
        Scanner scan = new Scanner(System.in);
        int option = -1;
        
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        
        while(option != 0){
            
            // menus fixos para guia.
            System.out.println("=========================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Salvar Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("========================");
            System.out.print("Escolhar uma opção: ");
            
            option = scan.nextInt();
            
         
            // if das opções do menu acima.
            if(option == 1){
                System.out.println("Tipo (F - Fisica / J - Juridica): ");
                String tipo = scan.next().toUpperCase();
                
                if(tipo.equals("F")){
                    System.out.println("Cadastro de pessoa Fisica selecionado.");
                    
                    System.out.print("ID: ");
                    int id = scan.nextInt();
                    
                    System.out.print("Nome: ");
                    scan.nextLine();
                    String nome = scan.nextLine();
                    
                    System.out.print("CPF: ");
                    String cpf = scan.next();
                    
                    System.out.print("Idade: ");
                    int idade = scan.nextInt();
                    
                    PessoaFisica pFisica = new PessoaFisica(id, nome, cpf, idade);
                    repoFisica.inserir(pFisica);
                    
                    System.out.println("Pessoa Física cadastrada com sucesso.");
                    
                } else if(tipo.equals("J")){
                    System.out.println("Cadastro de pessoa Juridica selecionado.");
                    
                    System.out.print("ID: ");
                    int id = scan.nextInt();
                    
                    System.out.print("Nome: ");
                    scan.nextLine();
                    String nome = scan.nextLine();
                    
                    System.out.print("CNPJ: ");
                    String cnpj = scan.next();
                    
                    PessoaJuridica pJuridica = new PessoaJuridica(id, nome, cnpj);
                    repoJuridica.inserir(pJuridica);
                    
                    System.out.println("Pessoa Juridica cadastrada com sucesso.");
                    
                } else {
                    System.out.println("Selecione uma opção válida.");
                }
                
                
            
            } else if(option == 2){
                System.out.println("Tipo (F - Fisica / J - Juridica): ");
                String tipo = scan.next().toUpperCase();
                
                System.out.print("ID: ");
                int id = scan.nextInt();
                
                if(tipo.equals("F")){
                    System.out.println("Alterar pessoa Fisica");
                    
                    PessoaFisica pFisica = repoFisica.obter(id);
                    if(pFisica != null){
                        System.out.println("Dados atuais: ");
                        pFisica.exibir();
                        
                        System.out.println("Informe os novos dados: ");
                        System.out.print("Nome: ");
                        scan.nextLine();
                        String nome = scan.nextLine();
                        
                        System.out.print("CPF: ");
                        String cpf = scan.next();
                        
                        System.out.print("Idade: ");
                        int idade = scan.nextInt();
                        
                        pFisica.setNome(nome);
                        pFisica.setCpf(cpf);
                        pFisica.setIdade(idade);
                        
                        System.out.println("Pessoa fisica alterada com sucesso.");
                    } else{
                        System.out.println("Pessoa fisica não encontrada.");
                    }
                    
                    

                } else if(tipo.equals("J")){
                    System.out.println("Alterar pessoa Juridica.");
                    
                    PessoaJuridica pJuridica = repoJuridica.obter(id);
                    if(pJuridica != null){
                        System.out.println("Dados atuais: ");
                        pJuridica.exibir();
                        
                        System.out.println("Informe os novos dados: ");
                        
                        System.out.print("Nome: ");
                        scan.nextLine();
                        String nome = scan.nextLine();
                        
                        System.out.print("CNPJ: ");
                        String cnpj = scan.next();
                        
                        pJuridica.setNome(nome);
                        pJuridica.setCnpj(cnpj);
                        
                        System.out.println("Pessoa juridica alterada com sucesso.");
                    } else{
                        System.out.println("Pessoa Juridica não encontrada.");
                    }
                    
                
                } else{
                    System.out.println("Selecione uma opção valida.");
                }
            
            } else if (option == 3){
                System.out.println("Tipo (F - Fisica / J - Juridica): ");
                String tipo = scan.next().toUpperCase();
                
                System.out.print("ID: ");
                int id = scan.nextInt();
                
                if(tipo.equals("F")){
                    repoFisica.excluir(id);
                    System.out.println("Pessoa Fisica excluida com sucesso.");
                } else if(tipo.equals("J")){
                    repoJuridica.excluir(id);
                    System.out.println("Pessoa Juridica excluida com sucesso.");
                } else{
                    System.out.println("Tipo invalido.");
                }
            
            } else if(option == 4){
                System.out.println("Tipo (F - Fisica / J - Juridica): ");
                String tipo = scan.next().toUpperCase();
                
                System.out.print("ID: ");
                int id = scan.nextInt();
                
                if(tipo.equals("F")){
                    PessoaFisica pFisica = repoFisica.obter(id);
                    if(pFisica != null){
                        pFisica.exibir();
                    } else{
                        System.out.println("Pessoa Fisica não encontrada.");
                    }
                } else if(tipo.equals("J")){
                    PessoaJuridica pJuridica = repoJuridica.obter(id);
                    if(pJuridica != null){
                        pJuridica.exibir();
                    } else{
                        System.out.println("Pessoa Juridica não encontrada.");
                    }
                } else{
                    System.out.println("Tipo invalido.");
                }
            
            } else if(option == 5){
                System.out.println("Tipo (F Física / J - Juridica): ");
                String tipo = scan.next().toUpperCase();
                
                if(tipo.equals("F")){
                    ArrayList<PessoaFisica> listaFisica = repoFisica.obterTodos();
                    if(listaFisica.isEmpty()){
                        System.out.println("Nenhnuma pessoa fisica cadastrada.");
                    } else{
                        for(int i = 0; i < listaFisica.size(); i++){
                            listaFisica.get(i).exibir();
                        }
                    }
                } else if(tipo.equals("J")){
                    ArrayList<PessoaJuridica> listaJuridica = repoJuridica.obterTodos();
                    if(listaJuridica.isEmpty()){
                        System.out.println("Nenhuma pessoa Juridica cadastrada.");
                    } else{
                        for(int i = 0; i < listaJuridica.size(); i++){
                            listaJuridica.get(i).exibir();
                        }
                    }
                } else{
                    System.out.println("Tipo invalido.");
                }
            
            } else if(option == 6){
                System.out.print("Informe o prefixo dos arquivos para salvar: ");
                String prefixo = scan.next();
                
                try{
                    repoFisica.persistir(prefixo + ".fisica.bin");
                    repoJuridica.persistir(prefixo + ".juridica.bin");
                    
                    System.out.println("Dados salvos com sucesso.");
                } catch(Exception e){
                    System.out.println("Erro ao salvar os dados.");
                }
            
            } else if(option == 7){
                System.out.print("Informe o prefixo dos arquivos para recuperar: ");
                scan.nextLine();
                String prefixo = scan.nextLine();
                
                try{
                repoFisica.recuperar(prefixo + ".fisica.bin");
                repoJuridica.recuperar(prefixo + ".juridica.bin");
                
                System.out.println("Dados recuperados com sucesso.");
                } catch(Exception e){
                    System.out.println("Erro ao recuperar.");
                }
            } else if(option == 0){
                System.out.println("Programa Finalizado.");
            } else {
                System.out.println("Opção invalida.");
            }
        }
        scan.close();
    }
    
}
