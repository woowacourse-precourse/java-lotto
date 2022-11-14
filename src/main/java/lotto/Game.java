package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {

    enum RANK {
        NOTHING("0"),FIVE("5000"), FOUR("50000"), THREE("1500000"),
        TWO("30000000"), ONE("2000000000");

        final private String prize;
        public String getPrize(){
            return prize;
        }
        private RANK(String prize){
            this.prize = prize;
        }
    }

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
