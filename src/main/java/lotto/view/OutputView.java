package lotto.view;

import lotto.domain.RandomLottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void purchaseAmountMsg() {
        System.out.println("로또 구입 금액을 입력해주세요.");
    }

    public static void purchaseResultMsg(List<RandomLottoNumber> lottoNumberList, int countFromMoney) {
        System.out.println(countFromMoney + "개를 구매했습니다.");
        for (RandomLottoNumber lottoNumber : lottoNumberList) {
            List<Integer> sortedRandomNum = lottoNumber.getRandomNum().stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println(sortedRandomNum);
        }
    }

    public static void winningNumberMsg() {
        System.out.println("당첨 번호를 입력해주세요");
    }

    public static void bonusNumberMsg() {
        System.out.println("보너스 번호를 입력해주세요.");
    }
}

