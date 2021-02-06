package pl.testlol.hellomongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeFacade {

    private final EmployeeRepository employeeRepository;

    public Flux<Employee> findAll() {
        return employeeRepository
                .findAll()
                .map(Employee::of);
    }

    public Mono<EmployeeEntity> create(EmployeeCreateDTO employeeCreateDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(employeeCreateDTO.getName());
        return employeeRepository.save(employeeEntity);
    }

}
