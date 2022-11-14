package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ui {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String returnInputValue(String message) {
        System.out.println(message);
        String input = Console.readLine();
        return input;
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> tempLotto = new ArrayList<>(lotto.getNumbers());
            Collections.sort(tempLotto);
            System.out.println(tempLotto);
        }
    }
}
