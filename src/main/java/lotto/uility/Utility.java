package lotto.uility;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.vo.LottoWinNumberInfo;

public class Utility {

    public static int ConvertMoneyStringToInteger(String money) {
        return Integer.parseInt(money);
    }

    public static int compareLottoNumber(List<Integer> winNumber, LottoWinNumberInfo lottoWinNumberInfo) {
        int result = 0;
        for(int i : winNumber) {
            for(int j : lottoWinNumberInfo.getLottoWinNumbers()) {
                if(i == j) result++;
            }
        }
        return result;
    }

    public static boolean checkBounsNumber(List<Integer> winNumber, LottoWinNumberInfo lottoWinNumberInfo) {
        return winNumber.contains(lottoWinNumberInfo.getBonusNumber());
    }

    public static String checkLottoRank(List<Integer> winNumber, LottoWinNumberInfo lottoWinNumberInfo) {
        return LottoRank.getRank(compareLottoNumber(winNumber, lottoWinNumberInfo),
                checkBounsNumber(winNumber, lottoWinNumberInfo))
            .toString();
    }
}
