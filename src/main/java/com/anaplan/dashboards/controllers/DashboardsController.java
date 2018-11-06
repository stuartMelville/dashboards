package com.anaplan.dashboards.controllers;

import com.anaplan.dashboards.exceptions.ResourceNotFoundException;
import com.anaplan.dashboards.models.Dashboard;
import com.anaplan.dashboards.repositories.DashboardsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    // Create a new Dashboard
    @PostMapping("/dashboards")
    public Dashboard createDashboard(@Valid @RequestBody Dashboard dashboard) {
        return dashboardsRepository.save(dashboard);
    }

    // Get a Single Dashboard
    @GetMapping("/dashboards/{id}")
    public Dashboard getDashboardById(@PathVariable(value = "id") Long dashboardId) {
        return dashboardsRepository.findById(dashboardId)
                .orElseThrow(() -> new ResourceNotFoundException("Dashboard", "id", dashboardId));
    }

    // Search Dashboards by title 
    @GetMapping("/dashboards/search")
    public List<Dashboard> searchDashboards(@RequestParam(value = "title", defaultValue = "") String dashboardTitle,
    										@RequestParam(value = "date", defaultValue = "") String createdDate) {
    	List<Dashboard> dashboards = dashboardsRepository.findAll();
    	return	dashboards.stream()
    			.filter(dashboard -> dashboard.getTitle().contains(dashboardTitle))
    			.filter(dashboard -> dashboard.getCreatedAt().toString().contains(createdDate))
    			.collect(Collectors.toList());
    }
    
    // Search Dashboards by title 
    @GetMapping("/dashboards/search/{title}")
    public List<Dashboard> getDashboardByTitle(@PathVariable(value = "title") String dashboardTitle) {
    	List<Dashboard> dashboards = dashboardsRepository.findAll();
    	return	dashboards.stream()
    			.filter(dashboard -> dashboard.getTitle().contains(dashboardTitle))
    			.collect(Collectors.toList());
    }
    
    // Search Dashboards by matching dateString 
    @GetMapping("/dashboards/search/{createddate}")
    public List<Dashboard> getDashboardByCreatedDate(@PathVariable(value = "createddate") String createdDate) {
    	List<Dashboard> dashboards = dashboardsRepository.findAll();
    	return	dashboards.stream()
    			.filter(dashboard -> dashboard.getCreatedAt().toString().contains(createdDate))
    			.collect(Collectors.toList());
    }
 
    
    // Update a Dashboard
    @PutMapping("/dashboard/{id}")
    public Dashboard updateDashboard(	@PathVariable(value = "id") Long dashboardId,
    						@Valid @RequestBody Dashboard dashboardDetails) {

        Dashboard dashboard = dashboardsRepository.findById(dashboardId)
                .orElseThrow(() -> new ResourceNotFoundException("Dashboard", "id", dashboardId));
        dashboard.setTitle(dashboardDetails.getTitle());
        Dashboard updatedDashboard = dashboardsRepository.save(dashboard);
        return updatedDashboard;
    }
    
    // Delete a Dashboard
    @DeleteMapping("/dashboards/{id}")
    public ResponseEntity<?> deleteDashboard(@PathVariable(value = "id") Long dashboardId) {
        Dashboard dashboard = dashboardsRepository.findById(dashboardId)
                .orElseThrow(() -> new ResourceNotFoundException("Dashboard", "id", dashboardId));

        dashboardsRepository.delete(dashboard);

        return ResponseEntity.ok().build();
    }
    // Get a Dashboard template
    @GetMapping("/dashboards/template")
    public Dashboard getDashboardTemplate() {
    	Dashboard template = new Dashboard();
    	template.setTitle("Sales targets");
    	template.setId(12345l);
    	Date now = new Date(System.currentTimeMillis());
    	template.setCreatedAt(now);
    	template.setUpdatedAt(now);
    	return template;
    }

}