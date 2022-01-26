package com.energy.microservices.invoices.mappers;

import com.energy.microservices.invoices.dto.InvoiceDTO;
import com.energy.microservices.invoices.entities.InvoiceBO;
import org.mapstruct.Mapper;

/**
 * @author Haytham DAHRI
 */
@Mapper(componentModel = "spring")
public interface InvoiceMapper extends GenericMapper<InvoiceBO, InvoiceDTO> {
}
