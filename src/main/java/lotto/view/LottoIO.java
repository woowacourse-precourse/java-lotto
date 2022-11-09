package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoIO {

    private List<Integer> lottoAnswer;
    private int bonus;

    public LottoIO() {
        lottoAnswer = new ArrayList<>();
    }

    // 당첨 번호 입력
    public List<Integer> inputLottoAnswer() {
        System.out.println("당첨 번호를 입력 주세요.");
        String input = Console.readLine();
        if (checkInvalidNumbers(input)) {
            System.out.println("[ERROR] 당첨번호는 쉼표(,)를 기준으로 6개의 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }

        String[] nums = input.split(",");
        for (String num : nums) {
            this.lottoAnswer.add(Integer.valueOf(num));
        }
        return this.lottoAnswer;
    }

    // 보너스 번호 입력
    public int inputBonusAnswer() {
        System.out.println("보너스 번호를 입력 주세요.");
        String input = Console.readLine();
        if (checkInvalidBonus(input)) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자를 한 개만 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        Integer result = Integer.valueOf(input);

        this.bonus = result;
        return bonus;
    }

}
