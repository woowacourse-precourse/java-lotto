package lotto.datamodel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class MakeLottoNumber {
    private final int lottoCount;

    public MakeLottoNumber(int lottoCount){
        this.lottoCount = lottoCount;
    }

    public List<List<Integer>> makeNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<List<Integer>>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            ArrayList<Integer>changeNumbers = new ArrayList<>(numbers);
            changeNumbers.sort(Comparator.naturalOrder());
            lottoNumbers.add(changeNumbers);
        }
        return lottoNumbers;
    }
}
