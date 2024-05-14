package sks.project.sksbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shipments")
public class Shipment {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "departure_point")
	private String departurePoint;
	
	@Column(name = "destination_point")
	private String destinationPoint;
	
	@Column(name = "customer_phone")
	private String customerPhone;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "ship_id", referencedColumnName = "id")
	private Ship ship;

	@OneToMany(mappedBy = "shipment")
	private List<Vehicle> vehicles;
}
