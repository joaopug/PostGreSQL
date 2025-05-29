import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException

fun main(){
    /**
     * Primeiro vai o nome do driver JDBC
     * Depois o nome do banco, nesse caso, POSTGRESQL
     * Depois o IP que o banco está localizado, nesse caso, na nossa máquina
     * Por último a porta que o banco está e o nome do banco. Exemplo 5432/meu-banco
     * */
    val url = "jdbc:postgresql://localhost:5432/aula"
    val user = "postgres" //POR PADRÃO A SENHA É: postgres
    val senha = "postgres" //POR PADRÃO A SENHA É: postgres

    try{
        val conexao : Connection = DriverManager.getConnection(url,user,senha)
        println("DEu bom")

        val salvar = "insert into pessoa (id, cpf, nome)" +
                "values (2,'111.111.111-11','Gustavo')"

        val query : ResultSet = conexao.createStatement().executeQuery("" +
        "SELECT * FROM pessoa")

        while (query.next()){
            val informacao = query.getString("nome")
            println(informacao)
        }

        query.close()
        conexao.close()
    }
    catch(ex : SQLException){
        ex.printStackTrace()
    }
}