package pl.testlol.hellomongodb;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface EmployeeRepository extends ReactiveMongoRepository<EmployeeEntity, String> {
}
