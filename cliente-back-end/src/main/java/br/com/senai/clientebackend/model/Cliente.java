package br.com.senai.clientebackend.model;

import br.com.senai.clientebackend.dto.ClienteDTO;
import jakarta.persistence.*;

@Entity(name = "Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCliente;

    private long idUsuario;


    private String cpfCliente;

    private String telefoneCliente;

    private String enderecoCliente;

    private String emailCliente;

    public Cliente() {

    }

    public Cliente(ClienteDTO clienteDTO) {
        this.cpfCliente = clienteDTO.getCpfCliente();
        this.emailCliente = clienteDTO.getEmailCliente();
        this.enderecoCliente = clienteDTO.getEnderecoCliente();
        this.telefoneCliente = clienteDTO.getTelefoneCliente();
        this.id = clienteDTO.getId();
        this.nomeCliente = clienteDTO.getNomeCliente();
    }

    public Cliente(Integer id, String nomeCliente, String cpfCliente, String telefoneCliente, String enderecoCliente, String emailCliente) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
        this.emailCliente = emailCliente;
    }

    public Cliente(String nomeCliente, String cpfCliente, String telefoneCliente, String enderecoCliente, String emailCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
        this.emailCliente = emailCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
