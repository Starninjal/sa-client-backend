package br.com.senai.clientebackend.dto;

public class UsuarioDto {
    private long id;

    private String username;

    private String password;

    private String tipoUsuario;

    public UsuarioDto() {

    }

    public UsuarioDto(long id, String username, String password, String tipoUsuario) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioDto(String username, String password, String tipoUsuario) {
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
