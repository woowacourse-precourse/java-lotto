package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {

    void run(){
        Input input = new Input();
        int playerMoney = input.inputMoney();
        Money money = new Money(playerMoney);

        int numberOfLottos = money.numberOfPurchase();
        List<Lotto> purchasedLottos = lottos(numberOfLottos);
    }

    List<Lotto> lottos(int numberOfLotto){
        List<Lotto> purchasedLotto = new ArrayList<>();
        for(int loop = 0; loop < numberOfLotto; loop++){
            Input input = new Input();
            List<Integer> numbers = input.randomLottoNumber();
            Lotto lotto = new Lotto(numbers);
            purchasedLotto.add(lotto);
        }
        return purchasedLotto;
    }
}
