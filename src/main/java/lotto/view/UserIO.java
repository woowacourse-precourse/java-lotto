package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// UI 로직
public class UserIO {

    private List<Lotto> userLottoList;

    public UserIO() {
        userLottoList = new ArrayList<>();
    }

    // 구입 금액 입력
    public int moneySpent() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        int money = Integer.valueOf(input);

        if (money % 1000 != 0) {
            System.out.println("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return money;
    }

    // 로또 구입내역
    public List<Lotto> purchaseLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            this.userLottoList.add(lotto);
        }
        return this.userLottoList;
    }

    // 구입한 로또의 수량
    public int purchasedAmount(int budget) {
        int amount = budget / 1000;
        System.out.println(amount + "개를 구매했습니다.");
        return amount;
    }

    // 사용자가 구입한 로또번호 출력
    public void printLotto() {
        for (Lotto lotto : userLottoList) {
            lotto.printNumbers();
        }
        System.out.println();
    }

    public List<Lotto> getUserLottoList() {
        return this.userLottoList;
    }
}
