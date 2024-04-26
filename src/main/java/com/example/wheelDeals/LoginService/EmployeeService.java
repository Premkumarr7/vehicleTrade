package com.example.wheelDeals.LoginService;

import com.example.wheelDeals.DTO.EmployeeDTO;
import com.example.wheelDeals.DTO.LoginDTO;
import com.example.wheelDeals.Response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}