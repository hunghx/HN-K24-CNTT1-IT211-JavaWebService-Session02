package re.edu;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // làm về web => view
//@ResponseBody
@RestController // trả về JSON
public class EndPointApi {
    @GetMapping("/api/message")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public String message() {
        return "Bạn đang test api đầu tiên"; // 200
    }


    // CRUD
//    5 method trong CRUD
    // Quản lí sinh viên
    // Lấy dugn sách :
    @GetMapping("/api/students")
    public List<String> getAllStudents() {
        return null;
    }

    @GetMapping("/api/students/{id}")
    public List<String> getStudentById(@PathVariable("id") Long id) {
        return null;

    }

    @DeleteMapping("/api/students/{id}")
    public List<String> deleteStudentById(@PathVariable("id") Long id) {
        return null;

    }

    @PutMapping("/api/students/{id}")
    public String updateStudent(@PathVariable("id") Long id) {
        return null;

    }

    @PostMapping("/api/students")
    public String addStudent() {
        return null;
    }


}
