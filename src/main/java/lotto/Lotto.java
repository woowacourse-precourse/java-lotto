package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void checkOverlap(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++){
            for(int j = i+1; j < numbers.size(); j++){
                if (numbers.get(i) == numbers.get(j)) throw new IllegalArgumentException();
            }
        }
    }
    private List<Integer> makeLottoNumber(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<List<Integer>> drawLotto(int payedMoney){
        List<List<Integer>> payedLotto = new ArrayList<>();

        for (int i = 0; i < payedMoney/1000; i++){
                payedLotto.add(makeLottoNumber());
        }

        return payedLotto;
    }

    public int compareLotto(List<Integer> winningNumber, List<Integer> payedLotto){
        int matches = 0;

        for (int i = 0; i < winningNumber.size(); i++){
            if (payedLotto.contains(winningNumber.get(i))) matches++;
        }

        return matches;
    }


}
