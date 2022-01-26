package com.energy.microservices.invoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Haytham DAHRI
 */
public class InvoiceDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("invoiceDate")
    private LocalDateTime invoiceDate;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("vatAmount")
    private BigDecimal vatAmount;

    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;

    public InvoiceDTO() {}

    public InvoiceDTO(Long id, LocalDateTime invoiceDate, BigDecimal amount, BigDecimal vatAmount, BigDecimal totalAmount) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDTO that = (InvoiceDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(invoiceDate, that.invoiceDate) && Objects.equals(amount, that.amount) && Objects.equals(vatAmount, that.vatAmount) && Objects.equals(totalAmount, that.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceDate, amount, vatAmount, totalAmount);
    }
}
