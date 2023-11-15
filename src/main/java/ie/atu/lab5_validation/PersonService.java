package ie.atu.lab5_validation;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    // Placeholder method to save a person (add to Db in the new weeks)
    public void savePerson(Person person) {
        System.out.println("Person saved: " + person);
    }

    public Person getPersonByEmployeeId(String employeeId) {
        return new Person();
    }
}
