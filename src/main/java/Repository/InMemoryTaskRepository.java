package Repository;

import Entity.AbstractTask;
import Entity.LowTask;
import Entity.MediumTask;
import Entity.UrgentTask;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTaskRepository {

    List<AbstractTask> taskQueue;

    public InMemoryTaskRepository() {
        this.taskQueue = new ArrayList<>();
    }

    public List<AbstractTask> getTaskQueue() {
        return taskQueue;
    }

    public InMemoryTaskRepository addTask(int id, LocalDate openDate, LocalTime openTime,
                                LocalDateTime deadline, String firstName, String lastName){
        if(deadline.isBefore(LocalDateTime.now().plusDays(1))){
            UrgentTask urgentTask = new UrgentTask(id, openDate, openTime, deadline, firstName, lastName);
            urgentTask.setPriority(urgentTask.getClass().getSimpleName());
            taskQueue.add(urgentTask);
        }else if (deadline.isBefore(LocalDateTime.now().plusDays(2))){
            MediumTask mediumTask = new MediumTask(id, openDate, openTime, deadline, firstName, lastName);
            mediumTask.setPriority(mediumTask.getClass().getSimpleName());
            taskQueue.add(mediumTask);
        }else {
            LowTask lowTask = new LowTask(id, openDate, openTime, deadline, firstName, lastName);
            lowTask.setPriority(lowTask.getClass().getSimpleName());
            taskQueue.add(lowTask);
        }
        taskQueue.sort(Comparator.comparing(AbstractTask::getDeadline));
        return this;
    }

    public List<AbstractTask> getUrgentTask(){
        return taskQueue.stream().filter(task -> task.getPriority().equals(UrgentTask.class.getSimpleName()))
                .collect(Collectors.toList());
    }

    public List<AbstractTask> getLowTask(){
        return taskQueue.stream().filter(task -> task.getPriority().equals(LowTask.class.getSimpleName()))
                .collect(Collectors.toList());
    }

    public List<AbstractTask> getMediumTask(){
        return taskQueue.stream().filter(task -> task.getPriority().equals(MediumTask.class.getSimpleName()))
                .collect(Collectors.toList());
    }
}
