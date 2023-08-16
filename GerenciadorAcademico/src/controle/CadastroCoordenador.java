package controle;

import modelo.Coordenador;
import util.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Curso;
import modelo.Funcionario;
import modelo.Pessoa;
import util.DialogBoxUtils;

public class CadastroCoordenador {
    
    public static void setarDados(Coordenador coord){
        CadastroProfessor.setarDados(coord);
        Curso curso = CadastroCurso.pesquisa();
        if(curso == null){
            DialogBoxUtils.exibirMensagem("Curso não encontrado", "Nenhum curso foi encontrado!");
            return;
        }
        
        curso.setCoordenador(coord);
    }
    
    public static List<Pessoa> listaDePessoasCoordenadores() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Coordenador.class).map(a -> (Coordenador) a).collect(Collectors.toList());
    }
    
    public static List<Coordenador> listaDeCoordenadores() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Coordenador.class).map(a -> (Coordenador) a).collect(Collectors.toList());
    }
    
//    public static void listar() {
//        listar(listaDeAlunos());
//    }
//
//    public static void listar(List<Aluno> listaAlunos) {
//        if (listaAlunos.isEmpty()) {
//            System.out.println("Lista vazia!");
//        }
//        System.out.println("\n--------Lista de Alunos---------");
//        for (Aluno p : listaAlunos) {
//            p.exibirInformacoes();
//        }
//    }
}
