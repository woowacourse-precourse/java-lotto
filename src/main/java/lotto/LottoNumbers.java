package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lotto.Lotto.*;

public class LottoNumbers {

    public static List<Integer> getLotteryWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.\n");
        String[] lottoNumberList = Console.readLine().split(",");
        List<String> LottoNumberListInString = Arrays.asList(lottoNumberList);
        for (int numberIndex = 0; numberIndex < 6; numberIndex++) {
            if (LottoNumberListInString.get(numberIndex).charAt(0) < 48 || LottoNumberListInString.get(numberIndex).charAt(0) > 57) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
            }
        }
        List<Integer> LottoNumberInInteger = new ArrayList<>();
        for (String stringIndex : LottoNumberListInString) {
            LottoNumberInInteger.add(Integer.parseInt(stringIndex));
        }
        return LottoNumberInInteger;
    }

    public static int getLotteryBonusNumber() {

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

}
