package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.repository.IDeliveryRepository;
import za.ac.cput.service.IDeliveryService;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    private final IDeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(IDeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }


    @Override
    public Delivery create(Delivery delivery) {
        return this.deliveryRepository.save(delivery);
    }

    @Override
    public Delivery read(String deliveryId) {
        return this.deliveryRepository.findById(deliveryId).orElse(null);
    }

    @Override
    public Delivery update(Delivery delivery) {
        if (this.deliveryRepository.existsById(delivery.getDeliveryId())) {
            return this.deliveryRepository.save(delivery);

        }
        return null;
    }

    @Override
    public boolean delete(String deliveryId) {
        if (this.deliveryRepository.existsById(deliveryId)) {
            this.deliveryRepository.deleteById(deliveryId);
            return true;
        }
        return false;
    }

    @Override
    public List<Delivery> getAll() {
        return this.deliveryRepository.findAll();
    }

}
