package com.alex.wojcik.reportweb.repository;

import com.alex.wojcik.reportweb.entity.ReportItem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportItemRepository extends JpaRepository<ReportItem, String> {

  Optional<ReportItem> findById(String id);
}
