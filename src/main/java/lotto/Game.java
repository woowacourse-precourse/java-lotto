package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
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
