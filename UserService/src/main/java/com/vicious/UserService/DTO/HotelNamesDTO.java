package com.vicious.UserService.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelNamesDTO {

	private Long hotelId;
	private String hotelName;
	private String abouthotel;
	private Long phnNumber;
	private String email;

	@Lob
	private byte[] image;
	private String hotelHighlights;

	@Transient
	@OneToOne
	private HotelCategoryDTO hotelCategoryTO;

	//     @ManyToOne
	//     private RoomsCategory roomsCategory;

	@OneToOne
	@Transient
	private LocationsDTO location;

	@Transient
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "displayActivites", joinColumns = { @JoinColumn(name = "hotelNames_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "activity_id") })
	private Set<ActivitiesDTO> assignedActivities = new HashSet<>();
}
