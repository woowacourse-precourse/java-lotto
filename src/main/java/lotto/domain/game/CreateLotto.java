package lotto.domain.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CreateLotto {
    private List<Integer> lotto;

    public CreateLotto(){
        List<Integer> temLotto = generateLotto();
        lotto = new ArrayList<>(temLotto);
        sortNatural();
    }

    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
    }

    public void sortNatural(){
        lotto.sort(Comparator.naturalOrder());
    }

    public List<Integer> getLotto(){
        return lotto;
    }
}
