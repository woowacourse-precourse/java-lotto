package lotto.ui;

import java.util.Collections;
import java.util.List;

import lotto.domain.Lotto;

public class Ouput {
    public void notifyPurchasedLottoTable(List<Lotto> lottoTable) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTable.size());
        for (int i = 0; i < lottoTable.size(); i++) {
            List<Integer> numbers = lottoTable.get(i).getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    public void notifyHowMuchInput(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void notifyWinningLottoNumbersInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void notifyBonusNumberInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
