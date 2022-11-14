package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {
    public static final String ENTER = "\n";
    private List<Lotto> lotteries = new ArrayList<>();

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries.addAll(lotteries);
    }

    public String getLottoNumbers() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lotteries) {
            stringBuilder.append(lotto.getNumbersToString() + ENTER);
        }

        return stringBuilder.toString();
    }
}
