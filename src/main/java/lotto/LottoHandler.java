package lotto;

import type.LottoGrade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.LottoMachine.*;

public class LottoHandler {

    public static void handleLotto(String inputAmount, String inputNumbers, String bonusNumber) {
        Integer purchaseAmount = Integer.valueOf(inputAmount);
        List<Integer> winningNumbers = getWinningNumbers(inputNumbers);

        List<List<Integer>> multipleLottoNumbers = createMultipleLottoNumbers(purchaseAmount);
        List<Lotto> lotteries = multipleLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
        Map<LottoGrade, Integer> resultOfLotto = getResultOfLotto(bonusNumber, winningNumbers, lotteries);

        // TODO : View에 대한 로직 추가
    }

    private static Map<LottoGrade, Integer> getResultOfLotto(String bonusNumber, List<Integer> winningNumbers, List<Lotto> lotteries) {
        Map<LottoGrade, Integer> lottoGradeInfo = new HashMap<>();
        for (Lotto lotto : lotteries) {
            Integer numberOfMatches = lotto.countNumbersIncluded(winningNumbers);
            Boolean containsBonusNumber = lotto.containsBonusNumber(Integer.valueOf(bonusNumber));
            LottoGrade lottoGrade = lotto.getLottoGrade(numberOfMatches, containsBonusNumber);
            lottoGradeInfo.merge(lottoGrade, 1, Integer::sum);
        }
        return lottoGradeInfo;
    }

    private static List<Integer> getWinningNumbers(String inputNumber) {
        // TODO : 입력 받은 당첨 번호를 리스트로 변환하기
        return new ArrayList<>();
    }
}
