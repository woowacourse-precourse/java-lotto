package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberComparator {
    List<Integer> number = new ArrayList<>();
    int bonus;
    List<Integer> result = new ArrayList<>();

    NumberComparator() {
    }

    NumberComparator(List<Integer> number) {
        this.number = number;
    }

    void setWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        String[] temp;

        numbers = numbers.replace(" ", "");
        temp = numbers.split(",");
        for (String str : temp) {
            this.number.add(Integer.parseInt(str));
        }
        validateWinningNumber();
    }

    void setBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
        validateBonus();
    }

    void compareNumbers(List<Lotto> bundle) {
        for (int index = 0; index < bundle.size(); index++) {
            List<Integer> lottoNumber = new ArrayList<>(bundle.get(index).get());
            int count;

            lottoNumber.retainAll(number);
            count = lottoNumber.size();
            if(count == 6) {
                count++;
            }
            if(count == 5) {
                if (bundle.get(index).get().contains(bonus)) {
                    count++;
                }
            }
            result.add(count);
        }
    }

    void validateWinningNumber() {
        if (this.number.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호의 개수가 6개가 아닙니다.");
        }
        if (Collections.min(this.number) < 1 || Collections.max(this.number) > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (this.number.size() != this.number.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    void validateBonus() {
        List<Integer> wholeNumber = new ArrayList<>(number);

        wholeNumber.add(bonus);
        if (bonus< 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (wholeNumber.size() != wholeNumber.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
