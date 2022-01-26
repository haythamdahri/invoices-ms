package com.energy.microservices.invoices.controllers;

import com.energy.microservices.invoices.dto.InvoiceDTO;
import com.energy.microservices.invoices.services.InvoiceService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Haytham DAHRI
 */
@RestController
@RequestMapping(path = "/api/v1/invoices")
public class InvoiceRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceRestController.class);

    private final InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<InvoiceDTO>> getInvoices() {
        LOGGER.info("Get All Invoices");
        return ResponseEntity.ok(this.invoiceService.getInvoices());
    }

    @PostMapping(path = "/")
    public ResponseEntity<InvoiceDTO> saveInvoice(@RequestBody InvoiceDTO invoice) {
        LOGGER.info("Save an invoice");
        return ResponseEntity.ok(this.invoiceService.saveInvoice(invoice));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable(name = "id") long id) {
        LOGGER.info("Get an invoice");
        return ResponseEntity.ok(this.invoiceService.getInvoice(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable(name = "id") long id) {
        LOGGER.info("Delete an invoice");
        this.invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }

}
