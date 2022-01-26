package com.energy.microservices.invoices.services.impl;

import com.energy.microservices.invoices.dto.InvoiceDTO;
import com.energy.microservices.invoices.dao.InvoiceRepository;
import com.energy.microservices.invoices.entities.InvoiceBO;
import com.energy.microservices.invoices.exceptions.BusinessException;
import com.energy.microservices.invoices.mappers.InvoiceMapper;
import com.energy.microservices.invoices.services.InvoiceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Haytham DAHRI
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public InvoiceDTO saveInvoice(InvoiceDTO invoice) {
        InvoiceBO invoiceBO = this.invoiceMapper.toModel(invoice);
        invoiceBO = this.invoiceRepository.save(invoiceBO);
        return this.invoiceMapper.toDto(invoiceBO);
    }

    @Override
    public InvoiceDTO getInvoice(long id) {
        InvoiceBO invoiceBO = this.invoiceRepository.findById(id).orElseThrow(() -> new BusinessException("No Invoice found with id " + id));
        return this.invoiceMapper.toDto(invoiceBO);
    }

    @Override
    public void deleteInvoice(long id) {
        this.invoiceRepository.deleteById(id);
    }

    @Override
    public List<InvoiceDTO> getInvoices() {
        return this.invoiceRepository.findAll().stream().map(this.invoiceMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<InvoiceDTO> getInvoices(int page, int size) {
        Page<InvoiceBO> invoicesPage = this.invoiceRepository.findInvoicesPage(PageRequest.of(page, size));
        List<InvoiceDTO> invoiceDTOList = invoicesPage.getContent().stream().map(this.invoiceMapper::toDto).collect(Collectors.toList());
        return new PageImpl<>(invoiceDTOList, invoicesPage.getPageable(), invoicesPage.getTotalPages());
    }
}
