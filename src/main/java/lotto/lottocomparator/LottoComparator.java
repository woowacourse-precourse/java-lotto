package lotto.lottocomparator;

import lotto.lottonumber.LottoNumber;
import java.util.List;

import static lotto.lottocomparator.WinningRank.*;

/**
 * 당첨 로또와 구매한 로또의 당첨 여부를 판단하는 클래스입니다.
 */
public class LottoComparator {
    /**
     * 당첨 로또와 사용자의 로또를 비교해서 몇 등인지를 반화합니다.
     * @param winningLotto 당첨 로또
     * @param userLotto 사용자의 로또
     * @return 몇 등인지
     */
    public static WinningRank judgeWinning(LottoNumber winningLotto, LottoNumber userLotto) {
        int winningNumber = duplicateNumber(winningLotto.getGeneralLottoNumber().getNumbers(),
                userLotto.getGeneralLottoNumber().getNumbers());
        switch (winningNumber) {
            case 6:
                return FIRST;
            case 5:
                if (winningLotto.getBonusLottoNumber() == userLotto.getBonusLottoNumber()) return SECOND;
                return THIRD;
            case 4:
                return FOURTH;
            case 3:
                return FIFTH;
            default:
                return LOSING_TICKET;
        }
    }

    /**
     * 당첨 로또와 사용자 로또 간 몇 개의 숫자가 일치하는지를 반환합니다.
     * @param winningLotto 당첨 로또의 일반 번호
     * @param userLotto 사용자 로또의 일반 번호
     * @return 몇개의 일반 번호가 일치하는지
     */
    private static int duplicateNumber(List<Integer> winningLotto, List<Integer> userLotto) {
        int winningNumber = 0;
        for (Integer lottoNumber : userLotto) {
            if (winningLotto.contains(lottoNumber)) {
                winningNumber++;
            }
        }
        return winningNumber;
    }

}
