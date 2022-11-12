package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LottoWalletMaker {

    public int payedMoney = 0;
    LottoMaker lottoMaker = new LottoMaker();

    public List<Lotto> make() {
        int numberOfLottoToMake = getNumberOfLottoToMake();
        List<Lotto> tmp = new ArrayList<>();

        for (int i = 0; i < numberOfLottoToMake; i++) {
            List<Integer> numbers = lottoMaker.make();
            Lotto newLotto = new Lotto(numbers);
            tmp.add(newLotto);
        }
        return tmp;
    }


    public void printAllLotto(List<Lotto> wallet) {
        for (Lotto lotto : wallet) {
            List<Integer> numbers = lotto.getNumbers();
            Collections.sort(numbers);
            System.out.println(numbers);
        }
    }

    private int getNumberOfLottoToMake() {

        getInputOfMoney();

        int howManyLotto = payedMoney / Lotto.PRICE;

        System.out.println(howManyLotto + "개를 구매했습니다.");

        return howManyLotto;
    }

    private void getInputOfMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        String moneyAsString = Console.readLine();

        payedMoney = Integer.parseInt(moneyAsString);

        validate();
    }

    private void validate() throws IllegalArgumentException{
        if (payedMoney % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원으로 나누어 떨어져야 합니다.");
        }
    }
}
