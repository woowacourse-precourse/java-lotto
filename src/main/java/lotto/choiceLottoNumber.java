package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class choiceLottoNumber {

    private final List<Integer> my_lotto_number;
    private int bonuce_number = 0;

    public choiceLottoNumber() {
        this.my_lotto_number = userNumber();
        this.bonuce_number = bonuceNumber();
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

    public int bonuceNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        String bonuce = Console.readLine();

        try{
            int bonuce_number = Integer.parseInt(bonuce);
            System.out.println(bonuce_number);
            return bonuce_number;
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수만 입력하세요.");
        }
    }
}

