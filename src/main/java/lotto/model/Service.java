package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.constant.Constant;
import lotto.util.Convertor;

/*
 * 로또 게임 로직을 담당하는 객체
 * : 로또 당첨 결과 리턴
 */

public class Service {

    private final int lottoAmount;
    private final List<List<Integer>> lottoNumbers;
    private final List<Integer> playerLottoNumbers;
    private final int playerBonusNumber;

    public Service(int lottoAmount, List<List<Integer>> lottoNumbers, List<Integer> playerLottoNumbers,
                   int playerBonusNumber) {
        this.lottoAmount = lottoAmount;
        this.lottoNumbers = lottoNumbers;
        this.playerLottoNumbers = playerLottoNumbers;
        this.playerBonusNumber = playerBonusNumber;
    }

    public int[] getLottoResult() {
        int[] result = new int[WinnerInfo.values().length];
        Arrays.fill(result, 0);

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> lotto = Convertor.ExtractList(lottoNumbers, i);
            int ordinal = checkRank(lotto, playerLottoNumbers, playerBonusNumber);

            if (ordinal == -1) { // 승리 조건과 일치하는 것이 없을 때
                continue;
            }
            result[ordinal]++;
        }
        return result;
    }

    private int checkRank(List<Integer> lottoNumbers, List<Integer> playerLottoNumbers, int playerBonusNumber) {
        int matchedCount = getMatchedCount(lottoNumbers, playerLottoNumbers);

        for (int i = 0; i < WinnerInfo.values().length; i++) {
            if (matchedCount == Constant.CHECK_BONUS_COUNT) {
                return checkBonusNumber(lottoNumbers, playerLottoNumbers, playerBonusNumber);
            }

            if (matchedCount == WinnerInfo.values()[i].getWinningCondition()) {
                return WinnerInfo.values()[i].ordinal();
            }
        }
        return -1; // Rank 승리 조건과 일치하는 것이 없으면 -1 반환
    }

    private int checkBonusNumber(List<Integer> lottoNumbers, List<Integer> playerLottoNumbers, int playerBonusNumber) {
        List<Integer> checkBonusNumber = new ArrayList<>(lottoNumbers);
        checkBonusNumber.removeAll(playerLottoNumbers);

        if (checkBonusNumber.get(0) == playerBonusNumber) {
            return WinnerInfo.RANK2.ordinal();
        }
        return WinnerInfo.RANK3.ordinal();
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
