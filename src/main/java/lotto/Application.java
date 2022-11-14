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
        int count = Money.calcmoney();
        List<List<Integer>> numbers = new ArrayList<>();
        RandomNumber.randomNumber(count,numbers);
    }
}
