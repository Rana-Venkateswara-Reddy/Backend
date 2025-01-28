package com.rana.demo.controller;

import com.rana.demo.model.Item;
import com.rana.demo.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {



    @Autowired
    private ItemRepo repo;


    @PostMapping()
    public String addItem(@RequestBody Item item) {

        Item createdItem = repo.save(item);
        return " item added sucessfully";
    }

    // Delete Item
    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "deleted sucessfully";
        } else {
            return "item not found";
        }
    }

    // Fetch All Items
    @GetMapping
    public List<Item> getAllItems() {
        List<Item> items = repo.findAll();
        return items;
    }

}
