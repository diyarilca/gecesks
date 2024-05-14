package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.entities.Shipment;

public interface ShipmentService {
    Shipment createShipment(Long companyId, Long shipId, Long productId, Long vehicleId, String departurePoint, String destinationPoint, String customerPhone, String price, String comment);
    Shipment updateShipment(Long id, Long companyId, Long shipId, Long productId, Long vehicleId, String departurePoint, String destinationPoint, String customerPhone, String price, String comment);
    void deleteShipment(Long id);
    List<Shipment> getAllShipments();
    Shipment getShipmentById(Long id);

    Shipment createShipment(Shipment shipment);
}
