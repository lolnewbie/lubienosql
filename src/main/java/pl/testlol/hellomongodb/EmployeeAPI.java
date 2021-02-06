package pl.testlol.hellomongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeAPI {

    private final EmployeeFacade employeeFacade;

    @GetMapping
    public Flux<Employee> findAll() {
        return employeeFacade.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity> create(@RequestBody EmployeeCreateDTO createDTO) {
        Mono<EmployeeEntity> persistedEntity = employeeFacade.create(createDTO);
        return persistedEntity
                .map(entity -> ResponseEntity.created(URI.create(String.join("", "/employees/", entity.getId()))).build());
    }

}
