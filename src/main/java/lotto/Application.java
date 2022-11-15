package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int userMoney = Util.inputUserMoney();

        int userLottoCnt = LottoUtil.numberOfLottoAvailableCount(userMoney);

        List<Lotto> userLottos = LottoUtil.getLottos(userLottoCnt);

        for(Lotto l : userLottos){
            for(Integer i : l.getNumbers()){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
