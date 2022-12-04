package lotto;

import util.ExceptionPharse;
import util.LottoStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoException {
    public static void notLottoNumberRangeException(String userInput) {
        int userNumger = Integer.parseInt(userInput);
        isOutOfRange(userNumger);
    }

    public static void isOutOfRange(int userInput) {
        if (userInput > LottoStatus.MAX_NUMBER.getCode() || userInput < LottoStatus.MIN_NUMBER.getCode()) {
            throw new IllegalArgumentException(ExceptionPharse.IS_OUT_OF_RANGE.getExceptionMsg());
        }
    }

    public static void checkListOutOfRangeExceptioin(List<Integer> numbers) {
        for (Integer number : numbers) {
            isOutOfRange(number);
        }
    }

    /**
     * 로또 당첨 번호 자체 중복 여부 확인
     * @param numbers
     */
    public static void checkNoDuplicateWinnningLotto(List<Integer> numbers) {
        Set<Integer> checkList = new HashSet<>(numbers);
        if (checkList.size() != numbers.size()) {
            throw new IllegalArgumentException(ExceptionPharse.DUPLICATE.getExceptionMsg());
        }
    }
}
