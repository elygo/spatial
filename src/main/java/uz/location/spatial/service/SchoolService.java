package uz.location.spatial.service;

import uz.location.spatial.dto.SchoolDto;

import java.util.List;

public interface SchoolService extends BaseService<SchoolDto, SchoolDto, Long> {
    List<SchoolDto> getSchoolsWithinDistance(double longitude, double latitude, double distance);
}
