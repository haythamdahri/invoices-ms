package com.energy.microservices.invoices.config;

import com.energy.microservices.invoices.dao.InvoiceRepository;
import com.energy.microservices.invoices.entities.InvoiceBO;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Haytham DAHRI
 */
@Configuration
public class DatabaseSupplierConfig {

    private final InvoiceRepository invoiceRepository;

    public DatabaseSupplierConfig(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    /**
     * Event listener to persist data in database
     */
    @EventListener(value = {ApplicationReadyEvent.class})
    public void onApplicationReadyEvent() {
        this.invoiceRepository.saveAll(
                List.of(
                    new InvoiceBO(null, LocalDateTime.now(), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null),
                        new InvoiceBO(null, LocalDateTime.of(2000, 1,1, 10, 0, 0), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null),
                        new InvoiceBO(null, LocalDateTime.of(2001, 10,1, 12, 0, 0), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null),
                        new InvoiceBO(null, LocalDateTime.of(2002, 8,1, 8, 0, 0), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null),
                        new InvoiceBO(null, LocalDateTime.of(2012, 1,1, 11, 0, 0), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null),
                        new InvoiceBO(null, LocalDateTime.of(2022, 7,1, 7, 0, 0), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null),
                        new InvoiceBO(null, LocalDateTime.of(2019, 1,1, 4, 0, 0), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null),
                        new InvoiceBO(null, LocalDateTime.of(2005, 9,1, 5, 0, 0), BigDecimal.valueOf(120.65), BigDecimal.valueOf(26.99), null)
                )
        );
    }

}
