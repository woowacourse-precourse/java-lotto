package lotto.controller;

import java.util.List;
import lotto.domain.GradingMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoGrade;
import lotto.domain.LottoResult;
import lotto.domain.RankingMachine;

public class LottoResultController {
    private LottoAnswer lottoAnswer;
    private List<Lotto> lottos;
    private GradingMachine gradingMachine;
    private RankingMachine rankingMachine = new RankingMachine();
    private LottoResult lottoResult = new LottoResult();
    private List<LottoGrade> lottoGrades;
    private double yield;

    private final double price;
    private int totalWinning;

    public LottoResultController(LottoAnswer lottoAnswer, List<Lotto> lottos, int price) {
        this.lottoAnswer = lottoAnswer;
        this.lottos = lottos;
        this.gradingMachine = new GradingMachine(lottoAnswer, lottos);
        this.price = price;
    }

    public void run() {
        createLottoGrades();
        createLottoResult();
        totalWinning = rankingMachine.getTotalWinning();
    }

    public void createLottoGrades() {
        gradingMachine.run();
        lottoGrades = gradingMachine.getLottoGrades();
    }

    public void createLottoResult() {
        for (LottoGrade lottoGrade : lottoGrades) {
            int ranking = rankingMachine.getRank(lottoGrade);
            lottoResult.putRanking(ranking);
        }
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public double getYield() {
        return calculateYield();
    }

    private double calculateYield() {
        return (totalWinning / price) * 100;
    }

}
