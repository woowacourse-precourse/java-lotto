package lotto.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class PurchaseLotto {
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = readLine();
        int money = Integer.valueOf(moneyInput);
        countLotto(money);
        return money;
    }

    private static int countLotto(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해 주세요.");
        }
        return money / 1000;
    }

    public List<Integer> myLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
    public void myLotto(){
        int money = inputMoney();
        for (int count=0; count < countLotto(money); count++){
            System.out.println(myLottoNumber());
        }
    }

}
