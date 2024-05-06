package br.com.cajazeiras.reservaveiculos.Model;
import br.com.cajazeiras.reservaveiculos.Interface.IFuncionario;
import java.util.Scanner;

public class Funcionario implements IFuncionario{
    Scanner scanner = new Scanner(System.in);
    Funcionario[] vetorLogin = new Funcionario[0];
    String login;
    String senha;

    public Funcionario(){}

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void cadastrarLogin(){
        Funcionario[] novoVetorLogins = new Funcionario[vetorLogin.length + 1];

        for (int i = 0; i < vetorLogin.length; i++){
            novoVetorLogins[i] = vetorLogin[i];
        }
        System.out.print("Usuário: ");
        login = scanner.nextLine();
        System.out.print("Senha: ");
        senha = scanner.nextLine();

        Funcionario novoLogin = new Funcionario(login, senha);

        novoVetorLogins[vetorLogin.length] = novoLogin;

        vetorLogin = novoVetorLogins;
    }

    @Override
    public boolean autenticacao() {
        System.out.print("Usuário: ");
        String loginEsperado = scanner.nextLine();
        System.out.print("Senha: ");
        String senhaEsperada = scanner.nextLine();

        if(this.login == null || this.senha == null || !this.senha.equals(senhaEsperada) || !this.login.equals(loginEsperado)){
            System.out.println("Login não encontrado.\n");
        }
        else if (login.equals(loginEsperado) && senha.equals(senhaEsperada)){
            return true;
        }
        return false;
    }





}