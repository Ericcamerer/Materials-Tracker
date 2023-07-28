package com.MaterialTracker.Project.dao;

import com.MaterialTracker.Project.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransactionDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getBalanceByUserId(int id) {
        String sql = "SELECT balance FROM tenmo_user WHERE user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id);
       return rowSet.getRow();
    }

    public void createTransaction(Transaction transaction) {

        String sql=

                "INSERT INTO transactions (amount, from_id, to_id) " +
                "VALUES (?, ?, ?);" +
                "UPDATE tenmo_user " +
                "SET balance = balance - ? " +
                "WHERE user_id = ?;" +
                "UPDATE tenmo_user " +
                "SET balance = balance + ? " +
                "WHERE user_id = ?;";


        jdbcTemplate.update (sql, transaction.getAmount(), transaction.getFrom_id(), transaction.getTo_id(), transaction.getAmount(),
                transaction.getFrom_id(), transaction.getAmount(), transaction.getTo_id());

    }

    public List<Transaction> getTransactionsById(int userId) {
        List <Transaction> transactions = new ArrayList<>();
        String sql = "SELECT transaction_id, date, amount, from_id, to_id, status FROM transactions WHERE from_id = ? OR to_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId , userId);

        while (rowSet.next()) {
            Transaction newTransaction = mapRowToTransaction(rowSet);
            transactions.add(newTransaction);
        }
        return transactions;
    }

    private Transaction mapRowToTransaction(SqlRowSet rs) {
        Transaction transaction = new Transaction();
        transaction.setId(rs.getInt("transaction_id"));
        transaction.setDate(rs.getDate("date").toLocalDate());
        transaction.setAmount(rs.getInt("amount"));
        transaction.setFrom_id(rs.getInt("from_id"));
        transaction.setTo_id(rs.getInt("to_id"));
        transaction.setStatus(rs.getInt("status"));
        return transaction;
    }

    public Transaction getSpecificTransaction(int id, int userId) {

        String sql = "SELECT transaction_id, date, amount, from_id, to_id, status FROM transactions WHERE transaction_id = ? AND from_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id, userId);
        if(rowSet.next()) {

            return mapRowToTransaction(rowSet);
        }
        return null;
    }

    public void createRequestTransaction(Transaction transaction) {
        String sql=

                "INSERT INTO transactions (amount, from_id, to_id) " +
                        "VALUES (?, ?, ?); " +
                        "UPDATE transactions " +
                        "SET status = 2;";

        jdbcTemplate.update (sql, transaction.getAmount(), transaction.getFrom_id(), transaction.getTo_id());



    }

    public List<Transaction> getPendingTransactionsById(int userId, int status) {
        List <Transaction> transactions = new ArrayList<>();
        String sql = "SELECT transaction_id, date, amount, from_id, to_id, status FROM transactions WHERE to_id = ? AND status = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId , status);

        while (rowSet.next()) {
            Transaction newTransaction = mapRowToTransaction(rowSet);
            transactions.add(newTransaction);
        }
        return transactions;
    }

    public void acceptPendingTransactionsById(Transaction transaction, int id) {
      String sql = "UPDATE tenmo_user " +
        "SET balance = balance + ? " +
        "WHERE user_id = ?;" +
        "UPDATE tenmo_user " +
        "SET balance = balance - ? " +
              "WHERE user_id = ?;" +
       "UPDATE transactions "+
        "SET status = 1 " +
              "WHERE transaction_id = ?;"
              ;
        jdbcTemplate.update (sql, transaction.getAmount(), transaction.getFrom_id(), transaction.getAmount(), transaction.getTo_id(), id);

    }
}
