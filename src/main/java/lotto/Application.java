package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoOrder;

public class Application {
    public static final String ORDER_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

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

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoOrder lottoOrder;

        try {
            lottoOrder = getLottoOrderInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
