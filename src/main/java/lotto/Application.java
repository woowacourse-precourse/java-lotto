package lotto;

import lotto.Money;
import lotto.Lotto;
import lotto.RandomNumber;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {
        List<List<Integer>> numbers = new ArrayList<>();
        int count = Money.calcmoney();
        RandomNumber.randomNumber(count, numbers);
        List<Integer> lottoNumber = new ArrayList<>();
        Lotto.lottoNumber(lottoNumber);
        Lotto lotto = new Lotto(lottoNumber);
        Money.calcPrize(numbers, lottoNumber, Lotto.bonusNumber());

    }
}
