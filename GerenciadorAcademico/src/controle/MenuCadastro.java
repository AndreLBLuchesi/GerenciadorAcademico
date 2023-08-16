package controle;

import util.Input;

/**
 *
 * @author Andre
 */
public class MenuCadastro {
    
    public static void exibirMenuPrincipal(){
            System.out.println("\n######## Menu principal ########");
            System.out.println("| 1 - Cadastro Aluno            |");
            System.out.println("| 2 - Cadastro Funcionario      |");
            System.out.println("| 3 - Cadastro Professor        |");
            System.out.println("| 4 - Cadastro Coordenador      |");
            System.out.println("| 5 - Cadastro Curso            |");
            System.out.println("| 0 - SAIR                      |");
            System.out.println("##################################");
    }
    
    public static void exibirMenuCadastro(String cadastro){
            System.out.println("\n######## Cadastro de "+ cadastro +" ########");
            System.out.println("| 1 - Cadastrar     |");
            System.out.println("| 2 - Pesquisar     |");
            System.out.println("| 3 - Alterar       |");
            System.out.println("| 4 - Remover       |");
            System.out.println("| 5 - Listar        |");
            System.out.println("| 0 - VOLTAR        |");
            System.out.println("################################");
    }
    
    public static int selecionarOpcaoMenuPrincipal(){
        exibirMenuPrincipal();
        System.out.println("digite uma das opções acima");
        System.out.print("opção: ");
        return Input.nextInt();
    }
    
    public static int selecionarOpcaoMenuCadastro(String cadastro){
        exibirMenuCadastro(cadastro);
        System.out.println("digite uma das opções acima");
        System.out.print("opção: ");
        return Input.nextInt();
    }
}
