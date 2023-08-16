package controle;

import modelo.Aluno;
import modelo.Curso;
import util.Input;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import modelo.Pessoa;

import util.DialogBoxUtils;

public class CadastroAluno {

    public static void setarDados(Aluno aluno) {
        //ControlePessoa.setarDados(aluno);
        System.out.print("RA: ");
        aluno.setRa(Input.nextLine());
        aluno.setDataMatricula(LocalDate.now());

        int op = DialogBoxUtils.exibirCaixaConfirmacao("Adicionar curso", "Deseja adicionar o curso? ");
        if (op == 0) {
            Curso cursoPesquisa;
            do {
                cursoPesquisa = CadastroCurso.pesquisa();

                if (cursoPesquisa == null) {
                    if (DialogBoxUtils.exibirCaixaConfirmacao("Curso não encontrado!", "Curso não encontrado! \nDeseja pesquisar novamente?") == 1) {
                        break;
                    }
                } else {
                    aluno.setCurso(cursoPesquisa);
                    System.out.print("Situação: ");
                    aluno.setSituacao(escolhaSituacao());
                }
            } while (cursoPesquisa == null);
        }
    }

    protected static String escolhaSituacao() {
        do {
            System.out.println("\n1 - Em andamento\n2 - Concluido\n3 - Trancada\n4 - Desistente");
            System.out.print("R: ");
            int op = Input.nextInt();
            switch (op) {
                case 1 -> {
                    return "Em andamento";
                }
                case 2 -> {
                    return "Concluido";
                }
                case 3 -> {
                    return "Trancada";
                }
                case 4 -> {
                    return "Desistente";
                }
                default -> {
                    System.out.println("\nValor inválido !!\n");
                }
            }
        } while (true);
    }

    public static List<Pessoa> listaDePessoaAlunos() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Aluno.class).collect(Collectors.toList());
    }
    
    public static List<Aluno> listaDeAlunos() {
        return CadastroPessoa.listaPessoas.stream().filter(e -> e.getClass() == Aluno.class).map(a -> (Aluno) a).collect(Collectors.toList());
    }

    public static int qtdAlunosCurso(Curso curso) {
        int contAlunos = 0;

        for (Aluno listaAluno : listaDeAlunos()) {
            if (listaAluno.getSituacao().equals("Em andamento") && curso.equals(listaAluno.getCurso())) {
                contAlunos++;
            }
        }
        return contAlunos;
    }
}
