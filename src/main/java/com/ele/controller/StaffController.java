package com.ele.controller;

import com.ele.controller.dto.ResponseDto;
import com.ele.repository.StaffRepository;
import com.ele.repository.entity.Staff;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Staff")
@RequiredArgsConstructor
@RequestMapping("/staff")
@RestController
@Slf4j
public class StaffController {

    private final StaffRepository staffRepository;

    @Operation(summary = "Demo for post request")
    @PostMapping
    ResponseDto createStaff() {
        Staff staff = generateStaff();
        log.info("Create Staff: {}", generateStaff());
        staffRepository.save(staff);
        return ResponseDto.success("Create staff success");
    }

    @Operation(summary = "Demo for get request")
    @GetMapping
    ResponseDto getStaffList() {
        log.info("Get Staff List");
        return ResponseDto.success(staffRepository.findAll());
    }

    private Staff generateStaff(){
        Staff randomStaff = new Staff();
        randomStaff.setName(UUID.randomUUID().toString());
        return randomStaff;
    }
}
