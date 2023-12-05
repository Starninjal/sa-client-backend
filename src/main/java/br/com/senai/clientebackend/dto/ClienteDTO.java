package br.com.senai.clientebackend.dto;

import br.com.senai.clientebackend.model.Cliente;

public class ClienteDTO {
    private Integer id;

    private String nomeCliente;


    private String enderecoCliente;

    private String emailCliente;

    private String cpfCliente;

    private String telefoneCliente;

    private UsuarioDto usuarioDto;

    private long idUsuario;




    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.telefoneCliente = cliente.getTelefoneCliente();
        this.emailCliente = cliente.getEmailCliente();
        this.enderecoCliente = cliente.getEnderecoCliente();
        this.cpfCliente = cliente.getCpfCliente();
        this.nomeCliente = cliente.getNomeCliente();
    }

    public ClienteDTO() {

    }

    public ClienteDTO(Integer id, String nomeCliente, String enderecoCliente, String emailCliente, String cpfCliente, String telefoneCliente, UsuarioDto usuarioDto, long idUsuario) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.emailCliente = emailCliente;
        this.cpfCliente = cpfCliente;
        this.telefoneCliente = telefoneCliente;
        this.usuarioDto = usuarioDto;
        this.idUsuario = idUsuario;
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

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
