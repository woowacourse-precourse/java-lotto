package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoSeller {
    int money;
    int piece;
    int change;
    private List<Lotto> bundle = new ArrayList<Lotto>();

    LottoSeller() {
    }

    LottoSeller(int money) {
        this.money = money;
        this.piece = money/1000;
        this.change = money%1000;
    }

    LottoSeller(List<Lotto> bundle) {
        this.bundle = bundle;
    }

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

    void showBundle() {
        for (int index = 0; index < bundle.size(); index++) {
            List<Lotto> bundleCopy = new ArrayList<Lotto>(bundle);

            bundleCopy.get(index).showLotto();;
        }
    }

    void giveChange() {
        System.out.println("잔돈은 " + change + "원입니다.");
    }

    List<Lotto> get() {
        return this.bundle;
    }
}
