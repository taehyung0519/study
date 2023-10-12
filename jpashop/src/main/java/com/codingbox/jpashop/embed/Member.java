package com.codingbox.jpashop.embed;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	@Id @GeneratedValue
	private Long id;
	private String username;
//	// 기간
//	private LocalDateTime startDate;
//	private LocalDateTime endDate;
	@Embedded // Emabedded와 Embeddable둘중 하나만 적어도 된다.
	private Period period;
//	// 주소
	@Embedded 
	private Address address;
//	private String city;
//	private String street;
//	private String zipcode;
	
//	// 회사주소
//	@Embedded
//	@AttributeOverrides({
//		@AttributeOverride(name = "city", column = @Column(name="WORK_CITY")),
//		@AttributeOverride(name = "street", column = @Column(name="WORK_STREET")),
//		@AttributeOverride(name = "zipcode", column = @Column(name="WORK_ZIPCODE")),
//	})
	//private Address workAddress;
}
