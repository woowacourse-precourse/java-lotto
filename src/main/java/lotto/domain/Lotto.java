package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.View.ErrorMessage;

public class Lotto { // 로또 번호 세트 하나에 대한 기능 클래스
    private static final int SIZE=6;
    private static final int LARGEST_NUMBER=45;
    private static final int SMALLEST_NUMBER=1;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) { // 당첨 번호를 입력할 시 사용할 생성자
        validate(numbers);
        this.numbers = numbers;
    }
    public static Lotto getInstance(List<Integer> generatedNumbers){
        List<Integer> sortedNumbers=new ArrayList<>(generatedNumbers);
        Collections.sort(sortedNumbers);
        return new Lotto(sortedNumbers);
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIX_NUMBER.getValue());
        }
    }

    public static Lotto generateRandomLotto(){
        return getInstance(Randoms.pickUniqueNumbersInRange(SMALLEST_NUMBER,LARGEST_NUMBER,SIZE));
    }

}
