package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Lotto[] lottos = new Lotto[numberOfLotto()];
        
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = new Lotto(makeRandomNumbers());
        }


    }

    private static int numberOfLotto() {
        String inputStringMoney = Console.readLine();
        int money = Integer.parseInt(inputStringMoney);
        if(money < 0 || money%1000 != 0) {
            throw new IllegalArgumentException();
        }
        return money/1000;
    }

    private static List<Integer> makeRandomNumbers() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 6) {
            int randomNumber = Randoms.pickNumberInRange(1, 45);
            if (!numberList.contains(randomNumber)) {
                numberList.add(randomNumber);
            }
        }
        return numberList;
    }
}
