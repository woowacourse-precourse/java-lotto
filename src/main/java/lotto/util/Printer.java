package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class Printer {
    public static void print(String message) {
        System.out.println(message);
    }

    public static void printf(String message, int n) {
        System.out.printf(message, n);
    }

    public static void printf(String message, double n) {
        System.out.printf(message, n);
    }

    public static void divide() {
        System.out.println();
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
