package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 길이는 6으로 맞추어야 합니다.");
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복되는 숫자가 존재합니다.");
        }
        if (numbers.stream().anyMatch(s -> s>45 || s<1)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int bonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber>45 || bonusNumber<1) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 입력한 로또 넘버에 포함되지 않는 숫자여야 합니다.");
        }

        return bonusNumber;
    }

    public Map<String,Integer> rankCount(List<List<Integer>> userLottoNumbers, int bonus) {
        Map<String,Integer> rankNumbers = new HashMap<>(createInitialRankNumbers());
        for (List<Integer> lottoNumber : userLottoNumbers) {
            int commonNumbers = setCommonNumber(
                    Long.valueOf(numbers.stream().filter(lottoNumber::contains).count()).intValue(),
                    bonus,
                    lottoNumber);

            if (commonNumbers > 2) {
                LottoEnum lottoEnum = LottoEnum.valueOfNumber(commonNumbers);
                rankNumbers.put(lottoEnum.name(), rankNumbers.get(lottoEnum.name())+1);
            }
        }
        return rankNumbers;
    }

    public int setCommonNumber(int commonNumber, int bonus, List<Integer> lottoNumber) {
        if (commonNumber == 5 && lottoNumber.contains(bonus)) {
            return commonNumber + 2;
        }
        return commonNumber;
    }

    public Map<String, Integer> createInitialRankNumbers() {
        Map<String,Integer> rankNumbers = new HashMap<>();
        rankNumbers.put("THREE",0);
        rankNumbers.put("FOUR",0);
        rankNumbers.put("FIVE",0);
        rankNumbers.put("FIVE_B",0);
        rankNumbers.put("SIX",0);
        return rankNumbers;
    }

    public long viewResult(Map<String,Integer> result) {
        for (Map.Entry<String,Integer> entry : result.entrySet()) {
            LottoEnum lottoEnum = LottoEnum.valueOf(entry.getKey());
            lottoEnum.calculate(entry.getValue());
            System.out.printf("%s - %d개\n", lottoEnum.getMoneyString(), entry.getValue());
        }
        return LottoEnum.getSumMoney();
    }

    public String yield(int amount, long sumMoney) {
        return String.format("%.1f", (float) sumMoney/(amount*10));
    }
}
