package ro.fasttrackit.curs11.homework.client.commands;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.curs11.homework.client.service.StudentService;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class StudentCommands {
    private final StudentService service;

    @ShellMethod("Print all students")
    void printAllStudents() {
        service.getAllStudents()
                .forEach(System.out::println);
    }

    @ShellMethod("Age filter")
    void studentsByAge() {
        System.out.print("Student age: ");
        Scanner scanner = new Scanner(System.in);
        Integer age = scanner.nextInt();
        service.getStudentsByAge(age)
                .forEach(System.out::println);
    }
}
