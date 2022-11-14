package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final Integer LOTTO_AMOUNT_EACH = 1000;

    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        String amountInput = Console.readLine();



        /* 로또 랜덤 발행
        [1, 2, 3, 4, 5, 6]
         */

        noticeInputWiningLottoNumbers();
        Lotto winingLotto = noticeWiningLottoInputMessage();
        // 1,2,3,4,5,6

        // 보너스 번호를 입력해 주세요
        // 7

        // 당첨 통계
        // ---
        /*
         ~개 일치 ()
         */

        // 총 수익률은 62.5%입니다.

        // TODO: 프로그램 구현
    }


    private static Lotto noticeWiningLottoInputMessage() {
        String input = Console.readLine();
        String[] winingLottoInput = input.split(",");

        List<Integer> winingLottoNumbers = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            Integer number = Integer.parseInt(winingLottoInput[i]);
            winingLottoNumbers.add(number);
        }
        return new Lotto(winingLottoNumbers);
    }

    private static void noticeInputWiningLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void validateAmountInput(String amountInput) {
        return;
    }
}
