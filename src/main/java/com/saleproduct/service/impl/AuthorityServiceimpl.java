package com.saleproduct.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saleproduct.dao.AuthorityDAO;
import com.saleproduct.entity.Account;
import com.saleproduct.entity.Authority;
import com.saleproduct.service.AccountService;
import com.saleproduct.service.AuthorityService;
@Service
public class AuthorityServiceimpl implements AuthorityService {
	@Autowired
	AuthorityDAO adao;
	@Autowired
	AccountService acdao;
	@Override
	public List<Authority> findAuthoritiesOfAdministrators() {
		List<Account> account=acdao.getAdministrators();
		return adao.authoritiesOf(account);
	}

	@Override
	public List<Authority> findAll() {
		
		return adao.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		
		return adao.save(auth);
	}

	@Override
	public void delete(Integer id) {
		adao.deleteById(id);
		
	}

}
