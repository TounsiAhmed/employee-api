package net.javaguides.springboot;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringbootEmployeeApiTests {

    @Autowired
    EmployeeRepository empRep;

    //SIMPLE TEST
    @Test
    public void testSet()
    {
        Employee emp=new Employee();
        emp.setFirstName("Aziz");
        assertEquals(emp.getFirstName(),"Aziz");
    }

    //CRUD TESTS

    @Test
    public void testCreate()
    {
        Employee emp=new Employee();
        emp.setId(1);
        emp.setFirstName("Mohamed Aziz");
        emp.setLastName("Bennour");
        emp.setAddress("11 Street Hbib bougatfa");
        emp.setManagerId(2);
        emp.setAccountNumber(12345);
        emp.setGrade("Assistant");
        empRep.save(emp);
        assertNotNull(empRep.findById(1L).get());

    }

    public void testReadALl()
    {
        List<Employee> list=empRep.findAll();
        assertThat(list).size().isGreaterThan(0);
    }

    public void testSingleEmployee()
    {
        Employee emp=empRep.findById(1L).get();
        assertEquals(12345,emp.getAccountNumber());
    }

    public void testDelete()
    {
        empRep.deleteById(1L);
        assertThat(empRep.existsById(1L)).isFalse();
    }

}


