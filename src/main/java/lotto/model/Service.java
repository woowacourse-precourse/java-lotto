package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.util.Convertor;

/*
 * 로또 게임 로직을 담당하는 객체
 * : 로또 당첨 결과 리턴
 */

public class Service {

    private final int lottoAmount;
    private final List<List<Integer>> lottoNumbers;
    private final List<Integer> winningLottoNumbers;
    private final int winningBonusNumber;

    public Service(int lottoAmount, List<List<Integer>> lottoNumbers, List<Integer> winningLottoNumbers,
                   int playerBonusNumber) {
        this.lottoAmount = lottoAmount;
        this.lottoNumbers = lottoNumbers;
        this.winningLottoNumbers = winningLottoNumbers;
        this.winningBonusNumber = playerBonusNumber;
    }

    public int[] getLottoResult() {
        int[] result = new int[WinnerInfo.values().length];
        Arrays.fill(result, 0);

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lotto = Convertor.ExtractList(lottoNumbers, i);
            int ordinal = checkRank(lotto, winningLottoNumbers, winningBonusNumber);

            if (ordinal == WinnerInfo.hasNoRank()) {
                continue;
            }
            result[ordinal]++;
        }
        return result;
    }

    private int checkRank(List<Integer> lottoNumbers, List<Integer> playerLottoNumbers, int playerBonusNumber) {
        int matchedCount = getMatchedCount(lottoNumbers, playerLottoNumbers);

        if (matchedCount == WinnerInfo.RANK2.getWinningCondition()) {
            boolean winBonusNumber = winBonusNumber(lottoNumbers, playerLottoNumbers, playerBonusNumber);
            return WinnerInfo.checkRank2(winBonusNumber);
        }
        return WinnerInfo.getRank(matchedCount);
    }

    private boolean winBonusNumber(List<Integer> lottoNumbers, List<Integer> playerLottoNumbers,
                                   int playerBonusNumber) {
        List<Integer> checkBonusNumber = new ArrayList<>(lottoNumbers);
        checkBonusNumber.removeAll(playerLottoNumbers);

        return checkBonusNumber.get(0) == playerBonusNumber;
    }

    private int getMatchedCount(List<Integer> lottoNumbers, List<Integer> playerLottoNumbers) {
        List<Integer> intersection = new ArrayList<>(playerLottoNumbers);
        intersection.retainAll(lottoNumbers);

        if (intersection.isEmpty()) {
            return 0;
        }
        return intersection.size();
    }

}
