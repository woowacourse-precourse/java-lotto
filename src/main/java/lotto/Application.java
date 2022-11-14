package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static final Integer LOTTO_AMOUNT_EACH = 1000;

    public static void main(String[] args) {

        Integer amount = printlnPurchaseNoticeMessage();
        printlnLottoNumMessage(amount);

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

    private static void printlnLottoNumMessage(Integer amount) {
        Integer lottoNum = calcLottoNum(amount);
        System.out.printf("%d개를 구매했습니다.\n", lottoNum);
    }

    private static Integer calcLottoNum(Integer amount) {
        Integer lottoNum = amount / LOTTO_AMOUNT_EACH;
        return lottoNum;
    }

    private static int getPurchaseAmount() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    private static int printlnPurchaseNoticeMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        Integer purAmount = getPurchaseAmount();
        return purAmount;
    }
}
