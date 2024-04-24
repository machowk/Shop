package com.example.Shop.controller;


import com.example.Shop.model.order.Order;
import com.example.Shop.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Shop.model.Item;
import com.example.Shop.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ItemRepository itemRepository;



    @Autowired
    public AdminController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Endpoint do wyświetlania listy przedmiotów
    @GetMapping("/items")
    public String showItems(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "adminView/showItems"; // Twój widok do wyświetlania listy przedmiotów
    }

    // Endpoint do wyświetlania formularza dodawania przedmiotu
    @GetMapping("/items/add")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "adminView/addItem"; // Twój widok formularza dodawania przedmiotu
    }

    // Endpoint do dodawania przedmiotu
    @PostMapping("/items/add")
    public String addItem(@ModelAttribute Item item) {
        itemRepository.save(item);
        return "redirect:/admin/items"; // Przekierowanie do widoku z listą przedmiotów po dodaniu
    }
    // Endpoint do edycji przedmiotu
    @GetMapping("/items/{id}/edit")
    public String editItemForm(@PathVariable Long id, Model model) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        optionalItem.ifPresent(item -> model.addAttribute("item", item));
        return "adminView/editItem"; // Twój widok do edycji przedmiotu
    }

    @PostMapping("/items/{id}/edit")
    public String editItem(@PathVariable Long id, @ModelAttribute Item item) {
        item.setId(id); // Ustawienie ID przedmiotu, które chcemy edytować
        itemRepository.save(item);
        return "redirect:/admin/items"; // Przekierowanie do widoku z listą przedmiotów
    }

    // Endpoint do usuwania przedmiotu
    @PostMapping("/items/{id}/delete")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "redirect:/admin/items"; // Przekierowanie do widoku z listą przedmiotów
    }

}