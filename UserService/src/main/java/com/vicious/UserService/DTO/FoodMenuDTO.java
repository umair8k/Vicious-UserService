package com.vicious.UserService.DTO;


import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodMenuDTO {

	
	private Long id;
    private String items;
    private Double price;
    
//     @ManyToMany(fetch = FetchType.EAGER,
//
//
//
//             mappedBy = "foodmenu")
//      @JsonIgnore
//      private List<FoodCategory> foodcategory; 
    @Transient
    @ManyToOne
    private FoodCategoryDTO foodCategory;

	
}

