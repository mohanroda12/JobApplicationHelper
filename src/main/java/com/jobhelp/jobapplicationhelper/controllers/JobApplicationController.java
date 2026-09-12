    package com.jobhelp.jobapplicationhelper.controllers;

    import com.jobhelp.jobapplicationhelper.entities.UserEntity;
    import com.jobhelp.jobapplicationhelper.models.ApplicationStatus;
    import com.jobhelp.jobapplicationhelper.models.JobApplication;
    import com.jobhelp.jobapplicationhelper.models.SearchModel;
    import com.jobhelp.jobapplicationhelper.services.JobApplicationServiceInterface;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.core.Authentication;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import java.util.List;


    @Controller
    @RequestMapping("/applications")
    public class JobApplicationController {

        @Autowired
        JobApplicationServiceInterface jobApplicationService;

        @GetMapping("")
        public String showAllApplications(Model model, @AuthenticationPrincipal UserEntity user) {

            List<JobApplication> applications = jobApplicationService.getJobApplicationsByAccountID(user.getId());
            model.addAttribute("applications", applications);
            model.addAttribute("searchModel", new SearchModel());

            return "applications";
        }

        @GetMapping("/addNew")
        public String addNewApplicationForm(Model model, Authentication authentication) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            UserEntity user = (UserEntity) userDetails;

            model.addAttribute("jobApplication", new JobApplication());
            model.addAttribute("statuses", ApplicationStatus.values());
            model.addAttribute("currentAccountID", user.getId());

            return "addNewApplication";
        }

        @PostMapping("/saveNew")
        public String addNewApplication(@Valid JobApplication newApplication, BindingResult bindingResult,
                                        @AuthenticationPrincipal UserEntity user) {
            newApplication.setApplicationID(null);
            newApplication.setAccountID(user.getId());

            jobApplicationService.addOne(newApplication, user.getId());
            return "redirect:/applications";
        }

        @PostMapping("/search/role")
        public String searchByRole(@Valid SearchModel searchModel, BindingResult bindingResult, Model model,
                                   @AuthenticationPrincipal UserEntity user) {

            String searchTerm = searchModel.getSearchTerm();

            //Filter by search term
            List<JobApplication> applications = jobApplicationService.searchByRole(searchTerm, user.getId());
            model.addAttribute("applications", applications);

            return "applications";
        }

        @PostMapping("/delete")
        public String deleteApplication(@RequestParam Long applicationID,
                                        @AuthenticationPrincipal UserEntity user) {

            jobApplicationService.deleteOne(applicationID, user.getId());
            return "redirect:/applications";
        }

        @PostMapping("/edit")
        public String editApplicationForm(@Valid JobApplication currentApplication, Model model) {
            model.addAttribute("jobApplication", currentApplication);
            model.addAttribute("statuses", ApplicationStatus.values());
            return "editApplication";
        }

        @PostMapping("/updateApplication")
        public String updateApplication(@Valid JobApplication application, BindingResult bindingResult,
                                        @AuthenticationPrincipal UserEntity user) {
            jobApplicationService.updateOne(application.getApplicationID(), application, user.getId());
            return "redirect:/applications";
        }
    }


