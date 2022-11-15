package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {

    public static List<Integer> list;

    public static List<Integer> create(){
        list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return list;
    }

}
