package com.ibm.fscc.employeeservice.controller;

//The import statements import various classes and interfaces from different packages, allowing the application to use them.
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


/* Here are the rest APIs that are related to the Employee service. */

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

	private IEmployeeService iEmployeeService;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto>createEmployee(@RequestBody EmployeeDto employeeDto){
		iEmployeeService.createEmployee(employeeDto);

		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseDto(EmployeeConstants.STATUS_201, EmployeeConstants.MESSAGE_201));
	}

	@GetMapping("/fetch")
	public ResponseEntity<EmployeeDto> fetchEmployeeDetails(@RequestParam String email){
		EmployeeDto employeeDto = iEmployeeService.fetchEmployee(email);

		return ResponseEntity.status(HttpStatus.OK).body(employeeDto);
	}

	@GetMapping("/fetch/all")
	public List<EmployeeEntity> fetchAllEmployeeDetails() {
		return iEmployeeService.getAllEmployees();
	}


	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateEmployee(@RequestBody EmployeeDto employeeDto){
		boolean isUpdated = iEmployeeService.updateEmployee(employeeDto.getId(), employeeDto);
		if(isUpdated){
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(EmployeeConstants.STATUS_201, EmployeeConstants.MESSAGE_201));
		}else{
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(new ResponseDto(EmployeeConstants.STATUS_500, EmployeeConstants.MESSAGE_500));
		}
	}



	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteEmployee(@RequestBody EmployeeDto employeeDto){
		boolean isDeleted = iEmployeeService.deleteEmployee(employeeDto.getEmail());
		if(isDeleted){
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseDto(EmployeeConstants.STATUS_200, EmployeeConstants.MESSAGE_200));
		}else{
			return ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ResponseDto(EmployeeConstants.STATUS_500, EmployeeConstants.MESSAGE_500));
		}
	}
}
