package ie.atu.lab5_validation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
