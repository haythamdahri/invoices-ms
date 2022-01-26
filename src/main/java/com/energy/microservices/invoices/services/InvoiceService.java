package com.energy.microservices.invoices.services;

import com.energy.microservices.invoices.dto.InvoiceDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Haytham DAHRI
 */
public interface InvoiceService {

    /**
     * Save a given {@link InvoiceDTO}
     *
     * @param invoice: {@link InvoiceDTO}
     * @return {@link InvoiceDTO}
     */
    InvoiceDTO saveInvoice(InvoiceDTO invoice);

    /**
     * Get an {@link InvoiceDTO} based on the provided id
     *
     * @param id: Invoice ID
     * @return {@link InvoiceDTO}
     */
    InvoiceDTO getInvoice(long id);

    /**
     * Delete an {@link InvoiceDTO} by a given ID
     *
     * @param id: Invoice ID
     */
    void deleteInvoice(long id);

    /**
     * Get List of {@link InvoiceDTO}
     *
     * @return {@link List<InvoiceDTO>}
     */
    List<InvoiceDTO> getInvoices();

    /**
     * Get Page of {@link InvoiceDTO}
     *
     * @return {@link Page<InvoiceDTO>}
     */
    Page<InvoiceDTO> getInvoices(int page, int size);

}
