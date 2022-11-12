package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Server {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final int NUMBER_COUNT = 6;

    public List<Integer> publishLotto(){
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE,END_INCLUSIVE,NUMBER_COUNT);
    }
}
