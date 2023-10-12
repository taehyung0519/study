package com.codingbox.jpashop.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Orderitem {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ITEM_ID")
	private Long id;
	
//	@Column(name = "ORDER_ID")
//	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name = "ORDER_ID")
	private Order order;
	
//	@Column(name = "ITEM_ID")
//	private Long itemId;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_ID")
	private Item item;
	
	
	private int orderPrice;
	private int count;
	

	
	
	
}
