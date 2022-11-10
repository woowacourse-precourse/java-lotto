package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
    // 외부에 난수가 generate 되는 메소드를 만들고 Lotto에 넣고 검사를 돌린다.
    // 그 난수를 어딘가에 저장해야 당첨 번호랑 match 시켜볼텐데...
    // 당첨 번호를 new Lotto(번호) 이런 식으로 검사 해보는것도 좋을듯
    // TODO: 추가 기능 구현

    public void luckyNumberIsNotDuplicate(String userNumber) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < userNumber.length(); i++) {
            set.add(userNumber.charAt(i));
        }
        if (userNumber.length() != set.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력하였습니다.");
        }
    }

}
