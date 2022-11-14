package controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Random {
    public static List<Integer> getRandomNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return randomNumbers;
    }
}
