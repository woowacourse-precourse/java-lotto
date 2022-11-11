package lotto.UI;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SimpleTimeZone;

public class User {

    public static Integer askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 문자 또는 공백은 입력이 불가능 합니다. 1,000원 단위의 숫자를 입력해 주세요.");
        }
    }

    public static boolean checkMonetaryUnit(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1,000원 단위의 숫자를 입력해 주세요.");
        }
        return true;
    }

    public static List<Integer> lottoNumberReceiveInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] lineTest = Console.readLine().split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int length = 0; length < lineTest.length; length++) {
            try {
                lottoNumbers.add(Integer.parseInt(lineTest[length]));
            } catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException("[ERROR] 문자 또는 공백은 입력이 불가능합니다. 1~45 사이의 숫자 6개를 입력해 주세요.");
            }
        }
        new Lotto(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static Integer inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            String inputNumber = Console.readLine();
            Integer bonusNumber = Integer.parseInt(inputNumber);
            return bonusNumber;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 문자 또는 공백은 입력이 불가능합니다. 1~45 사이의 숫자 한개를 입력해 주세요.");
        }
    }

}