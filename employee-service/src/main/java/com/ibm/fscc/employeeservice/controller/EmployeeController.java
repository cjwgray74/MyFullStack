package com.ibm.fscc.employeeservice.controller;

import com.ibm.fscc.employeeservice.constants.EmployeeConstants;
import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.dto.EmployeeDto;
import com.ibm.fscc.employeeservice.dto.ResponseDto;
import com.ibm.fscc.employeeservice.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

	private final IEmployeeService iEmployeeService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		iEmployeeService.createEmployee(employeeDto);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(EmployeeConstants.STATUS_201, EmployeeConstants.MESSAGE_201));
	}

	@GetMapping("/fetch")
	public ResponseEntity<?> fetchEmployeeDetails(@RequestParam String email) {
		EmployeeDto employeeDto = iEmployeeService.fetchEmployee(email);

		if (employeeDto == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDto(EmployeeConstants.STATUS_500, "Employee not found"));
		}

		return ResponseEntity.ok(employeeDto);
	}

	@GetMapping("/fetch/all")
	public ResponseEntity<?> fetchAllEmployeeDetails() {
		List<EmployeeEntity> employees = iEmployeeService.getAllEmployees();

		if (employees.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.build();
		}

		return ResponseEntity.ok(employees);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
		Long employeeId = employeeDto.getId();
		if (employeeId == null) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseDto(EmployeeConstants.STATUS_500, "Employee ID is required for update"));
		}

		boolean isUpdated = iEmployeeService.updateEmployee(employeeId, employeeDto);

		if (isUpdated) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(EmployeeConstants.STATUS_200, "Employee updated successfully"));
		} else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDto(EmployeeConstants.STATUS_500, "Employee not found"));
		}
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteEmployee(@RequestBody EmployeeDto employeeDto) {
		String email = employeeDto.getEmail();
		if (email == null || email.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseDto(EmployeeConstants.STATUS_500, "Email is required for deletion"));
		}

		boolean isDeleted = iEmployeeService.deleteEmployee(email);

		if (isDeleted) {
			return ResponseEntity
					.ok(new ResponseDto(EmployeeConstants.STATUS_200, EmployeeConstants.MESSAGE_200));
		} else {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ResponseDto(EmployeeConstants.STATUS_500, "Employee not found"));
		}
	}
}