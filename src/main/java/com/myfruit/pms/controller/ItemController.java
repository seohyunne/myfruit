package com.myfruit.pms.controller;


import com.myfruit.pms.dto.ItemDto;
import com.myfruit.pms.mapper.ItemMapper;
import com.myfruit.pms.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/create")
    public String create(){
        return "shop/create-item";
    }

    @PostMapping
    @ResponseBody
    public void createItem(@RequestBody ItemDto itemDto){
        System.out.println(itemDto.getItem());
        itemService.createItem(itemDto);
    }

    @GetMapping("/{id}")
    public String getItem(@PathVariable("id") int id, Model model) {
        try{
            ItemDto itemDto = itemService.getItem(id);
            model.addAttribute("item", itemDto);
        }catch(IllegalStateException e){
            model.addAttribute("message",e.getMessage());
            return "common/error/404";
        }
        return "shop/detail";
    }

    @GetMapping
    public String getItems(Model model){
        List<ItemDto> items = itemService.getItems();
        model.addAttribute("items",items);
        return "shop/list";
    }

    // 수정 - modify 나 edit 주로 사용
    @GetMapping("/{id}/modify")
    public String modify(@PathVariable("id") int id, Model model) {
        try{
            ItemDto itemDto = itemService.getItem(id);
            model.addAttribute("item", itemDto);
        }catch(IllegalStateException e){
            model.addAttribute("message",e.getMessage());
            return "common/error/404";
        }
        return "shop/modify";
    }

    @PostMapping("/{id}/modify")
    @ResponseBody
    public void modifyItem(@RequestBody ItemDto itemDto){
        System.out.println(itemDto.getItem());
        itemService.modifyItem(itemDto);
    }



    // 생성페이지 GET /items/create
    // 생성 POST /items
    // 상세보기 GET /items/{id}
    // 수정 페이지 GET /items/{id}/modify
    // 수정 POST /items/{id}
    // 삭제 GET /items/{id}/remove
    // 목록보기 GET /items
    
    // 생성페이지 GET /items/create
    // 생성 POST /items
    // 상세보기 GET /items/{id}
    // 수정 PUT /items/{id}
    // 삭제 DELETE /items/{id}
    // 목록보기 GET /items





}
