package com.codingbox.MyLogin.domain.item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
// @RequiredArgsConstructor 
// : final 이 붙은 멤버변수만 사용해서 생성자를 자동으로 만들어준다. 
public class ItemController {
	
	private final ItemRepository itemRepository;
	
	/*
	 * @ModelAttribute :
	 * 	Controller를 호출할때 (어떤 메서드가 호출되던지 간에)
	 * 	model에 자동으로 해당 내용이 담기도록 보장이 된다. 
	 */
	@ModelAttribute("regions")
	public Map<String, String> regions(){
		// 기존 HashMap 	: 순서가 보장되지 않는다
		// LinkedHashMap: 순서가 보장이 된다. 
		Map<String, String> regions = new LinkedHashMap<>();
		regions.put("SEOUL", "서울");
		regions.put("BUSAN", "부산");
		regions.put("JEJU", "제주");
		//model.addAttribute("regions", regions);
		return regions;
	}
	
	@ModelAttribute("itemTypes")
	public ItemType[] itemTypes() {
		// enum에 있는 값을 배열로 넘겨준다.
		return ItemType.values();
	}
	
	@ModelAttribute("deliveryCodes")
	public List<DeliveryCode> deliveryCodes(){
		List<DeliveryCode> deliveryCodes = new ArrayList<>();
		deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
		deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
		deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));
		return deliveryCodes;
	}
		
	@GetMapping
	public String items(Model model) {
		// 로그인 체크 여부
		List<Item> items = itemRepository.findAll();
		model.addAttribute("items", items);
		return "items/items";
	}
	
	@GetMapping("/{itemId}")
	public String item(@PathVariable long itemId, Model model) {
		// 로그인 체크 여부
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "items/item";
	}
	
	@GetMapping("/add")
	public String addForm(Model model) {
		// 로그인 체크 여부
		model.addAttribute("item", new Item());
		return "items/addForm";
	}

	@PostMapping("/add")
	public String saveItemV9(Item item, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		// 로그인 체크 여부
		if( !StringUtils.hasText(item.getItemName()) ) {
			bindingResult.addError( 
				new FieldError("item", "itemName", item.getItemName(),
					false, new String[]{"required.item.itemName"}, null, null) );
		}
		
		if( item.getPrice() == null || 
			item.getPrice() < 1000 || 
			item.getPrice() > 1000000 ) {
			bindingResult.addError(
				new FieldError("item", "price", item.getPrice(),
					false, new String[] {"range.item.price"}, new Integer[] {1000,1000000}, null));
		}
		
		if( item.getQuantity() == null || 
			item.getQuantity() > 10000 ) {
			bindingResult.addError( 
				new FieldError("item", "quantity", item.getQuantity(),
					false, new String[] {"max.item.quantity"}, new Integer[] {10000}, null));
		}
		
		// 검증에 실패한다면 다시 입력 폼
		if( bindingResult.hasErrors() ) {
			System.out.println("errors : " + bindingResult);
			return "items/addForm";
		}
		
		Item savedItem = itemRepository.save(item);
		redirectAttributes.addAttribute("status", true);
		return "redirect:/items/" + item.getId();
	}
	
	@GetMapping("/{itemId}/edit")
	public String editForm(@PathVariable Long itemId, Model model) {
		// 로그인 체크 여부
		Item item = itemRepository.findById(itemId);
		model.addAttribute("item", item);
		return "items/editForm";
	}
	
	@PostMapping("/{itemId}/edit")
	public String edit(@PathVariable Long itemId, 
			@ModelAttribute Item item) {
		// 로그인 체크 여부
		System.out.println("item : " + item.getOpen());
		itemRepository.update(itemId, item);
		return "redirect:/items/{itemId}";
	}
	
	// 테스트 데이터 추가
	@PostConstruct
	public void init() {
		//System.out.println("초기화 메서드 실행");
		itemRepository.save(new Item("testA", 100000, 10));
		itemRepository.save(new Item("testB", 200000, 20));
	}
	
}










