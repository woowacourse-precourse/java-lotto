package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.controller.LottoController;
import lotto.model.Lotto;
import lotto.model.LottoEnum;

public class LottoView {

    private final LottoController controller = new LottoController();
    private List<Lotto> lotteries;

    public void addLotteries() {
        System.out.println("구매금액을 입력해주세요.");
        String line = Console.readLine();
        if (!line.matches("^\\d+000$")) {
            System.out.println("[ERROR] 천원 단위로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        try {
            lotteries = controller.createLotteries(Integer.parseInt(line) / 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 최소1장 이상 구매가능합니다. ");
            throw new IllegalArgumentException();
        }
    }

    public void printLotteries() {
        for (final Lotto lotto : lotteries) {
            printLotto(lotto);
        }
    }

    private void printLotto(Lotto lotto) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (final Integer number : lotto.getNumbers()) {
            builder.append(number);
            if (number.intValue() == lotto.getNumbers()
                .get(LottoEnum.TOTAL_LOTTO_NUMBER.getValue() - 1)) {
                continue;
            }
            builder.append(", ");
        }
        builder.append("]");
        System.out.println(builder);
    }

}
