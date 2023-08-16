package controle;

import modelo.Professor;
import util.Input;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Funcionario;
import modelo.Pessoa;

public class CadastroProfessor {
    
    public static void setarDados(Professor prof){
        //ControleFuncionario.setarDados(prof);
        System.out.print("Formação: ");
        prof.setFormacao(Input.nextLine());
    }
    
    public static List<Pessoa> listaDePessoaProfessores() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Professor.class).collect(Collectors.toList());
    }
    
    public static List<Funcionario> listaDeProfessores() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Professor.class).map(a -> (Professor) a).collect(Collectors.toList());
    }

}
