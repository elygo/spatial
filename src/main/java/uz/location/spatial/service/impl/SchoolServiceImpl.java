package uz.location.spatial.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.location.spatial.dto.SchoolDto;
import uz.location.spatial.entity.School;
import uz.location.spatial.repository.SchoolRepository;
import uz.location.spatial.service.SchoolService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements SchoolService {
    private final SchoolRepository schoolRepository;

    @Override
    public List<SchoolDto> readAll(Integer page, Integer size, String sortBy, String search) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return schoolRepository.findAllWithSearch(pageable, search)
                .stream()
                .map(this::convertToDTO)
                .toList();
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
    public SchoolDto update(SchoolDto updateRequest) {
        return null;
    }

    @Override
    public SchoolDto patch(SchoolDto updateRequest) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private SchoolDto convertToDTO(School school) {
        return SchoolDto.builder()
                .id(school.getId())
                .name(school.getSchoolName())
                .type(school.getSchoolType() != null ? school.getSchoolType().getTypeName() : null)
                .language(school.getSchoolLanguages().toString())
                .region(school.getLocationId() != null ? school.getLocationId().getRegion() : null)
                .city(school.getLocationId() != null ? school.getLocationId().getCity() : null)
                .numStudents(school.getStatistics() != null ? school.getStatistics().getNumStudents() : null)
                .build();
    }
}