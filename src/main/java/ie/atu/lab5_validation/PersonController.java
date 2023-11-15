package ie.atu.lab5_validation;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class PersonController {
    private final PersonService personService ;

    public PersonController(PersonService personService) {
        this.personService;
    }

    @GetMapping("/{employed")
    public ResponseEntity<?> getPerson(@PathVariable String employeeId) {
        if(employeeId.length() > 5 || employeeId.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }

        Person person = personService.getPersonByEmployeeId(employeeId);

        if(person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String>create(@Valid @RequestBody Person person) {
        personService.savePerson(person);
        return new ResponseEntity<>("Person created successfully", HttpStatus.OK);
    }
}
