package com.kodilla.kodillapatterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public interface SalaryProcessor {
    BigDecimal calculateSalary(List<Employee> employees);

}
