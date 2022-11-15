package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.enums.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    static final int numberMinRage = 1;
    static final int numberMaxRage = 45;
    static final int numberCount = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println(ExceptionMessage.NOT_NUMBER_SIZE);
            throw new IllegalArgumentException();
        }
    }

    static Lotto creatLottoNumbers(int lottoCount) {
        List<Integer> lotto = Randoms.pickUniqueNumbersInRange(numberMinRage, numberMaxRage, numberCount);

        return new Lotto(lotto);
    }
    public void printLottoNumber(){
        ArrayList<Integer> copy =new ArrayList<>(numbers);
        Collections.sort(copy);

        System.out.println(copy.toString());
    }
}
