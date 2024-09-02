package uz.location.spatial.controller.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.location.spatial.controller.SchoolController;
import uz.location.spatial.dto.SchoolDto;
import uz.location.spatial.service.SchoolService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schools")
public class SchoolControllerImpl implements SchoolController {
    private final SchoolService schoolService;

    @Operation(summary = "Get a list of all schools", description = "Fetch a list of schools with pagination and sorting")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
    })
    @GetMapping
    public List<SchoolDto> readAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "") String search) {
        List<SchoolDto> schools = schoolService.readAll(page, size, sortBy, search);
        return ResponseEntity.ok(schools).getBody();
    }

    @Override
    public SchoolDto readById(Long id) {
        return null;
    }

    @Override
    public SchoolDto create(SchoolDto createRequest) {
        return null;
    }

    @Override
    public SchoolDto update(Long id, SchoolDto updateRequest) {
        return null;
    }

    @Override
    public SchoolDto patch(Long id, SchoolDto updateRequest) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

}