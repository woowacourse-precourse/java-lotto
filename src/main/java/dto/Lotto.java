package dto;

import java.util.List;

import util.ExceptionUtil;
import util.ValidateUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!ValidateUtil.checkListSize(numbers, 6)) {
            ExceptionUtil.makeException("로또 숫자는 6개여야 합니다.");
        }
        if (!ValidateUtil.checkUniqueNumber(numbers)) {
        	 ExceptionUtil.makeException("로또 숫자는 중복될 수 없습니다.");
        }
        
    }

}
