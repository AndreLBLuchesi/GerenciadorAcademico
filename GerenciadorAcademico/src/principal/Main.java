package principal;

import controle.CadastroCurso;
import controle.MenuCadastro;
import controle.CadastroPessoa;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import modelo.Aluno;
import modelo.Coordenador;
import modelo.Curso;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Professor;
import util.DialogBoxUtils;

/**
 *
 * @author Andre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.getRootFrame();
        gerarCadastrosDeTeste();
        int op;
        do {
            op = MenuCadastro.selecionarOpcaoMenuPrincipal();
            switch (op) {
                case 1 ->
                    CadastroPessoa.menuControlePessoa("Aluno");
                case 2 ->
                    CadastroPessoa.menuControlePessoa("Funcionario");
                case 3 ->
                    CadastroPessoa.menuControlePessoa("Professor");
                case 4 ->
                    CadastroPessoa.menuControlePessoa("Coordenador");
                case 5 ->
                    CadastroCurso.menuControleCurso();
                case 0 -> {
                    System.out.println("Saindo do sistema...");
                }
                default -> DialogBoxUtils.exibirMensagemDeErro("Opção inválida!", "Erro! Opção inválida!");
            }
        } while (op != 0);
    }
    
    
    private static void gerarCadastrosDeTeste(){
        Coordenador coord1 = new Coordenador("Bacharel em Ciência da Computação", "123", 2500, "Rudimar", "1111111", LocalDate.of(1980, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "10"));
        Curso curso1 = new Curso("TADS", 2500, 6, coord1);
        CadastroPessoa.getListaPessoas().add(coord1);
        CadastroCurso.getListaCursos().add(curso1);
        
        Coordenador coord2 = new Coordenador("Bacharel em Ciências Contábeis", "12334", 2500, "Edson", "22222222", LocalDate.of(1981, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "20"));
        Curso curso2 = new Curso("Contabilidade", 2500, 6, coord2);
        CadastroPessoa.getListaPessoas().add(coord2);
        CadastroCurso.getListaCursos().add(curso2);
        
        Coordenador coord3 = new Coordenador("Odontologia", "12334", 2500, "Larissa", "33333333", LocalDate.of(1982, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "30"));
        Curso curso3 = new Curso("Odontologia", 2500, 8, coord3);
        CadastroPessoa.getListaPessoas().add(coord3);
        CadastroCurso.getListaCursos().add(curso3);
        
        Aluno alu1 = new Aluno("Pedro", "44444444", LocalDate.of(1992, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "40"), "2222", curso1, LocalDate.now(), "Em Andamento");
        Aluno alu2 = new Aluno("Ana", "5555555", LocalDate.of(1993, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "50"), "2223", curso1, LocalDate.now(), "Em Andamento");
        
        Aluno alu3 = new Aluno("Carlos", "6666666", LocalDate.of(1994, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "60"), "3322", curso2, LocalDate.now(), "Em Andamento");
        Aluno alu4 = new Aluno("Vanessa", "7777777", LocalDate.of(1995, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "70"), "3323", curso2, LocalDate.now(), "Em Andamento");
        
        Aluno alu5 = new Aluno("Mario", "8888888", LocalDate.of(1996, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "80"), "4422", curso3, LocalDate.now(), "Em Andamento");
        Aluno alu6 = new Aluno("Julia", "9999999", LocalDate.of(1997, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "90"), "4423", curso3, LocalDate.now(), "Em Andamento");
        
        CadastroPessoa.getListaPessoas().add(alu1);
        CadastroPessoa.getListaPessoas().add(alu2);
        CadastroPessoa.getListaPessoas().add(alu3);
        CadastroPessoa.getListaPessoas().add(alu4);
        CadastroPessoa.getListaPessoas().add(alu5);
        CadastroPessoa.getListaPessoas().add(alu6);
        
        Professor prof1 = new Professor("Bacharel em Ciência da Computação", "123675884", 1500, "André", "10101010101", LocalDate.of(1990, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "100"));
        Professor prof2 = new Professor("Bacharel em Ciências Contábeis", "19588695", 1500, "Joares", "12211212121212", LocalDate.of(1981, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "110"));
        Professor prof3 = new Professor("Odontologia", "17364375", 1500, "Angela", "13313131313131", LocalDate.of(1982, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "120"));
        
        CadastroPessoa.getListaPessoas().add(prof1);
        CadastroPessoa.getListaPessoas().add(prof2);
        CadastroPessoa.getListaPessoas().add(prof3);
        
        Funcionario func1 = new Funcionario("192223456", 1200, "Joaquim", "1155525352532", LocalDate.of(1983, 1, 1), new Endereco("Cascavel", "Av. Tito Muffato", "150"));
        CadastroPessoa.getListaPessoas().add(func1);
    }
    
}
