package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoUtil {

    public static int numberOfLottoAvailableCount(int userMoney) {
        return userMoney/1000;
    }

    public static List<Lotto> getLottos(int userLottoCnt) {

        PrintUtil.getLottos(userLottoCnt);

        List<Lotto> userLottos = new ArrayList<>();

        for(int i = 0 ; i < userLottoCnt ; i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(lottoNumbers);
            userLottos.add(new Lotto(lottoNumbers));
        }

        PrintUtil.userLottosPrint(userLottos);

        return userLottos;
    }

    public static void checkWin(List<Lotto> userLottos, List<Integer> winNumber) {
        List<Integer> winStatistics = new ArrayList<>();

        for(Lotto lotto : userLottos){
            int cnt = checkWin(lotto, winNumber);
            winStatistics.add(cnt);
        }
    }

    public static int checkWin(Lotto lotto, List<Integer> winNumber) {
        int cnt = 0;

        for(int number : lotto.getNumbers()){
            if(winNumber.contains(number)){
                cnt++;
            }
        }
        return cnt;
    }
}
