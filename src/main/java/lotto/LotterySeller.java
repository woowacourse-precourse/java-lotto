package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotterySeller {
    int numberOfLottoIssued = 0;
    List<Lotto> soldLotto = new ArrayList<>();

    public void sellLotto() {
        receiveMoney();
        issueLotto();
        printLotto();
    }

    public void receiveMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();

        int money = Integer.parseInt(userInput);
        if (money % 1000 != 0) {
            System.out.println("거스름돈: " + money % 1000 + "원");
        }
        numberOfLottoIssued += money / 1000;
    }

    public void issueLotto() {
        while (soldLotto.size() != numberOfLottoIssued) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            soldLotto.add(lotto);
        }
    }

    public void printLotto() {
        System.out.println(numberOfLottoIssued + "개를 구매했습니다.");
        for (int i = 0; i < numberOfLottoIssued; i++) {
            soldLotto.get(i).printNumber();
        }
        System.out.println();
    }
}
