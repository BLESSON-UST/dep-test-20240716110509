Based on the package imports and annotations used, the provided Java code appears to be written in Java 8.

Here's the modified code compatible with Java 17, incorporating new language features, standards, and best practices:

```java
package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentRepo repo;

    @Autowired
    public DepartmentController(DepartmentRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/submit")
    public ResponseEntity<Department> submit(@RequestBody Department department) {
        return ResponseEntity.ok(repo.save(department));
    }

    @GetMapping("/dept")
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{did}")
    public ResponseEntity<Department> getById(@PathVariable int did) {
        Optional<Department> optionalDepartment = repo.findByDid(did);
        if (optionalDepartment.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalDepartment.get());
    }
}
```

Note: 
- The package name should be lowercase (`com.example.department.controller` instead of `com.example.department.Controller`).
- Class names should follow proper naming conventions (`DepartmentController` instead of `DepartmentController`).
- Constructor injection for autowiring the `DepartmentRepo` bean.
- Renamed `getalldept` method to `getAllDepartments` (follows proper naming conventions).
- Updated `getbyid` method to `getById` (follows proper naming conventions).
- Modified the `getById` method to handle the case where the department is not found in the repository.