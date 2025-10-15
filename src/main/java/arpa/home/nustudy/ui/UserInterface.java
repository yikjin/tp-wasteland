package arpa.home.nustudy.ui;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import arpa.home.nustudy.course.Course;
import arpa.home.nustudy.course.CourseManager;

public class UserInterface {
    private static final String LINE_BREAK = "____________________________________________________________";
    private static final Scanner INPUT_SCANNER = new Scanner(System.in, StandardCharsets.UTF_8);

    /**
     * Prints a partition line for visual separation
     */
    public static void printLineBreak() {
        System.out.println(LINE_BREAK);
    }

    /**
     * Returns the user's command.
     *
     * @return The trimmed user input command
     */
    public static String readInput() {
        System.out.println();

        if (INPUT_SCANNER.hasNextLine()) {
            final String line = INPUT_SCANNER.nextLine().trim();

            if (!line.isEmpty()) {
                return line;
            }
        }

        return null;
    }

    /**
     * Prints a success message when a course is added
     *
     * @param course The course that was added
     */
    public static void printCourseAdded(final Course course) {
        System.out.printf("Good Job! I have added %s", course);
        System.out.println();
    }

    /**
     * Prints a success message when a course is deleted
     *
     * @param course The course that was deleted
     */
    public static void printCourseDeleted(final Course course) {
        System.out.printf("NOTE: We have deleted %s from Course Book", course);
        System.out.println();
    }

    /**
     * Print all courses in the course manager
     *
     * @param courses The course manager containing courses
     */
    public static void printCourseList(final CourseManager courses) {
        System.out.println("List of courses:");

        int idx = 1;

        for (final Course course : courses.getCourses()) {
            System.out.printf("%d. %s", idx, course);
            System.out.println();
            idx++;
        }

        if (idx == 1) {
            System.out.println("No courses added yet.");
        }
    }

    /**
     * Prints a success message when a course study session is added
     *
     * @param course The course that was added
     * @param hours  The hours that was spent of a study session
     */
    public static void printStudySessionAdded(final Course course, final int hours) {
        System.out.printf("Good Job! You have studied %d hours for %s", hours, course.getCourseName());
        System.out.println();
    }

    /**
     * Print all session hours for a specific course in the course manager
     *
     * @param course The course to print session hours for
     * @param hours  List of session hours for the course
     */
    public static void printCourseHoursPerSession(final Course course, final Iterable<Integer> hours) {
        System.out.println("List of study sessions");

        int idx = 1;

        for (final int perSessionHours : hours) {
            System.out.printf("%d. %s - %d hours", idx, course, perSessionHours);
            System.out.println();
            idx++;
        }

        if (idx == 1) {
            System.out.printf("No sessions for course %s", course);
            System.out.println();
        }
    }
}
