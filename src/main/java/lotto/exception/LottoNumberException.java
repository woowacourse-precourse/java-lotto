package lotto.exception;

import java.util.List;

public class LottoNumberException {
    public void lottoNumberValidate(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 크기가 6이 아닙니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
