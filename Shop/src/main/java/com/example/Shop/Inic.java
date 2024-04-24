package com.example.Shop;

import com.example.Shop.model.Item;
import com.example.Shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;


// Inicjalizacja przygotowanych danych, które posiadamy
@Configuration
public class Inic implements CommandLineRunner {

    private final ItemRepository itemRepository;

    @Autowired
    public Inic(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
                new Item("jablko", new BigDecimal(1), "/images/jablko.jpg"),
                new Item("banan", new BigDecimal(1.50), "/images/banan.jpg"),
                new Item("masło", new BigDecimal(3.50), "/images/maslo.jpg"),
                new Item("kajzerka", new BigDecimal(0.50), "/images/kajzerka.jpg"),
                new Item("papryka", new BigDecimal(4), "/images/papryka.jpg"),
                new Item("jajko", new BigDecimal(0.90), "/images/jajko.jpg"),
                new Item("pomidor", new BigDecimal(1), "/images/pomidor.jpg")

        ));
    }
}
