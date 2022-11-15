package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {

    public void IsThousandFormat(int money) {
        while (money > 11) {
            if (money%1000 != 0) {
                System.out.println("[ERROR] 로또 구매 금액은 1000원 단위여야 합니다.");
                throw new IllegalArgumentException();
            }
            money /= 1000;
        }
    }

    public void IsRightFormatMoney(String s) {
        if (!s.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println("[ERROR] 로또 구매 금액은 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void IsOverLengthNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void IsCorrectRangeNumber(List<Integer> numbers) {
        for(int num : numbers) {
            if ((num>45)||(num<1))
                throw new IllegalArgumentException();
        }
    }

    public void IsSortedNumbers(List<Integer> numbers) {
        for (int i=0;i<numbers.size()-1;i++) {
            if (numbers.get(i) > numbers.get(i+1))
                throw new IllegalArgumentException();
        }
    }

    public void IsCorrectRangeWinningNumber(List<Integer> numbers) {
        for(int num : numbers)
            if ((num > 45) || (num < 1)) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
    }

    public void IsDuplicatedWinningNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsRightFormatWinningNumber(String s) {
        if (!s.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("[ERROR] 로또 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsOverLengthWinningNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsRightFormatBonusNumber(String s) {
        if (!s.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsCorrectRangeBonusNumber(int number){
        if ((number > 45) || (number < 0)){
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
