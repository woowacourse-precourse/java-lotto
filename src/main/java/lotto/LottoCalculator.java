package lotto;

public class LottoCalculator {

    private static int sameNumber = 0;

    public static int getCountOfSameNumber(Lotto compare1, Lotto compare2) {
        sameNumber = 0;
        compare1.indexedForEach((oneNumber1) -> compare2.indexedForEach((oneNumber2) -> {
            if (oneNumber1.equals(oneNumber2)) {
                sameNumber++;
            }
        }));
        return sameNumber;
    }
}
