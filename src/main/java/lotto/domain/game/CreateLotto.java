package lotto.domain.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class CreateLotto {
    private final List<Integer> lotto;

    public CreateLotto(){
        lotto = generateLotto();
        sortNatural();
    }

    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void sortNatural(){
        lotto.sort(Comparator.naturalOrder());
    }

    public List<Integer> getLotto(){
        return lotto;
    }
}
