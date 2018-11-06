package com.anaplan.dashboards.controllers;

import com.anaplan.dashboards.models.Dashboard;
import com.anaplan.dashboards.repositories.DashboardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/")
public class DashboardsController {

    @Autowired
    DashboardsRepository dashboardsRepository;

    // Get All Dashboards
    @GetMapping("/dashboards")
    public List<Dashboard> getAllDashBoards() {
    	return dashboardsRepository.findAll();
        
    }

}