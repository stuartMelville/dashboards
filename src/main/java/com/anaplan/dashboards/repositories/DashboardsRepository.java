package com.anaplan.dashboards.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anaplan.dashboards.models.Dashboard;

@Repository
public interface DashboardsRepository extends JpaRepository<Dashboard, Long> {

}