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
                if (isSecond(winningLotto, userLotto)) return SECOND;
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
     * 사용자가 구매한 모든 복권에 대해 당첨 여부를 판단하고, 총 결과를 반환합니다.
     * @param winningLotto 당첨 복권
     * @param userLotto 사용자가 구매한 모든 복권
     * @return 1등부터 5등까지 몇 번 했는지, 총 당첨금은 얼만인지를 저장하는 클래스
     */
    public static WinningLotto judgeAllLotto(LottoNumber winningLotto, List<LottoNumber> userLotto) {
        WinningLotto winningResult = new WinningLotto();
        for (LottoNumber lotto : userLotto) {
            winningResult.updateResult(judgeWinning(winningLotto, lotto));
        }
        return winningResult;
    }

    /**
     * 당첨 로또와 사용자 로또 간 몇 개의 숫자가 일치하는지를 반환합니다.
     * @param winningLotto 당첨 로또의 일반 번호
     * @param userLotto 사용자 로또의 일반 번호
     * @return 몇개의 일반 번호가 일치하는지
     */
    private static int duplicateNumber(List<Integer> winningLotto, List<Integer> userLotto) {
        int winningNumber = 0;
        userLotto = userLotto.subList(0, 6);
        for (Integer lottoNumber : userLotto) {
            if (winningLotto.contains(lottoNumber)) {
                winningNumber++;
            }
        }
        return winningNumber;
    }

    /**
     * 2등인지 여부를 판단합니다.
     * @param winningLotto 당첨 로또
     * @param userLotto 사용자의 로또
     * @return 2등인지 여부
     */
    private static boolean isSecond(LottoNumber winningLotto, LottoNumber userLotto) {
        for (Integer number : userLotto.getGeneralLottoNumber().getNumbers()) {
            if (!winningLotto.getGeneralLottoNumber().getNumbers().contains(number) &&
                    winningLotto.getBonusLottoNumber() == number) {
                return true;
            }
        }
        return false;
    }

}
