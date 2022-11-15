package lotto.view;

import lotto.model.Lotto;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {
    private final String MSG_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MSG_INPUT_WIN_NUMBER = "당첨 번호를 입력해주세요.";
    private final String MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요.";
    private final String MSG_STATUS = "당첨 통계";
    private final String MSG_DIVIDER = "---";
    private final String MSG_TOTAL_PREFIX = "총 수익률은 ";
    private final String MSG_TOTAL_SUFFIX = "%입니다.";

    public void noticeInputMoney(){
        System.out.println(MSG_INPUT_MONEY);
    }



    public Integer noticeAmountLotto(int amount) {
        String format = String.format("%개를 구매했습니다.", amount / 1000);
        System.out.println(amount);
        System.out.println(format);
        return amount;
    }
    public static List<List<Integer>> NoticeInputLottoNumber(List<List<Integer>> lotts) {
        lotts.forEach(System.out::println);
        System.out.println(MSG_INPUT_WIN_NUMBER);
        return lotts;
    }

    public int noticeInputBonusNumber(Integer bonusNumber) {
        System.out.println(bonusNumber);
        return bonusNumber;
    }

    public List<Integer> winNumber(List<Integer> winningNumber) {
        String number = winningNumber.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(number);
        System.out.println(MSG_INPUT_BONUS_NUMBER);
        return winningNumber;
    }


}
