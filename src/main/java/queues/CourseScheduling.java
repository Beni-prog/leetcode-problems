package queues;

import java.util.*;

public class CourseScheduling {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Step 2: Initialize inDegrees array
        int[] inDegrees = new int[numCourses];

        // Step 3: Build adjacency list and inDegrees array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjacencyList.get(prerequisiteCourse).add(course);
            inDegrees[course]++;
        }

        // Step 4: Enqueue courses for which you don't need prerequisite
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 5: Initialize order array
        int[] order = new int[numCourses];
        int index = 0;

        // Step 6 and 7: Perform BFS
        while (!queue.isEmpty()) {
            //put in the queue the courses you don't need prerequisite for
            int course = queue.poll();
            order[index++] = course;

            // Step 7: Decrement inDegrees and enqueue adjacent courses with 0 incoming edges
            //aka put in the queue the next courses with least number of prerequisites
            for (int adjacentCourse : adjacencyList.get(course)) {
                inDegrees[adjacentCourse]--;
                if (inDegrees[adjacentCourse] == 0) {
                    queue.offer(adjacentCourse);
                }
            }
        }

        // Step 9: Check if all courses are taken
        if (index == numCourses) {
            return order;
        } else {
            return new int[0]; // Return empty array if it's impossible to finish all courses
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
