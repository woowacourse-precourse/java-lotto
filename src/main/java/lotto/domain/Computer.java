package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Computer {
    public List<Integer> createLottoNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // 오름차순 정렬
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }

    public List<List<Integer>> createLottos(int money){
        int times = money / 1000;

        List<List<Integer>> lottos = new ArrayList<>();

        while(times>0){
            List<Integer> lotto = new Lotto(createLottoNumbers()).getNumbers();
            lottos.add(lotto);
            times -= 1;
        }

        return lottos;
    }
}
