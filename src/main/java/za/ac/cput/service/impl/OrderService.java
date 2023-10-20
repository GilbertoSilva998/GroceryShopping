package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.IOrderRepository;
import za.ac.cput.service.IOrderService;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    @Autowired
    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Orders create(Orders orders) {
        return this.orderRepository.save(orders);
    }

    @Override
    public Orders read(String OrderId) {
        return this.orderRepository.findById(OrderId).orElse(null);
    }

    @Override
    public Orders update(Orders orders) {
        if (this.orderRepository.existsById(orders.getOrderId())) {
            this.orderRepository.save(orders);
        }
        return null;
    }

    @Override
    public boolean delete(String orderId) {
        if (this.orderRepository.existsById(orderId)) {
            this.orderRepository.deleteById(orderId);
        }
        return false;
    }

    @Override
    public List<Orders> getAll() {
        return this.orderRepository.findAll();
    }

}
