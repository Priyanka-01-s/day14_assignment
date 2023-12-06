import java.util.Arrays;
import java.util.Scanner;

class Task implements Comparable<Task> {
    int deadline;
    int minutes;

    public Task(int deadline, int minutes) {
        this.deadline = deadline;
        this.minutes = minutes;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.deadline, other.deadline);
    }
}

public class Q11_task {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of tasks:");
        int n = scanner.nextInt();

        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the deadlines and minutes for task:"+i+1);
            int deadline = scanner.nextInt();
            int minutes = scanner.nextInt();
            tasks[i] = new Task(deadline, minutes);
        }

        optimizeAndPrintOvershoots(tasks);
    }

    private static void optimizeAndPrintOvershoots(Task[] tasks) {
        Arrays.sort(tasks);

        int currentTime = 0;
        int maxOvershoot = 0;

        for (Task task : tasks) {
            currentTime += task.minutes;
            int overshoot = Math.max(0, currentTime - task.deadline);
            maxOvershoot = Math.max(maxOvershoot, overshoot);
        }

        System.out.println("Maximum overshoot for each task when scheduled optimally:");
        System.out.println(maxOvershoot);
    }
}
