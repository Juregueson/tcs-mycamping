
package AcessoDados;

import java.sql.*;

public class AcessoDados {

    //driver
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    //url do banco
    private static final String URL = "jdbc:mysql://localhost:3306/dbAustra";

    private static final String USUARIO = "root";
    
    private static final String SENHA = "";
    
    //procura do driver na inicialização
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(
                    "Driver do MySQL não encontrado: " + e.getMessage());
        }
    }

    //método conector
    public static Connection conector() throws SQLException, SQLTimeoutException{
        java.sql.Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            return conexao;
        }catch(Exception excErro){
            System.out.println("Erro no banco de dados:" + excErro);
            return null;
        }
    }
    
}
    //Criar o método "connector que vai ser utilizado nas outras telas/classes
    //public static Connection connector(){
        //Criar a varíavel para testar a conexão do banco
        //java.sql.Connection conexao = null;
        //Definir e chamar/carregar o driver de java/mysql
        //String driver = "com.mysql.jdbc.Driver";
        //Definir as variáveis em string para realmente fazer a conexão
        //String url = "jdbc:mysql://127.0.0.1:3306/dblogin";
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
