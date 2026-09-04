package com.ecommerce.inventoryservice.service;

import com.ecommerce.inventoryservice.dto.InventoryRequest;
import com.ecommerce.inventoryservice.entity.Inventory;
import com.ecommerce.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory createInventory(InventoryRequest request) {

        Inventory inventory = new Inventory();

        inventory.setProductId(request.getProductId());
        inventory.setQuantity(request.getQuantity());

        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventory() {

        return inventoryRepository.findAll();
    }

    public Inventory getInventoryById(Long id) {

        return inventoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found"));
    }

    public Inventory getInventoryByProductId(Long productId) {

        return inventoryRepository.findByProductId(productId)
                .orElseThrow(() ->
                        new RuntimeException("Inventory not found for product"));
    }

    public Inventory updateQuantity(Long productId, Integer quantity) {

        Inventory inventory = getInventoryByProductId(productId);

        inventory.setQuantity(quantity);

        return inventoryRepository.save(inventory);
    }

    public Inventory reduceStock(Long productId, Integer quantity) {

        Inventory inventory = getInventoryByProductId(productId);

        if (inventory.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        inventory.setQuantity(
                inventory.getQuantity() - quantity
        );

        return inventoryRepository.save(inventory);
    }

    public void deleteInventory(Long id) {

        Inventory inventory = getInventoryById(id);

        inventoryRepository.delete(inventory);
    }
}
