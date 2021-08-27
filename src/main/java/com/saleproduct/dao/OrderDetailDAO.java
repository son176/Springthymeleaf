package com.saleproduct.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.saleproduct.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long>{

}
