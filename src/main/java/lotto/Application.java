package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static <integer> void main(String[] args) {

        Message.Start();

        int money = inputNum();

        validMoney(money);

        int numberLotto = money/1000;

        if (numberLotto > 0) {

            Message.Count(numberLotto);

        }

        HashSet<List> listLotto = randomLotto(numberLotto);

        Message.listNumber(listLotto);

        Message.win();

        List<Integer> inputNum = Input.number();

        Lotto lotto = new Lotto(inputNum);

        Message.bonus();

        int bonusNum = inputNum();


        HashMap<Integer, Integer> resultLotto = Result.resultLotto(inputNum, listLotto, bonusNum);

        Message.lotto(resultLotto);

        double percentage = Result.resultPercentage(resultLotto, money);

        Message.percentage(percentage);

    }

    public static int inputNum() {
        int num;

        try {

            num = Integer.parseInt(Console.readLine());
            System.out.println("");

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자 입력!");
            return 0;
        }

        return num;
    }

    public static void validMoney(int money) {
        if (money % 1000 > 0) {

            System.out.println("[ERROR] 1,000단위의 수를 입력하세요");

            throw new IllegalArgumentException("[ERROR] 1,000단위의 수를 입력하세요");
        }
    }


    public static HashSet<List> randomLotto(int numLotto) {
        HashSet<List> numberLotto = new HashSet<>();
        for (int i = 0; i < numLotto; i++) {
            List<Integer> numbers = new ArrayList<>(
                    Randoms.pickUniqueNumbersInRange(1, 45, 6));

            Collections.sort(numbers);

            numberLotto.add(numbers);
        }

        return numberLotto;
    }




}
