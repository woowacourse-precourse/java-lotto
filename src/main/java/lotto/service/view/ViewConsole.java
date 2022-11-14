package lotto.service.view;

import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.correctLotto.CorrectLottoNumbers;
import lotto.domain.lotto.correctLotto.Ranking;
import lotto.domain.lotto.correctLotto.Rankings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ViewConsole {

    private static String PLZ_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static String LOTTO_LINE_COUNT = "개를 구매했습니다.";
    private static String PLZ_INPUT_CORRECT_NUMBER = "당첨 번호를 입력해 주세요.";
    private static String PLZ_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printInputMoney() {
        System.out.println(PLZ_INPUT_MONEY);
    }

    public static void printLottoLineCount(int count) {
        System.out.println(count + LOTTO_LINE_COUNT);
    }

    public static void printInputCorrectNumber() {
        System.out.println(PLZ_INPUT_CORRECT_NUMBER);
    }

    public static void printInputBonusNumber() {
        System.out.println(PLZ_INPUT_BONUS_NUMBER);
    }

}
