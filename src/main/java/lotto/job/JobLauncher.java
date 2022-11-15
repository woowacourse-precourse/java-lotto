package lotto.job;

import java.util.ArrayList;
import java.util.List;
import lotto.log.Log;

public class JobLauncher {
    private static final List<JobType> jobsTodo = new ArrayList<>();

    private JobLauncher() {

    }

    public static void addSchedule(JobType... jobs) {
        for (JobType i : jobs) {
            jobsTodo.add(i);
        }
    }

    public static void run() {
        try {
            for (JobType i : jobsTodo) {
                i.run();
            }
        } catch (Exception e) {
            Log.log.error(e);
        }

    }

}

