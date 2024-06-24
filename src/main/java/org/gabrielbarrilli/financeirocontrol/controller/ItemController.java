package org.gabrielbarrilli.financeirocontrol.controller;

import org.gabrielbarrilli.financeirocontrol.model.Item;
import org.gabrielbarrilli.financeirocontrol.model.dto.ItemRequest;
import org.gabrielbarrilli.financeirocontrol.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ResponseStatus(OK)
    @GetMapping("/getAllItens")
    public List<Item> getItems() {
        return itemService.findAll();
    }

    @ResponseStatus(CREATED)
    @PostMapping("/createItem")
    public Item createItem(@RequestBody ItemRequest itemRequest) {
        return itemService.create(itemRequest);
    }
}
