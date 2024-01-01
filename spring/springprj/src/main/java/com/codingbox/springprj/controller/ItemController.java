package com.codingbox.springprj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingbox.springprj.domain.Item;
import com.codingbox.springprj.dto.ItemForm;
import com.codingbox.springprj.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ItemController {
	
	private final ItemService itemService ;

	@GetMapping("/items/new")
	public String createForm(Model model) {
		model.addAttribute("form", new ItemForm());
		return "items/createItemForm";
	}
	
	@PostMapping("/items/new")
	public String create(ItemForm form) {
		Item item = new Item();
		item.setName(form.getName());
		item.setPrice(form.getPrice());
		item.setStockQuantity(form.getStockQuantity());
		
		itemService.saveItem(item);
		return "redirect:/";
	}
	
	@GetMapping("/items")
	public String list(Model model) {
		List<Item> items = itemService.findItems();
		model.addAttribute("items", items);
		return "items/itemList";
	}
	
	@GetMapping("items/{itemId}/edit")
	public String updateItemForm(@PathVariable("itemId")Long itemId,
			Model model) {
		Item item = itemService.findOne(itemId);
		
		ItemForm form = new ItemForm();
		form.setId(itemId);
		form.setName(item.getName());
		form.setPrice(item.getPrice());
		form.setStockQuantity(item.getStockQuantity());
		
		model.addAttribute("form", form);
		
		return "items/updateItemForm";
	}
	
//	@PostMapping("items/{itemId}/edit")
//	public String updateItem(@ModelAttribute("form")Item form) {
//		
//		Item item = new Item();
//		item.setId(form.getId());
//		item.setName(form.getName());
//		item.setPrice(form.getPrice());
//		item.setStockQuantity(form.getStockQuantity());
//		
//		itemService.updateItem(form.getId(), item);
//		
//		// merge 사용 금지
////		itemService.saveItem(item);
//		
//		return "redirect:/items";
//	}
	
	
	@PostMapping("items/{itemId}/edit")
	public String updateItem(@PathVariable Long itemId,
			@ModelAttribute("form")Item form) {
		// 유지보수에 더 좋은 코드
		itemService.updateItem(itemId, 
			form.getName(), form.getPrice(), form.getStockQuantity());
		
		return "redirect:/items";
	}
	
}













