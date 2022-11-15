package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberComparator {
    private final List<Integer> number;
    private final int bonus;
    private List<Integer> result = new ArrayList<>();

    NumberComparator(List<Integer> number, int bonus) {
        validateNumber(number);
        this.number = number;
        validateBonus(bonus);
        this.bonus = bonus;

    }

    NumberComparator() {
        this.number = scanNumber();
        this.bonus = scanBonus();
        validateNumber(number);
        validateBonus(bonus);
    }

    private List<Integer> scanNumber() {
        List<Integer> number = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String scan = Console.readLine();
        String[] scanSplit;

        scan = scan.replace(" ", "");
        scanSplit = scan.split(",");
        for (String str : scanSplit) {
            number.add(Integer.parseInt(str));
        }
        validateNumber(number);
        return number;
    }

    private int scanBonus() {
        int bonus;

        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
        validateBonus(bonus);
        return bonus;
    }

    void compareNumber(List<Lotto> bundle) {
        for (int index = 0; index < bundle.size(); index++) {
            List<Integer> lotto = new ArrayList<>(bundle.get(index).get());
            int count;

            lotto.retainAll(number);
            count = lotto.size();
            if(count == 6) {
                count++;
            }
            if(count == 5 && bundle.get(index).get().contains(bonus)) {
                    count++;
                }
            result.add(count);
        }
    }

    private void validateNumber(List<Integer> number) {
        if (number.size() != 6) {
            System.out.println("[ERROR] 입력한 당첨 번호의 개수가 6개가 아닙니다.");
            throw new IllegalArgumentException("[ERROR] 입력한 당첨 번호의 개수가 6개가 아닙니다.");
        }
        if (Collections.min(number) < 1 || Collections.max(number) > 45) {
            System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (number.size() != number.stream().distinct().count()) {
            System.out.println("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void validateBonus(int bonus) {
        List<Integer> numberAll = new ArrayList<>(number);

       numberAll.add(bonus);
        if (bonus< 1 || bonus > 45) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numberAll.size() != numberAll.stream().distinct().count()) {
            System.out.println("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    List<Integer> getResult() {
        return this.result;
    }
}
