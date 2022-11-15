package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.AdditionalFunction.StringToInt;

public class PrizeLotto {
    private final HashSet<Integer> prizeLotto;

    public PrizeLotto() {
        this.prizeLotto = CreatePrizeLotto();
    }

    public HashSet<Integer> CreatePrizeLotto(){
        String[] inputValues = Console.readLine().split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : inputValues){
            numbers.add(StringToInt(num));
        }
        Lotto prizeLotto = new Lotto(numbers);
        HashSet<Integer> FastSearchPrizeLotto = new HashSet<>(prizeLotto.getNumbers());
        return FastSearchPrizeLotto;
    }

    public HashSet<Integer> getPrizeLotto(){
        return this.prizeLotto;
    }
}
