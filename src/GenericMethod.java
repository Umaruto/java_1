import java.util.*;


public class GenericMethod {
    public static void main(String[] args) {
//        Integer[] arr1 = {1,3,5,7};
//        Integer[] arr2 = {2,4,6,8,9,10};
//        System.out.println(Util.mergeList(arr1, arr2));
//        Map<Integer, String> map1 = new HashMap<>();
//        map1.put(12, "me");
//        map1.put(13, "you");
//        map1.put(14,"we");
//        Util.printListElements(map1);
        TaskScheduler scheduler = new TaskScheduler();


        scheduler.addTask(new Task("Code Review", 3, 20));
        scheduler.addTask(new Task("System Update", 5, 45));
        scheduler.addTask(new Task("Database Backup", 2, 30));
        scheduler.addTask(new Task("Deploy New Feature", 5, 50));
        scheduler.addTask(new Task("Bug Fixing", 4, 25));

        scheduler.displayScheduledTasks();

        scheduler.processTask();

        scheduler.delayTask("Code Review");

        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();

        scheduler.delayTask("Database Backup");

        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();

        scheduler.processTask();
        scheduler.processTask();

        scheduler.displayScheduledTasks();
        scheduler.displayPendingTasks();

        scheduler.processTask();
        scheduler.processTask();

    }

}


class Task implements Comparable<Task> {
    String taskName;
    int priority;
    int duration;

    public Task(String taskName, int priority, int duration) {
        this.taskName = taskName;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority);
        }
        return Integer.compare(this.duration, other.duration);
    }

    @Override
    public String toString() {
        return "[Priority " + priority + "] " + taskName + " (Duration: " + duration + " mins)";
    }
}

class TaskScheduler {
    private PriorityQueue<Task> scheduledTasks = new PriorityQueue<>();
    private Queue<Task> pendingTasks = new LinkedList<>();

    public void addTask(Task task) {
        scheduledTasks.offer(task);
        System.out.println("Task Added: " + task);
    }

    public void processTask() {
        if (!scheduledTasks.isEmpty()) {
            Task task = scheduledTasks.poll();
            System.out.println("Processing Task: " + task);
        } else if (!pendingTasks.isEmpty()) {
            Task task = pendingTasks.poll();
            System.out.println("Processing Pending Task: " + task);
        } else {
            System.out.println("No tasks to process.");
        }
    }

    public void delayTask(String taskName) {
        Iterator<Task> iterator = scheduledTasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.taskName.equals(taskName)) {
                iterator.remove();
                pendingTasks.offer(task);
                System.out.println("Delaying Task: " + taskName);
                return;
            }
        }
        System.out.println("Task not found in scheduled tasks.");
    }

    public void displayScheduledTasks() {
        System.out.println("Scheduled Tasks (sorted by priority):");
        if (scheduledTasks.isEmpty()) {
            System.out.println("(No priority tasks)");
        } else {
            scheduledTasks.forEach(System.out::println);
        }
    }

    public void displayPendingTasks() {
        System.out.println("Pending Tasks (FIFO Order):");
        if (pendingTasks.isEmpty()) {
            System.out.println("(No pending tasks)");
        } else {
            pendingTasks.forEach(System.out::println);
        }
    }
}





class Util{

    public static <T> ArrayList<T> mergeList(T[] array1, T[] array2){
        ArrayList<T> array3 = new ArrayList<>();
        if (array2.length> array1.length){
            for (int i = 0; i < array2.length; i++){
                if(array1.length>i){
                    array3.add(array1[i]);
                }
                array3.add(array2[i]);
            }
        }else {
            for (int i = 0; i < array1.length; i++){
                array3.add(array1[i]);
                if(array2.length<=i+1){
                    array3.add(array2[i]);
                }
            }
        }
        return array3;
    }

    public static <T,V> void printListElements(Map<T,V> map){
        for (Map.Entry<T, V> entry : map.entrySet()) {
            T id = entry.getKey();
            V element = entry.getValue();

            System.out.println(id + " : " + element);
        }
    }

}