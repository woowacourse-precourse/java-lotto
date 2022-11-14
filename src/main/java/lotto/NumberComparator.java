package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberComparator {
    List<Integer> number = new ArrayList<>();

    NumberComparator() {
    }

    NumberComparator(List<Integer> Winningnumber) {
        this.number = number;;
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

    void setWholeNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String number = Console.readLine();

        this.number.add(Integer.parseInt(number));
        validateWholeNumber();
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

    void validateWholeNumber() {
        if (this.number.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호의 개수가 7개가 아닙니다.");
        }
        if (Collections.min(this.number) < 1 || Collections.max(this.number) > 45) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (this.number.size() != this.number.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }
}
