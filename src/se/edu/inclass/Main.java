package se.edu.inclass;

import se.edu.inclass.data.DataManager;
import se.edu.inclass.task.Deadline;
import se.edu.inclass.task.Task;
import se.edu.inclass.task.TaskNameComparator;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {

    private TaskNameComparator taskNameComparator;

    public static void main(String[] args) {
        DataManager dm = new DataManager("./data/data.txt");
        ArrayList<Task> tasksData = dm.loadData();

        System.out.println("Printing deadlines");
        printDeadlines(tasksData);

        System.out.println("Total number of deadlines: " + countDeadlines(tasksData));

        printDataUsingString(tasksData);
        printDeadlinesUsingStreams(tasksData);
        System.out.println("print number of deadlines using streams\n"
                + countDeadlinesUsingStreams(tasksData));


    }

    private static int countDeadlines(ArrayList<Task> tasksData) {
        int count = 0;
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                count++;
            }
        }
        return count;
    }

    public static void printData(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            System.out.println(t);
        }
    }

    // added
    public static void printDataUsingString(ArrayList<Task> tasksData) {
        System.out.println("print data using streams");
        tasksData.stream()
                .forEach(System.out::println);
    }

    // added
    public static void printDeadlinesUsingStreams(ArrayList<Task> tasksData) {
        tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .forEach(System.out::println);
    }

    // added
    public static int countDeadlinesUsingStreams(ArrayList<Task> tasksData) {
        int count;
        count = (int) tasksData.stream()
                .filter((t) -> t instanceof Deadline)
                .count();
        return count;
    }

    public static void printDeadlines(ArrayList<Task> tasksData) {
        for (Task t : tasksData) {
            if (t instanceof Deadline) {
                System.out.println(t);
            }
        }
    }
}
