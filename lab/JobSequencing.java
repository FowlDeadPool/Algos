import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
    static class Job {
        int id;
        int profit;
        int deadline;

        public Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }
    static void sortJobsByProfit(Job[] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(job -> -job.profit));
    }
    static int findMaxWeight(Job[] jobs) {
        int maxWeight = Integer.MIN_VALUE;
        for (Job job : jobs) {
            maxWeight = Math.max(maxWeight, job.deadline);
        }
        return maxWeight;
    }
    static void sequenceJobs(Job[] jobs, int[] array) {
        sortJobsByProfit(jobs);
        for (Job job : jobs) {
            int deadline = job.deadline;
            while (deadline > 0 && array[deadline - 1] != -1) {
                deadline--;
            }
            if (deadline > 0) {
                array[deadline - 1] = job.id;
            }
        }
    }
    

    public static void main(String[] args) {
        // Create a data structure to store jobs
        Job[] jobs = new Job[5];
        jobs[0] = new Job(1, 100, 3);
        jobs[1] = new Job(2, 120, 2);
        jobs[2] = new Job(3, 80, 2);
        jobs[3] = new Job(4, 60, 3);
        jobs[4] = new Job(5, 50, 1);

        int maxWeight = findMaxWeight(jobs);
        int[] array = new int[maxWeight];
        Arrays.fill(array, -1);
        sequenceJobs(jobs, array);
        
        // Print the job sequence
        System.out.println("Job Sequence:");
        for (int jobId : array) {
            if (jobId != -1) {
                System.out.print(jobId + " ");
            }
        }
        
       
        
    }
}