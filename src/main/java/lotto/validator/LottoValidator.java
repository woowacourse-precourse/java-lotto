package lotto.validator;

import java.util.List;

public class LottoValidator {
    public static void validate(List<Integer> numbers) throws  IllegalArgumentException{
        checkSize(numbers);
        checkOverlap(numbers);
        checkRange(numbers);
    }

    public static void checkSize(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6)
            throw new IllegalArgumentException("[ERROR] 로또 번호가 6개가 아닙니다.");
    }

    public static void checkOverlap(List<Integer> numbers) throws IllegalArgumentException{
        if(numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호가 있습니다.");
    }

    public static void checkRange(List<Integer> numbers) throws IllegalArgumentException{
        if(numbers.stream().filter(n->n<1 || n>45).count()>0)
            throw new IllegalArgumentException("[ERROR] 로또 번호중 1~45 이외의 숫자가 존재합니다.");
    }
}
