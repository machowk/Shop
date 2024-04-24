package com.example.Shop.controller;


import com.example.Shop.Cart;

import com.example.Shop.ItemOperation;
import com.example.Shop.model.Item;
import com.example.Shop.repository.ItemRepository;
import com.example.Shop.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class Controler {



    private final CartService cartService;

    @Autowired
    public Controler(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/home")
    public String home(@RequestParam(name = "query", required = false) String query, Model model) {
        model.addAttribute("items", cartService.getAllItems(query != null && !query.isEmpty() ? query : null));
        return "home";
    }


    /*   stare dziłające

    public String home(Model model, HttpSession httpSession) {
        model.addAttribute("items", cartService.getAllItems());
        return "home";
    } */


    /* Wraca nas do strony głownej z sakcji add */

    @GetMapping("/add/strona")
    public String showHome2(){
        return "redirect:/strona";
    }

    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") Long itemId, @RequestParam(name = "query", required = false) String query, Model model) {
        cartService.itemOperation(itemId, ItemOperation.INCREASE, query);
        model.addAttribute("items", cartService.getAllItems(query));
        return "home";
    }





    @GetMapping("/start")
    public String start() {
        return "start";
    }

    @RequestMapping("/strona")
    public String strona() { return "strona"; }

    @RequestMapping("/cartView")
    public String cartView() { return "cartView"; }
/*
    @RequestMapping("/sniadania")
    public String sniadania(Model model, HttpSession httpSession) {
        model.addAttribute("items", cartService.getAllItems());
    return "sniadania"; }

    @RequestMapping("/obiad")
    public String obiad() { return "obiad"; }

    @RequestMapping("/kolacja")
    public String kolacja() { return "kolacja"; }

    @RequestMapping("/sPrzepis1")
        public String sPrzepis1(Model model, HttpSession httpSession) {
        model.addAttribute("items", cartService.getAllItems());
        return "/sPrzepisy/sPrzepis1";
    }

 */

    @GetMapping("/summary2")
        public String summary2() { return "/summary2" ;}


}


