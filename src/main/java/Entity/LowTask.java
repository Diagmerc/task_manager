package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LowTask extends AbstractTask {

    public LowTask(int id, LocalDate openDate, LocalTime openTime, LocalDateTime deadline, String firstName, String lastName) {
        super(id, openDate, openTime, deadline, firstName, lastName);
    }

}
