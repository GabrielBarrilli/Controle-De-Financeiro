package org.gabrielbarrilli.financeirocontrol.service;

import org.gabrielbarrilli.financeirocontrol.model.Item;
import org.gabrielbarrilli.financeirocontrol.model.dto.ItemRequest;
import org.gabrielbarrilli.financeirocontrol.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Item create(ItemRequest itemRequest) {
        Item item = new Item();

        item.setDescricao(itemRequest.descricao());
        item.setNome(itemRequest.nome());
        item.setValor(itemRequest.valor());

        return itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
