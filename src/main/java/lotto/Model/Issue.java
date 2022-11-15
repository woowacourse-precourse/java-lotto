package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Issue {
    private final int lottoCount;
    private final List<List<Integer>> lottoes = new ArrayList<>();

    public Issue(int lottoCount){
        this.lottoCount = lottoCount;
        createLottoList();
    }

    void createLottoList(){
        for(int i = 0; i<lottoCount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            lottoes.add(numbers);
        }
    }

    public List<List<Integer>> getLottoes(){
        return this.lottoes;
    }
}
