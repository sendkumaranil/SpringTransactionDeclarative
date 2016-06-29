package com.swadesibank.transaction.daoImpl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.swadesibank.transaction.bean.Account;
import com.swadesibank.transaction.dao.IAccountDao;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	@Override
	public void insert(Account account) {
		String sql="insert into swadesiaccount(accountno,balance)values(?,?)";
		getJdbcTemplate().update(sql, new Object[]{account.getAccountno(),account.getBalance()});
	}

	@Override
	public void update(Account account) {
		String sql="update swadesiaccount set balance=? where accountno=?";
		getJdbcTemplate().update(sql, new Object[]{account.getBalance(),account.getAccountno()});

	}

	@Override
	public Account getAccount(Integer accountno) {
		String sql="select * from swadesiaccount where accountno=?";
		Account account=getJdbcTemplate().queryForObject(sql,new Object[]{accountno} ,new AccountRowMapper());
		return account;
	}

}
