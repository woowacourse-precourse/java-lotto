package lotto.domain.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CreateLotto {
    private final List<Integer> lotto;

    CreateLotto(){
        lotto = generateLotto();
    }

    public List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
