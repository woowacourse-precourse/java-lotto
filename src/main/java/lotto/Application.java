package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {


    }

    public static List<Integer> makeLottoNum() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
