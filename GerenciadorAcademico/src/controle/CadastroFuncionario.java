package controle;

import java.util.List;
import java.util.stream.Collectors;
import modelo.Funcionario;
import modelo.Pessoa;
import util.Input;

public class CadastroFuncionario {

    public static void setarDados(Funcionario fun) {
        //ControlePessoa.setarDados(fun);
        System.out.print("CTPS: ");
        fun.setCtps(Input.nextLine());
        System.out.print("Salário: ");
        fun.setSalario(Input.nextDouble());
    }

    public static List<Pessoa> listaDePessoaFuncionarios() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Funcionario.class).collect(Collectors.toList());
    }
    
    public static List<Funcionario> listaDeFuncionarios() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Funcionario.class).map(a -> (Funcionario) a).collect(Collectors.toList());
    }

}
