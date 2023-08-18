package controle;

import java.util.List;
import java.util.stream.Collectors;
import modelo.FuncionarioTerceirizado;
import modelo.Pessoa;
import util.Input;


public class CadastroFuncionarioTercerizado {
    
    public static void setarDados(FuncionarioTerceirizado func){
        System.out.println("Informe a Empresa tercerizada: ");
        func.setEmpresaTercerizada(Input.nextLine());
    }
    
    public static List<Pessoa> listaDePessoaFuncionariosTercerizados(){
        return CadastroPessoa.getListaPessoas().stream()
                .filter(x -> x.getClass() == FuncionarioTerceirizado.class)
                .collect(Collectors.toList());
    }
    
    public static List<FuncionarioTerceirizado> listaDeFuncionariosTercerizados(){
        return CadastroPessoa.getListaPessoas().stream()
                .filter(x -> x.getClass() == FuncionarioTerceirizado.class)
                .map(e -> (FuncionarioTerceirizado) e)
                .collect(Collectors.toList());
    }
}

