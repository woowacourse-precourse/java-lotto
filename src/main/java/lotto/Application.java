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

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> createdRandomNumbers = RandomNumber.create();
            Lotto lotto = new Lotto(createdRandomNumbers);
            List<Integer> getRandomNumbers = lotto.getNumbers();
            Print.getLottos(getRandomNumbers);
        }





        //Lotto.printLottos(lotto);

        Print.requestWinNumbers();
        Player.getWinNumbers();
        Print.winNumbers();
        Print.requestBonusNumber();
        Player.getBonusNumber();
        Print.bonusNumber();


    }
}
