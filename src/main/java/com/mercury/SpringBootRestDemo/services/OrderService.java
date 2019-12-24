package com.mercury.SpringBootRestDemo.services;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mercury.SpringBootRestDemo.beans.Order;
import com.mercury.SpringBootRestDemo.beans.OrderProduct;
import com.mercury.SpringBootRestDemo.beans.Product;
import com.mercury.SpringBootRestDemo.daos.OrderDao;
import com.mercury.SpringBootRestDemo.daos.OrderProductDao;
import com.mercury.SpringBootRestDemo.daos.ProductDao;
import com.mercury.SpringBootRestDemo.http.Response;
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    
    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private OrderProductDao orderProductDao;
    
    public List<Order> getAll(){
        return orderDao.findAll();
    }
    
    public Order getOrderById(Integer id) {
        return orderDao.findById(id).get();
    }
    
    //Spring Transaction will rollback only if the functiion is exception out
    //try-catch will handle the exception and make it success, no exception
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    //Propagation.Required: create a new transaction if no existing transaction. If transaction exist, then use it, no creation.
    //Propagataion.REQUIRES_NEW: always create a new transaction
    //Propagation.MANDATORY: Everytime call, must have an existed transaction
    //Progation.NEVER: Can't call from a transaction
    public Response save(Order order) {
        try {
            List<OrderProduct> purchases = order.getPurchases();
            purchases.forEach((orderProduct) -> {
                // enrich the product object
                Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
                orderProduct.setProduct(product);
                
                orderProduct.setOrder(order);
            });
            orderDao.save(order);
            
            return new Response(true);
        } catch (Exception e) {
            return new Response(false);
        }
    }
    
    public Response edit(Order order) {
        try {
            Order o = (Order) orderDao.findById(order.getId()).get();
            List<OrderProduct> purchasesToRemove = o.getPurchases();
            
            List<OrderProduct> purchases = order.getPurchases();
            // handled update and add products in order
            purchases.forEach((orderProduct) -> {
                Product product = (Product) productDao.findById(orderProduct.getProduct().getId()).get();
                orderProduct.setProduct(product);
                orderProduct.setOrder(o);
            });
            
            // handle remove products in order
            if(purchases.size() > 0) {
                purchasesToRemove = purchasesToRemove.stream().filter((orderProduct) -> {
                    return !purchases.contains(orderProduct);
                }).collect(Collectors.toList());
            }
            
            o.setPurchases(purchases);
            orderDao.save(o);
            
            deleteOrderProducts(purchasesToRemove); 
                        
            return new Response(true);
        } catch (Exception e) {
            System.out.println(e);
            return new Response(false);
        }
    }    
    public void deleteOrderProducts(List<OrderProduct> purchases) {
        orderProductDao.deleteAll(purchases);   
    }
}




