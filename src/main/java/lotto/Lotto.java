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
        } else if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 입력한 로또 넘버에 포함되지 않는 숫자여야 합니다.");
        }

        return bonusNumber;
    }

    public Map<Integer,Integer> rankCount(List<List<Integer>> userLottoNumbers, int bonus) {
        Map<Integer,Integer> rankNumbers = new HashMap<>();
        rankNumbers.put(3,0);
        rankNumbers.put(4,0);
        rankNumbers.put(5,0);
        rankNumbers.put(50,0);
        rankNumbers.put(6,0);

        for (List<Integer> lottoNumber : userLottoNumbers) {
            int commonNumbers = Long.valueOf(numbers.stream().filter(lottoNumber::contains).count()).intValue();
            if (commonNumbers == 5 && lottoNumber.contains(bonus)) {
                rankNumbers.put(50, rankNumbers.get(50)+1);
            } else {
                rankNumbers.put(commonNumbers, rankNumbers.get(commonNumbers)+1);
            }

        }
        return rankNumbers;
    }

    public int viewResult(Map<Integer,Integer> result) {
        System.out.println("당첨 통계\n---");
        int sumMoney = 0;
        for (Map.Entry<Integer,Integer> entry : result.entrySet()) {
            if (entry.getKey() == 3) {
                System.out.print("3개 일치 (5,000원)");
                sumMoney += 3000;
            } else if (entry.getKey() == 4) {
                System.out.print("4개 일치 (50,000원)");
                sumMoney += 50000;
            } else if (entry.getKey() == 5) {
                System.out.print("5개 일치 (1,500,000원)");
                sumMoney += 1500000;
            } else if (entry.getKey() == 50) {
                System.out.print("5개 일치, 보너스 볼 일치 (30,000,000원)");
                sumMoney += 30000000;
            } else if (entry.getKey() == 6) {
                System.out.print("6개 일치 (2,000,000,000원)");
                sumMoney += 2000000000;
            }

            System.out.printf(" - %d개\n",entry.getValue());
        }
        return sumMoney;
    }

    public String yield(int amount, int sumMoney) {
        return String.format("%.1f", (float) sumMoney/(amount*1000));
    }
}
