package domain;

import dto.LottoDto;
import dto.WinningNumberDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final String ERROR_NUMBER_OUT_OF_BOUND = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final int POSSIBLE_BONUS = 5;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                System.out.println(ERROR_NUMBER_OUT_OF_BOUND);
            }
        }
    }

    public LottoDto sendDto() {
        return new LottoDto(numbers);
    }

    public LottoRank countHit(WinningNumberDto winningNumber) {
        Integer hit = 0;
        Boolean bonusHit = false;
        for (Integer mainNumber : winningNumber.mainNumbers) {
            if (numbers.contains(mainNumber)) hit++;
        }
        if (hit == POSSIBLE_BONUS) {
            Integer bonusNumber = winningNumber.bonusNumber;
            if (numbers.contains(bonusNumber)) bonusHit = true;
        }
        return LottoRank.decideRank(hit, bonusHit);
    }
}
