package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Sets;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    //로또 당첨번호
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

        Set<Integer> qwer = new HashSet<>(numbers);

        for(Integer number : numbers){
            if (!checkValidLottoRange(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
            }
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 입력해주시기 바랍니다.");
        }

        if(numbers.size() != qwer.size())
            throw new IllegalArgumentException("[ERROR] 잘못된 값이 입력되었습니다.");

    }
    private static Boolean checkValidLottoRange(int number) {
        return number >= 1 && number <= 45;
    }

    public Integer getLottoAnswerBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus_numbers = Integer.parseInt(Console.readLine());
        if (!checkValidLottoRange(bonus_numbers)) {
            System.out.println("로또보너스오류");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45사이의 숫자여야 합니다.");
        }
        if(numbers.contains(bonus_numbers))
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 잘못 입력하였습니다.");
        return bonus_numbers;
    }
}
