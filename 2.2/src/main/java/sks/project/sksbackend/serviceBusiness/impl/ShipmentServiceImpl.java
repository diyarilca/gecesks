package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.entities.Company;
import sks.project.sksbackend.entities.Product;
import sks.project.sksbackend.entities.Ship;
import sks.project.sksbackend.entities.Shipment;
import sks.project.sksbackend.entities.Vehicle;
import sks.project.sksbackend.repositoryDataAccess.CompanyRepository;
import sks.project.sksbackend.repositoryDataAccess.ProductRepository;
import sks.project.sksbackend.repositoryDataAccess.ShipRepository;
import sks.project.sksbackend.repositoryDataAccess.ShipmentRepository;
import sks.project.sksbackend.repositoryDataAccess.VehicleRepository;
import sks.project.sksbackend.serviceBusiness.ShipmentService;

@AllArgsConstructor
@Service
public class ShipmentServiceImpl implements ShipmentService{

	@Autowired
	private ShipmentRepository shipmentRepository;
	
	@Autowired
    private ShipRepository shipRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Shipment createShipment(Long companyId, Long shipId, Long productId, Long vehicleId, String departurePoint, String destinationPoint, String customerPhone, String price, String comment) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company ID"));
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ship ID"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle ID"));

        Shipment shipment = new Shipment();
        shipment.setCompany(company);
        shipment.setShip(ship);
        shipment.setProduct(product);
        shipment.setVehicles((List<Vehicle>) vehicle);
        shipment.setDeparturePoint(departurePoint);
        shipment.setDestinationPoint(destinationPoint);
        shipment.setCustomerPhone(customerPhone);
        shipment.setPrice(price);
        shipment.setComment(comment);

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment updateShipment(Long id, Long companyId, Long shipId, Long productId, Long vehicleId, String departurePoint, String destinationPoint, String customerPhone, String price, String comment) {
        Shipment existingShipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found for id: " + id));

        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid company ID"));
        Ship ship = shipRepository.findById(shipId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ship ID"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle ID"));

        existingShipment.setCompany(company);
        existingShipment.setShip(ship);
        existingShipment.setProduct(product);
        existingShipment.setVehicles((List<Vehicle>) vehicle);
        existingShipment.setDeparturePoint(departurePoint);
        existingShipment.setDestinationPoint(destinationPoint);
        existingShipment.setCustomerPhone(customerPhone);
        existingShipment.setPrice(price);
        existingShipment.setComment(comment);

        return shipmentRepository.save(existingShipment);
    }

    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Shipment not found for id: " + id));
    }

    @Override
    public Shipment createShipment(Shipment shipment) {
        // Gelen Shipment nesnesini veritabanına kaydetmek için repository veya entityManager kullanılır
        Shipment createdShipment = shipmentRepository.save(shipment);

        // Oluşturulan Shipment nesnesini döndürmek
        return createdShipment;
    }
}
