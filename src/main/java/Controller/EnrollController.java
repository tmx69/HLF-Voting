package Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollController {
    @PostMapping("/enroll")
    String enroll() {
        String str = "Hello!\n";
        return str;
    }
}
