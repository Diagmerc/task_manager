package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class UrgentTask extends AbstractTask {

    public UrgentTask(int id, LocalDate openDate, LocalTime openTime, LocalDateTime deadline, String firstName, String lastName) {
        super(id, openDate, openTime, deadline, firstName, lastName);
    }
}
