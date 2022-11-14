package lotto;

import lotto.domain.Player;
import lotto.domain.RandomNumber;
import lotto.view.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static lotto.domain.Player.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<>();
        Print.requestMoneyMessage();
        Player.getMoney();
        Print.howmanyLottos(numberOfLottos);

        Compare.randomLottos = new HashMap<>();
        Compare.userList = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> createdRandomNumbers = RandomNumber.create();
            Lotto lotto = new Lotto(createdRandomNumbers);
            List<Integer> getRandomNumbers = lotto.getNumbers();
            Compare.randomLottos.put(i,getRandomNumbers);
            Print.getLottos(getRandomNumbers);
        }

        Print.requestWinNumbers();
        List<Integer> correctNumbers = Player.getWinNumbers();
        for (int i = 0; i < correctNumbers.size(); i++) {
            Compare.userList.add(correctNumbers.get(i));
        }
        Print.winNumbers();
        Print.requestBonusNumber();
        Player.getBonusNumber();
        Compare.bonusNumber = bonusNumber;
        Print.bonusNumber();

        Compare.numbers();


    }
}
