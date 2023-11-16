package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import projeto.Cliente;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO Cliente (nome, idade, email) VALUES (?, ?, ?)";
            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                pstm.setLong(1, cliente.getIdade());
                pstm.setInt(2, cliente.getIdade());
                pstm.setString(3, cliente.getEmail());

                pstm.executeUpdate();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Cliente obterClientePorId(int clienteId) {
        Cliente cliente = null;
        try {
            String sql = "SELECT * FROM Cliente WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, clienteId);  
                    }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
}
