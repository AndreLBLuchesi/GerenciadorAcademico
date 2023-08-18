package modelo;

import java.time.LocalDate;

public class FuncionarioTerceirizado extends Funcionario{
    private String EmpresaTercerizada;

    public FuncionarioTerceirizado() {
    }

    public FuncionarioTerceirizado(String EmpresaTercerizada, String ctps, double salario, String nome, String cpf, LocalDate dataNascimento, Endereco endereco) {
        super(ctps, salario, nome, cpf, dataNascimento, endereco);
        this.EmpresaTercerizada = EmpresaTercerizada;
    }

    public String getEmpresaTercerizada() {
        return EmpresaTercerizada;
    }

    public void setEmpresaTercerizada(String EmpresaTercerizada) {
        this.EmpresaTercerizada = EmpresaTercerizada;
    }
    
    
}
