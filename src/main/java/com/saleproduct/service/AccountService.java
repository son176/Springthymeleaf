package com.saleproduct.service;

import java.util.List;

import com.saleproduct.entity.Account;

public interface AccountService {
 Account findByid(String username);

List<Account> getAdministrators();

List<Account> findAll();

Account create(Account account);

Account update(Account account);

void delete(String username);

}
