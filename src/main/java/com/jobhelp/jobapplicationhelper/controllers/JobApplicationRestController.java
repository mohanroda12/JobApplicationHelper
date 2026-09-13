package com.jobhelp.jobapplicationhelper.controllers;

import com.jobhelp.jobapplicationhelper.entities.UserEntity;
import com.jobhelp.jobapplicationhelper.models.JobApplication;
import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/applications")
public class JobApplicationRestController {

    private final String URL = "/api/v1/applications";

    @Autowired
    JobApplicationServiceInterface jobApplication;

    @GetMapping("")
    public ResponseEntity<List<JobApplication>> showAllApplications(@AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.ok(jobApplication.getJobApplicationsByAccountID(user.getId()));
    }

    @GetMapping("/searchByRole/{searchTerm}")
    public ResponseEntity<List<JobApplication>> searchApplicationByRole(@PathVariable String searchTerm,
                                                        @AuthenticationPrincipal UserEntity user) {
        return ResponseEntity.ok(jobApplication.searchByRole(searchTerm, user.getId()));
    }

    @PostMapping("")
    public ResponseEntity<JobApplication> addOneApplication(@RequestBody JobApplication newApplication,
                                  @AuthenticationPrincipal UserEntity user) {
        JobApplication id = jobApplication.addOne(newApplication, user.getId());
        URI location = URI.create(URL + "/${id}");
        return ResponseEntity.created(location).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> searchApplicationByID(@PathVariable long id,
                                                @AuthenticationPrincipal UserEntity user) {
        JobApplication application = jobApplication.getJobApplicationsByApplicationID(id, user.getId());
        if(application == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(application);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteByID(@PathVariable long id,
                              @AuthenticationPrincipal UserEntity user) {
        boolean deleted = jobApplication.deleteOne(id, user.getId());
        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public JobApplication updateByID(@RequestBody JobApplication newApplication,
                                     @PathVariable long id,
                                     @AuthenticationPrincipal UserEntity user) {
        return jobApplication.updateOne(id, newApplication, user.getId());
    }

}
