package com.energy.microservices.invoices.dao;

import com.energy.microservices.invoices.entities.InvoiceBO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

/**
 * @author Haytham DAHRI
 */
@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceBO, Long> {

    @Query(value = "SELECT i FROM InvoiceBO i")
    Page<InvoiceBO> findInvoicesPage(@PageableDefault PageRequest pageRequest);

}
