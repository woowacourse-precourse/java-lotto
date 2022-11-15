package lotto;

import lotto.job.JobLauncher;
import lotto.job.JobType;

public class Application {
    public static void main(String[] args) {
        JobLauncher.addSchedule(
                JobType.BUY_LOTTO,
                JobType.DECIDE_WINNER,
                JobType.DECIDE_BONUS,
                JobType.ANNOUNCE_RESULT);

        JobLauncher.run();
    }
}
