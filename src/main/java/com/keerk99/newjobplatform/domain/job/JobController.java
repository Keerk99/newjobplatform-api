package com.keerk99.newjobplatform.domain.job;

import com.keerk99.newjobplatform.response.PaginatedResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/jobs")
@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class JobController {
    private JobService jobService;

    @GetMapping
    public ResponseEntity<PaginatedResponse<DataListJob>> getAllJobs(@PageableDefault(size = 10) Pageable pageable) {
        String baseUrl = "/jobs";
        Page<DataListJob> jobPage = jobService.getJobs(pageable);
        PaginatedResponse<DataListJob> response = new PaginatedResponse<>(jobPage, baseUrl);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody CreateJob createJob) {
        jobService.createJob(createJob);
        return new ResponseEntity<>("Job created", HttpStatus.OK);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<DataListJob> getJobById(@PathVariable Long jobId) {
        DataListJob job = jobService.findJobById(jobId);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable Long jobId,
                                            @RequestBody UpdateJob updateJob) {
        jobService.updateJob(jobId, updateJob);
        return new ResponseEntity<>("Job updated", HttpStatus.OK);
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<String> deleteJob(@PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return new ResponseEntity<>("Job deleted", HttpStatus.OK);
    }
}
