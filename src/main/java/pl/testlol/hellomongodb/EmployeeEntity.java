package pl.testlol.hellomongodb;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode(of = "id")
public class EmployeeEntity {

    @Id
    private String id;
    private String name;

}
