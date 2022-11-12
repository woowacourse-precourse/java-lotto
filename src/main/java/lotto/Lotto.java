package lotto;

import lotto.input.UserInput;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.verifiable.CheckPrize;
import lotto.verifiable.Verifiable;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> generateRandomValue(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}