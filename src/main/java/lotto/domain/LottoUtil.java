package lotto.domain;

public class LottoUtil {
    public static int checkRank(int numbersCount, int bonusCount) {
        int count = numbersCount + bonusCount;

        if (Rank.TWO.isOverStandard(count)) {
            return decideOneOrTwoRank(numbersCount);
        } else if (Rank.THREE.isOverStandard(count)) {
            return Rank.THREE.getRank();
        } else if (Rank.FOUR.isOverStandard(count)) {
            return Rank.FOUR.getRank();
        } else if (Rank.FIVE.isOverStandard(count)) {
            return Rank.FIVE.getRank();
        }

        return Rank.ZERO.getRank();
    }

    private static int decideOneOrTwoRank(int numberCount) {
        if (Rank.ONE.isOverStandard(numberCount)) {
            return Rank.ONE.getRank();
        }
        return Rank.TWO.getRank();
    }
}
