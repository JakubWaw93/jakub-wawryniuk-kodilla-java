package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyEmployeeFacade {
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    @Autowired
    public CompanyEmployeeFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }


    public List<Company> getCompanies(final String partialName) {
        return companyDao.retrieveByPartialName(partialName);
    }

    public List<Employee> getEmployees(final String partialName) {
        return employeeDao.retrieveByPartialName(partialName);
    }

}
