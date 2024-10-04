package com.keerk99.newjobplatform.domain.company;

import com.keerk99.newjobplatform.response.PaginatedResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/companies")
@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
public class CompanyController {
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<PaginatedResponse<DataListCompany>> getAllCompanies(@PageableDefault(size = 10) Pageable pageable) {
        String urlBase = "/companies";
        Page<DataListCompany> companyPage = companyService.findAll(pageable);
        PaginatedResponse<DataListCompany> response = new PaginatedResponse<>(companyPage, urlBase);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@Valid @RequestBody CreateCompany createCompany) {
        companyService.createCompany(createCompany);
        return new ResponseEntity<>("Company created successfully", HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<DataListCompany> getCompanyById(@PathVariable Long companyId) {
        DataListCompany company = companyService.findCompanyById(companyId);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompany(@PathVariable Long companyId,
                                                @Valid @RequestBody UpdateCompany updateCompany) {
        companyService.updateCompany(companyId, updateCompany);
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
    }

}
