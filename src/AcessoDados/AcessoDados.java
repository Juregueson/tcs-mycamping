
package AcessoDados;

import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoDados {

    //enumeração dos perfis
    public enum enumPerfis { USUARIO, ADMIN }

    //definição do driver
    private static final String driver = "com.mysql.jdbc.Driver";

    //definição da url do banco
    private static final String url =
            "jdbc:mysql://localhost:3306/meu_banco";

    // Credenciais do usuário comum
    private static final String nomeUsuario = "strNomeUsuario";
    private static final String senhaUsuario = "strSenhaUsuario";

    // Credenciais do administrador
    private static final String nomeAdmin = "strNomeAdmin";
    private static final String senhaAdmin = "strSenhaAdmin";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(
                    "Driver JDBC do MySQL não encontrado: " + e.getMessage());
        }
    }

    /** Método conector: retorna uma conexão de acordo com o perfil. */
    public static Connection conectar(Perfil perfil) throws SQLException {
        switch (perfil) {
            case ADMIN:
                return DriverManager.getConnection(URL, ADMIN_LOGIN, ADMIN_SENHA);
            case USUARIO:
            default:
                return DriverManager.getConnection(URL, USUARIO_LOGIN, USUARIO_SENHA);
        }
    }

    /** Atalhos para facilitar o uso. */
    public static Connection conectarUsuario() throws SQLException {
        return conectar(Perfil.USUARIO);
    }

    public static Connection conectarAdmin() throws SQLException {
        return conectar(Perfil.ADMIN);
    }
}


//public class AcessoDados {
    //Criar o método "connector que vai ser utilizado nas outras telas/classes
    //public static Connection connector(){
        //Criar a varíavel para testar a conexão do banco
        //java.sql.Connection conexao = null;
        //Definir e chamar/carregar o driver de java/mysql
        //String driver = "com.mysql.jdbc.Driver";
        //Definir as variáveis em string para realmente fazer a conexão
        //String url = "jdbc:mysql://127.0.0.1:3306/dbaustra";
        //String user = "root";
        //String password = "";
        //Agora, tentar estabelecer a conexão ao banco com try catch
        //try{
            //colocando o driver na conexão
            //Class.forName(driver);
            //executando a conexão
            //conexao = DriverManager.getConnection(url, user, password);
            //Retornar o resultado da conexão
            //return conexao;
        //}catch(Exception varERRO) {
            //Verificando o erro
            //System.out.println("Erro na conexão do banco:"+ varERRO.toString());
            //return null;
        //}
    //}
//}
