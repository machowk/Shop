package com.example.Shop.controller;


import com.example.Shop.ItemOperation;
import com.example.Shop.service.CartService;
import com.example.Shop.service.OrderService;
import com.example.Shop.transferObject.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final CartService cartService;
    private final OrderService orderService;

    @Autowired
    public OrderController(CartService cartService, OrderService orderService) {
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @RequestMapping("/cart")
    public String showCart(){

        return "cartView";
    }
    /* Wraca do home -  trzeba pamiętać zeby w html th:href="strona" też
        zmienić na strone do której przekierowujemy działa to po wszystkicch strona dzięki "header" th:fragment */
    @GetMapping("/strona")
    public String showHome(){
        return "redirect:/strona";
    }



    /* Wraca nas do strony głownej z sakcji usuwania, zwiększania, zmniejszania */
    @GetMapping("/remove/strona")
    public String showHome3(){
        return "redirect:/strona";
    }

    @GetMapping("/increase/strona")
    public String showHome4(){
        return "redirect:/strona";
    }

    @GetMapping("/decrease/strona")
    public String showHome5(){
        return "redirect:/strona";
    }





    /* zwiększanie pojedynczych itemów */

    @GetMapping("/increase/{itemId}")
    public String increaseItem(@PathVariable("itemId") Long itemId, @RequestParam("query") String query) {
        cartService.itemOperation(itemId, ItemOperation.INCREASE, query);
        return "cartView";
    }

    /* usuwanie pojedynczych itemów */
    @GetMapping("/decrease/{itemId}")
    public String decreaseItem(@PathVariable("itemId") Long itemId, @RequestParam("query") String query) {
        cartService.itemOperation(itemId, ItemOperation.DECREASE, query);
        return "cartView";
    }

    /* usuwanie wszystkich itemow */

    @GetMapping("/remove/{itemId}")
    public String removeItemsFromCart(@PathVariable("itemId") Long itemId, @RequestParam("query") String query) {
        cartService.itemOperation(itemId, ItemOperation.REMOVE, query);
        return "cartView";
    }

    @GetMapping("/summary")
    public String showSummary(){
        return "summary";
    }

    /* Formularz do przechwytywanie danych do wysyłki*/
    @PostMapping("/saveorder")
    public String saveOrder(OrderDto orderDto){
        orderService.saveOrder(orderDto);
        return "redirect:/home";
    }

}
