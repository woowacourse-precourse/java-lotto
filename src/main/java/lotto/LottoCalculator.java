package lotto;

public class LottoCalculator {

    private static int sameNumber = 0;

    public static int getCountOfSameNumber(Lotto compare1, Lotto compare2) {
        compare1.indexedForEach((a, i) -> compare2.indexedForEach((n, j) -> {
            if (!a.equals(n)) {
                return;
            }
            if (i.equals(j)) {
                sameNumber++;
            } else {
                sameNumber++;
            }
        }));
        return sameNumber;
    }

}
