package lotto;

import lotto.input.UserInput;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.verifiable.CheckPrize;
import lotto.verifiable.Verifiable;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> generateRandomValue(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Integer checkPrizes(List<List<Integer>> numbers,Lotto lotto){
        Verifiable<Prize> check = new CheckPrize();
        Integer prizeCount = 0;
        for (List<Integer> number : numbers) {
            prizeCount = check.checkWithValue(new Prize(number, lotto.numbers));
        }
        return prizeCount;
    }
}