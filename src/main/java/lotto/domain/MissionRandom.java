package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class MissionRandom implements PickNumbers {

    @Override
    public List<Integer> pickUniquesInRange(int startInclusive, int endInclusive, int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
    }
}
