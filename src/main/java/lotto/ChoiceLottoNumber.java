package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class ChoiceLottoNumber {

    public final List<Integer> my_lotto_number;
    private int bonus_number = 0;

    public ChoiceLottoNumber() {
        this.my_lotto_number = userNumber();
        this.bonus_number = bonusNumber();
    }

    public List<Integer> userNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] lotto_number = Console.readLine().split(",");
        List<String> number = Arrays.asList(lotto_number);
        List<Integer> my_lotto_number = number.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(my_lotto_number);
        lotto.validataOverlap(my_lotto_number);

        return my_lotto_number;
    }

    public int bonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonus = Console.readLine();

        try{
            int bonus_number = Integer.parseInt(bonus);
            System.out.println(bonus_number);
            return bonus_number;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수만 입력하세요.");
        }
    }
}

