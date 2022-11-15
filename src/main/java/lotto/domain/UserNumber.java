package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserNumber {
    private static int countingNumber = 1000;

    public static int inputPrice() {
        int price;
        try {
            price = Integer.valueOf(Console.readLine());
        } catch(Exception e){
            throw new IllegalArgumentException(Print.priceError());
        }
        return price / countingNumber;
    }

    public List<Integer> generateLotto() {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lotto;
    }

    public void sort(List<Integer> lotto) {
        lotto.sort(Comparator.naturalOrder());
    }

    public List<List> addLottos(int lottocount) {
        List<List> userlottos = new ArrayList<>();
        for (int i = 0; i < lottocount; i++) {
            List<Integer> lotto = generateLotto();
            sort(lotto);
            userlottos.add(lotto);
        }
        return userlottos;
    }

}
