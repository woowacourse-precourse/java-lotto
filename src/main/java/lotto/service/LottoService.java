package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.util.RandomNumberGenerator;


public class LottoService {

    private static final int LOTTO_PRICE = 1000;
    private final LottoWinningGradeCalculator lottoWinningGradeCalculator = new LottoWinningGradeCalculator();

    public List<List<Integer>> issueLottoNumberGroup(Integer userPrice) {
        Integer lottoIssueCount = getLottoIssueCount(userPrice);
        List<List<Integer>> userLottoNumberGroup = new ArrayList<>();

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        for (int i = 0; i < lottoIssueCount; i++) {
            userLottoNumberGroup.add(randomNumberGenerator.getRandomLottoNumberGroup());
        }

        return userLottoNumberGroup;
    }

    public List<LottoGrade> getLottoWinningResult(Lotto lotto, User user) {
        List<LottoGrade> lottoWinningResult = new ArrayList<>();

        List<List<Integer>> userLottoNumberGroup = user.getUserLottoNumberGroup();
        for (List<Integer> lottoNumber : userLottoNumberGroup) {
            lottoWinningResult.add(lottoWinningGradeCalculator.getLottoGrade(lottoNumber, lotto));
        }

        return lottoWinningResult;
    }

    private Integer getLottoIssueCount(Integer userPrice) {
        return userPrice / LOTTO_PRICE;
    }
}
