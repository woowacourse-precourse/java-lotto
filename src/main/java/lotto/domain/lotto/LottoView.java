package lotto.domain.lotto;

import java.util.stream.Collectors;
import lotto.util.View;

public class LottoView {
    
    public static void printNumbersByArrayFormat(Lotto lotto) {
        View.println(getNumbersTextByArrayFormat(lotto));
    }
    
    public static String getNumbersTextByArrayFormat(Lotto lotto) {
        return "[" + lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", ")) + "]";
    }
}
