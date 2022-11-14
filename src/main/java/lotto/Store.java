package lotto;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public void sellLotto() {
    }

    private void validateInputMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    // 로또를 발행한다.
    private Lotto issueLotto() {
        List<Integer> numbers = Lotto.generateRandomNumbers();
        return new Lotto(numbers);
    }

    private void sortLotto(Lotto lotto) {
        lotto.sortAscNumbers();
    }

    private void printLottoInform(List<Lotto> lottos) {
        // 발행한 로또 개수 출력
        int count_lotto = lottos.size();
        System.out.println(count_lotto);

        // 발행한 로또들에 번호 출력
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void checkPrize() {
    }
}