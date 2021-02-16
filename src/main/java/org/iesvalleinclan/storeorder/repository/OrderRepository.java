package org.iesvalleinclan.storeorder.repository;

import org.iesvalleinclan.storeorder.model.OrderVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderVO, String> {
    OrderVO findByReference(String reference);
}