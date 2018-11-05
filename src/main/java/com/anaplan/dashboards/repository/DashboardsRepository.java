package com.anaplan.dashboards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anaplan.dashboards.model.Dashboard;

@Repository
public interface DashboardsRepository extends JpaRepository<Dashboard, Long> {

}