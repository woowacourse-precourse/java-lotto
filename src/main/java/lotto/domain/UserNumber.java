package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserNumber {
    private final int countingNumber = 1000;

    public int inputPrice() {
        int price = Integer.valueOf(Console.readLine());
        return price / countingNumber;
    }

    public List<Integer> generateLotto() {
        List<Integer> lotto = new ArrayList<>();
        while (lotto.size() < 6) {
            int lottonumber = Randoms.pickNumberInRange(1, 45);
            if (!lotto.contains(lottonumber)){
                lotto.add(lottonumber);
            }
        }
        return lotto;
    }

    public void sort(List<Integer> lotto){
        lotto.sort(Comparator.naturalOrder());
    }

    public List<List> addLottos(int lottocount){
        List<List> userlottos = new ArrayList<>();
        for (int i = 0; i < lottocount; i++){
            List<Integer> lotto = generateLotto();
            sort(lotto);
            userlottos.add(lotto);
        }
        return userlottos;
    }

}
