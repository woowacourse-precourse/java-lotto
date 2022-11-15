package lotto.job.types;

import lotto.job.Job;
import lotto.printer.Printer;
import lotto.publisher.LottoStorage;
import lotto.publisher.WinnerLotto;
import lotto.score.Score;
import lotto.score.ScoreChecker;

public class ResultAnnouncer implements Job {

    private final Printer printer;

    public ResultAnnouncer(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void doJob() {
        ScoreChecker checker = new ScoreChecker();
        Score score = checker.getMyScore(LottoStorage.getAllLottos(), WinnerLotto.getInstance());

        printer.print(score);
    }
}
