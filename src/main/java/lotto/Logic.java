package lotto;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static lotto.ErrorCode.*;

public class Logic {

    int checkPieces(String input) {
        // implement
        return 0;
    }

    List<Integer> lotto_Validate(List<Integer> numbers) {
        throwInputExceptions(numbers.size() == 6, LOTTERY_INADEQUATE_NUMBER_AMOUNT);

        int frequency; // 확인할 빈도 수
        int comp; // 중복 확인하기 위해 각 순회마다 받을 배열
        Iterator<Integer> iter = numbers.iterator();
        while(iter.hasNext()) {
            comp = iter.next();
            throwInputExceptions(comp >= 1 && comp <= 45, LOTTERY_OUT_OF_RANGE);
            frequency = Collections.frequency(numbers, comp);
            throwInputExceptions(frequency == 1, LOTTERY_DUPLICATED_NUMBER);
        }
        return numbers;
    }

    void throwInputExceptions(boolean condition, ErrorCode exceptionMessage) {
        if(condition) {
            return;
        }
        throw new IllegalArgumentException(exceptionMessage.getMessage());
    }
}
