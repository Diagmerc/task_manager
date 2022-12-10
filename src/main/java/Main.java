import Repository.InMemoryTaskRepository;
import Service.JsonBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws IOException {
        InMemoryTaskRepository inMemoryTaskRepository = new InMemoryTaskRepository().addTask(1, LocalDate.now(), LocalTime.now(),
                        LocalDateTime.of(2022, 12, 11, 12, 44), "Vasiliy", "Petrov")
                .addTask(2, LocalDate.now(), LocalTime.now(),
                        LocalDateTime.of(2022, 12, 17, 12, 44),
                        "Ivan", "Ivanov")
                .addTask(3, LocalDate.now(), LocalTime.now(),
                        LocalDateTime.of(2022, 12, 12, 12, 44),
                        "Petr", "Vasiliev")
                .addTask(3, LocalDate.now(), LocalTime.now(),
                        LocalDateTime.of(2022, 12, 10, 12, 44),
                        "Abdula", "Abdula");

        new JsonBuilder().addToJson(inMemoryTaskRepository.getUrgentTask());
    }

}
