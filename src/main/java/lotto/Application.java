package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoStart();

        int numberLotto = valueMoney();

        if (numberLotto > 0) {

            countLotto(numberLotto);

        }

        HashSet<List> listLotto = randomLotto(numberLotto);

        outputNumber(listLotto);

    }

    public static void lottoStart() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    public static int valueMoney() {
        int money;

        try {

            money = Integer.parseInt(Console.readLine());


        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자 입력!");
            return 0;
        }
        validMoney(money);

        return buyLotto(money);
    }

    public static int buyLotto(int money) {

        return money / 1000;
    }

    public static void validMoney(int money) {
        if (money % 1000 > 0) {

            System.out.println("[ERROR] 1,000단위의 수를 입력하세요");

            throw new IllegalArgumentException("[ERROR] 1,000단위의 수를 입력하세요");
        }

    }

    public static void countLotto(int cntLotto) {
        System.out.println(cntLotto + "개를 구매했습니다.");
    }

    public static HashSet<List> randomLotto(int numLotto) {
        HashSet<List> numberLotto = new HashSet<>();
        for (int i = 0; i < numLotto; i++) {
            List <Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));

            Collections.sort(numbers);

            numberLotto.add(numbers);
        }

        return numberLotto;
    }
    public static void outputNumber(HashSet<List> listLotto) {
        for (List i : listLotto) {
            System.out.println(i);
        }
    }
}



