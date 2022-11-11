package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Computer {
    // 2주차 피드백 반영
    static final int STRAT_RANGE = 1;
    static final int END_RANGE = 45;
    static final int LOTTO_NUMBER_LENGTH = 6;
    static final int LOTTO_CHARGE = 1000;

    public List<Integer> createLottoNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(STRAT_RANGE, END_RANGE, LOTTO_NUMBER_LENGTH);
        // 오름차순 정렬
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }

    public List<List<Integer>> createLottos(int money){
        int times = money / LOTTO_CHARGE;

        List<List<Integer>> lottos = new ArrayList<>();

        while(times>0){
            List<Integer> lotto = new Lotto(createLottoNumbers()).getNumbers();
            lottos.add(lotto);
            times -= 1;
        }

        return lottos;
    }
}
