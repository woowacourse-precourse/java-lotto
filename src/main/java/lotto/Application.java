package lotto;

import lotto.view.Print;

import java.util.ArrayList;
import java.util.List;

import static lotto.Player.numberOfLottos;
import static lotto.Player.winNumbers;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<>();
        Print.requestMoneyMessage();
        Player.getMoney();
        Print.howmanyLottos(numberOfLottos);
        Print.requestWinNumbers();
        Player.getWinNumbers();
        System.out.println(winNumbers);

        Print.requestBonusNumber();
    }
}
