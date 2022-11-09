package lotto.exception;

import java.util.List;

public class LottoNumberException {
    public void lottoNumberSize(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 크기가 6이 아닙니다.");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void lottoNumberDuplicated(List<Integer> numbers) {
        try {
            for (Integer num : numbers) {
                if (numbers.indexOf(num) != numbers.lastIndexOf(num)) {
                    throw new IllegalArgumentException("중복된 값이 있습니다.");
                }
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
