package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Aluno;
import modelo.Coordenador;
import modelo.Funcionario;
import modelo.Pessoa;
import modelo.Professor;
import util.DialogBoxUtils;
import util.Input;

public class CadastroPessoa {

    protected static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public static void menuControlePessoa(String entidadeModelo) {
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuCadastro(entidadeModelo);
            switch (op) {
                case 1 -> {
                    switch (entidadeModelo) {
                        case "Aluno" -> cadastrarAluno();
                        case "Funcionario" -> cadastrarFuncionario();
                        case "Professor" -> cadastrarProfessor();
                        case "Coordenador" ->cadastrarCoordenador();
                        default -> new AssertionError();
                    }
                }
                case 2 ->
                    buscar(obterListaTipoPessoa(entidadeModelo));
                case 3 ->
                    alterar();
                case 4 ->
                    remover();
                case 5 ->
                    listar(entidadeModelo, true);
                case 0 ->
                    System.out.println("\nRetornando ao menu principal...");
                default ->
                    DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }

    public static void cadastrarAluno() {
        cadastrar(new Aluno());
    }

    public static void cadastrarFuncionario() {
        cadastrar(new Funcionario());
    }

    public static void cadastrarProfessor() {
        cadastrar(new Professor());
    }

    public static void cadastrarCoordenador() {
        cadastrar(new Coordenador());
    }

    public static void cadastrar(Pessoa p) {
        try {
            //Pessoa p = new Pessoa();
            setarDados(p);
            listaPessoas.add(p);
            DialogBoxUtils.exibirMensagem("Cadastro realizado", "O cadastro realizado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao cadastrar dados!\n" + e.getMessage());
        }
    }

    public static void alterar() {
        Pessoa pessoa = pesquisa();
        if (pessoa == null) {
            DialogBoxUtils.exibirMensagem("Pessoa não encontrada", "Nenhuma pessoa foi encontrada!");
            return;
        }
        try {
            setarDados(pessoa);
            DialogBoxUtils.exibirMensagem("Cadastro alterado", "O cadastro alterado com sucesso!");
        } catch (Exception e) {
            DialogBoxUtils.exibirMensagemDeErro("Falha no cadastro", "Erro! falha ao alterar cadastro!\n" + e.getMessage());
        }
    }

    protected static void setarDados(Pessoa pessoa) {
        System.out.print("Nome: ");
        pessoa.setNome(Input.nextLine());
        System.out.print("CPF: ");
        pessoa.setCpf(Input.nextLine());
        System.out.print("Data de nascimento: ");
        pessoa.setDataNascimento(Input.nextLocalDate());
        CadastroEndereco.setarDadosEndereco(pessoa.getEndereco());

        if (pessoa instanceof Aluno) {
            CadastroAluno.setarDados((Aluno) pessoa);
        } else if (pessoa instanceof Funcionario) {
            CadastroFuncionario.setarDados((Funcionario) pessoa);
        } else if (pessoa instanceof Professor) {
            CadastroProfessor.setarDados((Professor) pessoa);
        } else if (pessoa instanceof Coordenador) {
            CadastroCoordenador.setarDados((Coordenador) pessoa);
        }
    }

    public static Pessoa pesquisa() {
        System.out.println("Informe o Cpf: ");
        String dadoBusca = Input.nextLine();
        return pesquisa(listaPessoas, dadoBusca.toLowerCase());
    }

    public static Pessoa pesquisa(ArrayList<Pessoa> listaPessoas, String dadoBusca) {
        for (Pessoa listaPessoa : listaPessoas) {
            if (listaPessoa.getNome().toLowerCase().equals(dadoBusca) || listaPessoa.getCpf().equals(dadoBusca)) {
                return listaPessoa;
            }
        }
        return null;
    }

    public static void buscar(List<Pessoa> pessoas) {
        List<Pessoa> resultado = pesquisaContains(pessoas);

        if (resultado.isEmpty()) {
            DialogBoxUtils.exibirMensagem("Pessoa não encotrada", "Nenhuma pessoa foi encontrada!");
        } else {
            listar(resultado, "Pessoas");
        }
    }

    public static List<Pessoa> pesquisaContains(List<Pessoa> pessoas) {
        System.out.println("Informe o nome ou cpf: ");
        String dadoBusca = Input.nextLine();
        return pesquisaContains(pessoas, dadoBusca.toLowerCase());
    }

    protected static ArrayList<Pessoa> pesquisaContains(List<Pessoa> listaPessoas, String dadoBusca) {
        ArrayList<Pessoa> resultado = new ArrayList<>();
        for (Pessoa listaPessoa : listaPessoas) {
            if (listaPessoa.getNome().toLowerCase().contains(dadoBusca) || listaPessoa.getCpf().contains(dadoBusca)) {
                resultado.add(listaPessoa);
            }
        }
        return resultado;
    }

    public static void remover() {
        Pessoa pessoa = pesquisa();
        if (pessoa == null) {
            DialogBoxUtils.exibirMensagem("Pessoa não encontrada", "Nenhuma pessoa foi encontrada!");
        } else if (listaPessoas.remove(pessoa)) {
            DialogBoxUtils.exibirMensagem("Pessoa removida", "Pessoa removida com sucesso !");
        }
    }

    public static void listar() {
        int resp = menuListar();
        switch (resp) {
            case 1 ->
                ordenarLista(listaPessoas, true);
            case 2 ->
                ordenarLista(listaPessoas, false);
            default ->
                System.out.println("\nEscolha Inválida !!\n");
        }
        listar(listaPessoas, "Pessoas");
    }

    public static int menuListar() {
        System.out.println("Informe a forma de ordenação");
        System.out.println("\n1 - Crescente \n2 - Decrescente");
        System.out.print("opção: ");
        return Input.nextInt();
    }

    public static void ordenarLista(ArrayList<Pessoa> lista, int ordem) {
        switch (ordem) {
            case 1 ->
                ordenarLista(listaPessoas, true);
            case 2 ->
                ordenarLista(listaPessoas, false);
            default ->
                System.out.println("\nEscolha Inválida !!\n");
        }
    }
    
    public static void ordenarLista(ArrayList<Pessoa> lista, boolean ordemCrescente) {
        if (ordemCrescente) {
            Collections.sort(lista);
        } else {
            Collections.sort(lista, Collections.reverseOrder());
        }
    }

    public static void listar(String entidadeModelo, boolean exibirMenuOrdenacao) {
        if(exibirMenuOrdenacao){
            int resp = menuListar();
            ordenarLista(listaPessoas, resp);
        }
        listar(obterListaTipoPessoa(entidadeModelo), entidadeModelo);
    }

    public static void listar(List<Pessoa> listaPessoas, String entidadeModelo) {
        if (listaPessoas.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }
        System.out.println("\n--------Lista de "+ entidadeModelo+"---------");
        for (Pessoa p : listaPessoas) {
            p.exibirInformacoes();
        }
        System.out.println("Total de registros: "+listaPessoas.size()+"\n");
    }
    
    public static List<Pessoa> obterListaTipoPessoa(String entidadeModelo) {
        switch (entidadeModelo) {
            case "Aluno" ->{ return CadastroAluno.listaDePessoaAlunos(); }
            case "Funcionario" ->{ return CadastroFuncionario.listaDePessoaFuncionarios(); }
            case "Professor" ->{ return CadastroProfessor.listaDePessoaProfessores(); }
            case "Coordenador" ->{ return CadastroCoordenador.listaDePessoasCoordenadores(); }
            case "Pessoa" ->{ return listaPessoas; }
            default -> throw new AssertionError();
        }
    }

}
