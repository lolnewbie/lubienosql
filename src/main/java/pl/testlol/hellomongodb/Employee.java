package pl.testlol.hellomongodb;

import lombok.Value;

@Value(staticConstructor = "of")
public class Employee {

    String id;
    String name;

    public static Employee of(EmployeeEntity entity) {
        return Employee.of(entity.getId(), entity.getName());
    }

}
