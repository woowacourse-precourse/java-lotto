package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Lotto {
    private final List<Integer> numbers;
    private static final String BONUS_INPUT_SENTENCE  = "보너스 번호를 입력해 주세요.\n";

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateOverlap(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++){
            if (Collections.frequency(numbers,numbers.get(i)) != 1) {
                throw new IllegalArgumentException("[ERROR] 숫자가 중복되지 않아야 합니다.");
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i)< 1 || numbers.get(i)> 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private int bonus() {
        System.out.print(BONUS_INPUT_SENTENCE);
        int bonusNum = Integer.parseInt(Console.readLine());
        if(bonusNum< 1 || bonusNum> 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        return bonusNum;
    }

    public List<Integer> compareList() {
        BuyLotto buy = new BuyLotto();
        List<List<Integer>> userLottoNumber = buy.lottoNumberMaker();
        List<Integer> winLottoNumber = this.numbers;
        List<Integer> sameCount = new ArrayList<>();
        System.out.println("당첨 번호: " + winLottoNumber);
        for(int i=0; i<userLottoNumber.size(); i++) {
            List<Integer> result = userLottoNumber.get(i).stream()
                    .filter(old -> winLottoNumber.stream()
                            .anyMatch(Predicate.isEqual(old)))
                    .collect(Collectors.toList());
            sameCount.add(result.size());
        }
        return sameCount;
    }
}