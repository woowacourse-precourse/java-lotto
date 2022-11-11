package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.ui.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
* 제공된 Lotto 클래스를 활용해 구현해야 한다.
* Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
* numbers의 접근 제어자인 private을 변경할 수 없다.
* Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
* Lotto의 패키지 변경은 가능하다.
* */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    //보너스 번호를 제외하고 validate 를 만든거보니까 보너스 번호는 enum 으로 만들던가 해야겠다.
    // TODO: 추가 기능 구현

    //예외사항(입력단위가 1000원이 아니면)
    private int getLottoAmount(int money) {
        int amount = money/1000;

        return amount;
    }

    //ui에서 예외 검사하고 넘어올거여서 굳이 예외사항을 검사해야할까?
    private void initNumbers(List<Integer> winningNumbers) {
        int length = winningNumbers.size();

        for(int number : winningNumbers) {
            numbers.add(number);
        }
    }

    private List<Integer> createLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return lottoNumbers;
    }

    private List<>
}
