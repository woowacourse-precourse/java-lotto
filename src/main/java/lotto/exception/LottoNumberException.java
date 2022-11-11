package lotto.exception;

import java.util.List;

public class LottoNumberException {
    public void lottoNumberSize(List<Integer> numbers) {
        try {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 크기가 6이 아닙니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void lottoNumberMaxMin(List<Integer> numbers) {
        try {
            for (Integer num : numbers) {
                if (num > 45 || num < 1) {
                    throw new IllegalArgumentException("[ERROR] 로또의 최대 최소 값이 맞지 않습니다.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void lottoNumberDuplicated(List<Integer> numbers) {
        try {
            for (Integer num : numbers) {
                if (numbers.indexOf(num) != numbers.lastIndexOf(num)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 값이 있습니다.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public void fullException(List<Integer> numbers) {
        lottoNumberSize(numbers);
        lottoNumberDuplicated(numbers);
        lottoNumberMaxMin(numbers);
    }

    public void bonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        try {
            if (winningNumbers.contains(bonusNumber))
                throw new IllegalArgumentException("[ERROR] 보너스 숫자가 이미 있는 번호입니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
