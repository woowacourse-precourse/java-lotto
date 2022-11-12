package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> generateRandomValue(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}