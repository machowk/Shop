package com.example.Shop.service;

import com.example.Shop.Cart;
import com.example.Shop.ItemOperation;
import com.example.Shop.model.Item;
import com.example.Shop.repository.ItemRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final ItemRepository itemRepository;


    private final Cart cart;

    @Autowired
    public CartService(ItemRepository itemRepository, Cart cart) {
        this.itemRepository = itemRepository;
        this.cart = cart;
    }

    public List<Item> getAllItems(String query) {
        if (query != null && !query.isEmpty()) {
            // Jeśli przekazano frazę wyszukiwania, wykonaj wyszukiwanie
            return searchItems(query);
        } else {
            // W przeciwnym razie zwróć wszystkie przedmioty
            return itemRepository.findAll();
        }
    }

    public List<Item> searchItems(String query) {
        return itemRepository.findByNameContainingIgnoreCase(query);
    }


/* dodanie metody query do cartserivce zeby wyszukiwanie przedmioty były dodane do koszyka*/

    @SneakyThrows
    public void itemOperation(Long itemId, ItemOperation itemOperation, String query) {
        Optional<Item> oItem = itemRepository.findById(itemId);
        if(oItem.isPresent()) {
            Item item = oItem.get();
            switch  (itemOperation) {
                case INCREASE -> cart.addItem(item);
                case DECREASE -> cart.decreaseItem(item);
                case REMOVE -> cart.removeAllItems(item);
                default -> throw new IllegalAccessException();

            }
        }

    }


}
