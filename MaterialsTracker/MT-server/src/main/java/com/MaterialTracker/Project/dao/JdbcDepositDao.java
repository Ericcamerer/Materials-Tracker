package com.MaterialTracker.Project.dao;

import com.MaterialTracker.Project.model.Deposit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDepositDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDepositDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createDeposit(Deposit deposit) {

        String sql =

                "INSERT INTO deposits (material_type, wood_type, date, hardware_weight, deposit_weight, donor_name) " +
                        "VALUES (?, ?, ?, ?, ?, ?);";


        jdbcTemplate.update(sql, deposit.getMaterial_type(), deposit.getWood_type(), deposit.getDate(), deposit.getHardware_weight(),
                deposit.getDeposit_weight(), deposit.getDonor_name());

    }

    public List<Deposit> getDepositsById(int userId) {
        List<Deposit> deposits = new ArrayList<>();
        String sql = "SELECT material_type, wood_type, date, hardware_weight, deposit_weight, donor_name FROM deposits WHERE user_id = ?;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

        while (rowSet.next()) {
            Deposit newDeposit = mapRowToDeposit(rowSet);
            deposits.add(newDeposit);
        }
        return deposits;
    }

    public Deposit getSpecificDeposit(int id, int userId) {

        String sql = "SELECT material_type, wood_type, date, hardware_weight, deposit_weight, donor_name FROM transactions WHERE transaction_id = ? AND from_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, id, userId);
        if (rowSet.next()) {

            return mapRowToDeposit(rowSet);
        }
        return null;
    }

    private Deposit mapRowToDeposit(SqlRowSet rs) {
        Deposit deposit = new Deposit();
        deposit.setId(rs.getInt("transaction_id"));
        deposit.setDate(rs.getDate("date").toLocalDate());
        deposit.setDeposit_weight(rs.getInt("deposit_weight"));
        deposit.setHardware_weight(rs.getInt("hardware_weight"));
        deposit.setDonor_name(rs.getString("donor_name"));
        deposit.setWood_type(rs.getString("wood_type"));
        return deposit;
    }


}
