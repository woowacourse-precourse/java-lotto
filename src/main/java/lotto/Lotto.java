package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 길이는 6으로 맞추어야 합니다.");
        } else if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다.");
        } else if (numbers.stream().anyMatch(s -> s>45 || s<1)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber>45 || bonusNumber<1) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        return bonusNumber;
    }

    public Map<Integer, Integer> rankCount(List<List<Integer>> userLottoNumbers, int bonus) {
        Map<Integer, Integer> rankNumbers = Map.of(
                3,0,
                4,0,
                5,0,
                50,0,
                6,0
        );
//        for (List<Integer> lottoNumber : userLottoNumbers) {
//            long commonNumbers = numbers.stream().filter(lottoNumber::contains).count();
//            if () {
//
//            }
//        }
        return rankNumbers;
    }
}
