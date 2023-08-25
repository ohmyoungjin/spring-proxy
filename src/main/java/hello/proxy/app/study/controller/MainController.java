package hello.proxy.app.study.controller;

import hello.proxy.app.study.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {

    @PostMapping("/test")
    public String test(@RequestBody Student student) {
        log.info("test student={}", student);
        student.show();
        return "OK";
    }
}
