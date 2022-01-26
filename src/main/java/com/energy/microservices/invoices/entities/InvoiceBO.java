package com.energy.microservices.invoices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @author Haytham DAHRI
 */
@Entity
@Table(name = "invoices")
public class InvoiceBO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "invoiceDate")
    private LocalDateTime invoiceDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "vatAmount")
    private BigDecimal vatAmount;

    @Transient
    private BigDecimal totalAmount;

    public InvoiceBO() {
    }

    public InvoiceBO(Long id, LocalDateTime invoiceDate, BigDecimal amount, BigDecimal vatAmount, BigDecimal totalAmount) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.amount = amount;
        this.vatAmount = vatAmount;
        this.totalAmount = totalAmount;
    }

    @PostLoad
    public void postLoad() {
        this.totalAmount = ofNullable(this.amount).orElse(BigDecimal.ZERO).add(ofNullable(this.vatAmount).orElse(BigDecimal.ZERO));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceBO invoiceBO = (InvoiceBO) o;
        return Objects.equals(id, invoiceBO.id) && Objects.equals(invoiceDate, invoiceBO.invoiceDate) && Objects.equals(amount, invoiceBO.amount) && Objects.equals(vatAmount, invoiceBO.vatAmount) && Objects.equals(totalAmount, invoiceBO.totalAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceDate, amount, vatAmount, totalAmount);
    }

}
