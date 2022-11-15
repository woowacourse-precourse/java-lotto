package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoGrade;
import lotto.domain.LottoResult;

public class LottoResultService {
    private LottoAnswer lottoAnswer;
    private List<Lotto> lottos;
    private final GradeService gradeService;
    private final RankService rankService = new RankService();
    private final LottoResult lottoResult = new LottoResult();
    private List<LottoGrade> lottoGrades;
    private double yield;

    private final double price;
    private int totalWinning;

    public LottoResultService(LottoAnswer lottoAnswer, List<Lotto> lottos, int price) {
        this.lottoAnswer = lottoAnswer;
        this.lottos = lottos;
        this.gradeService = new GradeService(lottoAnswer, lottos);
        this.price = price;
    }

    public void run() {
        createLottoGrades();
        createLottoResult();
        totalWinning = rankService.getTotalWinning();
    }

    public void createLottoGrades() {
        gradeService.run();
        lottoGrades = gradeService.getLottoGrades();
    }

    public void createLottoResult() {
        for (LottoGrade lottoGrade : lottoGrades) {
            int ranking = rankService.getRank(lottoGrade);
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
