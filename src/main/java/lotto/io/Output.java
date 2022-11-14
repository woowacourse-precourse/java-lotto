package lotto.io;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    public static void printQuickPick(List<Lotto> quickPicks) {
        for (Lotto lotto : quickPicks) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printIllegalArgumentException(String message) {
        System.out.println(message);
    }

}
