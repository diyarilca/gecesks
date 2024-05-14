package sks.project.sksbackend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.*;
import sks.project.sksbackend.serviceBusiness.ShipmentService;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/shipments")
public class ShipmentController {

	  @Autowired
	    private ShipmentService shipmentService;

	@PostMapping
	public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
		Shipment createdShipment = shipmentService.createShipment(shipment);
		return new ResponseEntity<>(createdShipment, HttpStatus.CREATED);
	}


	@PutMapping("{id}")
	    public Shipment updateShipment(@RequestBody Long id,
	                                   @RequestBody Long companyId,
	                                   @RequestBody Long shipId,
	                                   @RequestBody Long productId,
	                                   @RequestBody Long vehicleId,
	                                   @RequestBody String departurePoint,
	                                   @RequestBody String destinationPoint,
	                                   @RequestBody String customerPhone,
	                                   @RequestBody String price,
	                                   @RequestBody String comment) {
	        return shipmentService.updateShipment(id, companyId, shipId, productId, vehicleId, departurePoint, destinationPoint, customerPhone, price, comment);
	    }

	    @DeleteMapping("{id}")
	    public void deleteShipment(@PathVariable Long id) {
	        shipmentService.deleteShipment(id);
	    }

	    @GetMapping
	    public List<Shipment> getAllShipments() {
	        return shipmentService.getAllShipments();
	    }

	    @GetMapping("{id}")
	    public Shipment getShipmentById(@PathVariable Long id) {
	        return shipmentService.getShipmentById(id);
	    }
}