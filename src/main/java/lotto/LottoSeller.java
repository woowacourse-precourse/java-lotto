package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoSeller {
    int money;
    int piece;
    int change;
    List<Lotto> bundle;

    void takeMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money = Integer.parseInt(Console.readLine());
        piece = money/1000;
        change = money%1000;
    }

    void makeLottoBundle() {
        for (int count = 1; count <= piece; count++) {
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(randomNumber);

            bundle.add(lotto);
        }
    }
}
