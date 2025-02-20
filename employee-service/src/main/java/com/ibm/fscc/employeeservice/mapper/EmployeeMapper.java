package com.ibm.fscc.employeeservice.mapper;

import com.ibm.fscc.employeeservice.data.EmployeeEntity;
import com.ibm.fscc.employeeservice.dto.EmployeeDto;

/*The`EmployeeMapper` is used to convert data between `EmployeeEntity` and `EmployeeDto` objects.*/
public class EmployeeMapper {

	//This method maps an `EmployeeEntity` object to an `EmployeeDto` object.
	public static EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity, EmployeeDto employeeDto) {
		employeeDto.setFirstName(employeeEntity.getFirstName());
		employeeDto.setLastName(employeeEntity.getLastName());
		employeeDto.setAddress(employeeEntity.getAddress());
		employeeDto.setState(employeeEntity.getState());
		employeeDto.setZip(employeeEntity.getZip());
		employeeDto.setCellPhone(employeeEntity.getCellPhone());
		employeeDto.setHomePhone(employeeEntity.getHomePhone());
		employeeDto.setEmail(employeeEntity.getEmail());
		return employeeDto;
	}

	//This method maps an `EmployeeDto` object to an `EmployeeEntity` object.
	public static EmployeeEntity mapToEmployeeEntity(EmployeeDto employeeDto, EmployeeEntity employeeEntity) {
		employeeEntity.setFirstName(employeeDto.getFirstName());
		employeeEntity.setLastName(employeeDto.getLastName());
		employeeEntity.setAddress(employeeDto.getAddress());
		employeeEntity.setState(employeeDto.getState());
		employeeEntity.setZip(employeeDto.getZip());
		employeeEntity.setCellPhone(employeeDto.getCellPhone());
		employeeEntity.setHomePhone(employeeDto.getHomePhone());
		employeeEntity.setEmail(employeeDto.getEmail());
		return employeeEntity;
	}
}
