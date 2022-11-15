package lotto.domain.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.game.Lotto.*;

public class CreateLotto {
    private List<Integer> lotto;

    public CreateLotto(){
        List<Integer> temLotto = generateLotto();
        lotto = new ArrayList<>(temLotto);
        sortNatural();
    }

    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_RANGE, LOTTO_MAX_RANGE, LOTTO_COUNT).stream().sorted().collect(Collectors.toList());
    }

    public void sortNatural(){
        lotto.sort(Comparator.naturalOrder());
    }

    public List<Integer> getLotto(){
        return lotto;
    }
}
