package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary /*-- It would be used as the first option where it will be required the GreetingService and nothing will be setted*/
@Service
public class PrimaryGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello world  - From the primary Bean";
    }
}
