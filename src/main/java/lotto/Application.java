package lotto;

import lotto.view.Print;

import java.util.ArrayList;
import java.util.List;

import static lotto.Player.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<>();
        Print.requestMoneyMessage();
        Player.getMoney();
        Print.howmanyLottos(numberOfLottos);
        Print.requestWinNumbers();
        Player.getWinNumbers();
        Print.winNumbers();
        Print.requestBonusNumber();
        Player.getBonusNumber();
        Print.bonusNumber();
        Lotto.getRandomNumbers(numbers);
    }
}
