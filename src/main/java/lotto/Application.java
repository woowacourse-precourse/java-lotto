package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoAnswer;
import lotto.domain.LottoOrder;
import lotto.domain.LottoResult;

public class Application {
    public static final String ORDER_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String RESULT_MESSAGE = "당첨 통계\n---";

    public static LottoOrder getLottoOrderInput() throws IllegalArgumentException {
        LottoOrder result;

        System.out.println(ORDER_INPUT_MESSAGE);
        result = new LottoOrder(Console.readLine());
        System.out.println();
        System.out.println(result.getLottoCount() + "개를 구매했습니다.");
        System.out.println(result);
        System.out.println();

        return result;
    }

    public static LottoAnswer getLottoAnswerInput() throws IllegalArgumentException {
        LottoAnswer result;
        String numbersCommand;
        String bonusCommand;

        System.out.println(NUMBER_INPUT_MESSAGE);
        numbersCommand = Console.readLine();
        System.out.println();
        System.out.println(BONUS_INPUT_MESSAGE);
        bonusCommand = Console.readLine();
        System.out.println();
        result = new LottoAnswer(numbersCommand, bonusCommand);

        return result;
    }

    public static void showResult(LottoOrder lottoOrder, LottoAnswer lottoAnswer) {
        LottoResult lottoResult = new LottoResult(lottoOrder, lottoAnswer);

        System.out.println(RESULT_MESSAGE);
        System.out.println(lottoResult);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoOrder lottoOrder;
        LottoAnswer lottoAnswer;

        try {
            lottoOrder = getLottoOrderInput();
            lottoAnswer = getLottoAnswerInput();
            showResult(lottoOrder, lottoAnswer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
