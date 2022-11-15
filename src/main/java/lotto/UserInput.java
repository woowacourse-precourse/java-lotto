package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    public int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            isDigit(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
        return Integer.parseInt(input);
    }

    public List<Integer> getLottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String lottoInput = readLine();
        String[] lotto = lottoInput.split(",");
        List<Integer> lottoNumber = new ArrayList<>();

        for (String s : lotto) {
            lottoNumber.add(Integer.parseInt(s));
        }
        return lottoNumber;
    }

    public int getBonusInput() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = readLine();
        return Integer.parseInt(bonusInput);
    }

    private static void isDigit(String input) {
        if (!input.matches("-?\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 문자가 입력되었습니다.");
        }
    }
}
