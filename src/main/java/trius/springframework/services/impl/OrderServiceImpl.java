package trius.springframework.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trius.springframework.domain.Order;
import trius.springframework.repositories.OrderRepository;
import trius.springframework.security.UserAccount;
import trius.springframework.services.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderByUser(UserAccount userAccount) {
        return orderRepository.findByUserAccount(userAccount);
    }

    @Override
    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

}
