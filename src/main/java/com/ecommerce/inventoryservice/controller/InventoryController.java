package com.ecommerce.inventoryservice.controller;

import com.ecommerce.inventoryservice.dto.InventoryRequest;
import com.ecommerce.inventoryservice.entity.Inventory;
import com.ecommerce.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public Inventory createInventory(
            @RequestBody InventoryRequest request) {

        return inventoryService.createInventory(request);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {

        return inventoryService.getAllInventory();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(
            @PathVariable Long id) {

        return inventoryService.getInventoryById(id);
    }

    @GetMapping("/product/{productId}")
    public Inventory getInventoryByProductId(
            @PathVariable Long productId) {

        return inventoryService.getInventoryByProductId(productId);
    }

    @PatchMapping("/product/{productId}")
    public Inventory updateQuantity(
            @PathVariable Long productId,
            @RequestParam Integer quantity) {

        return inventoryService.updateQuantity(
                productId,
                quantity
        );
    }

    @PatchMapping("/product/{productId}/reduce")
    public Inventory reduceStock(
            @PathVariable Long productId,
            @RequestParam Integer quantity) {

        return inventoryService.reduceStock(
                productId,
                quantity
        );
    }

    @DeleteMapping("/{id}")
    public String deleteInventory(
            @PathVariable Long id) {

        inventoryService.deleteInventory(id);

        return "Inventory deleted successfully";
    }
}
