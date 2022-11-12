package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UI {
    public String getInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public void printLottoNumber(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
