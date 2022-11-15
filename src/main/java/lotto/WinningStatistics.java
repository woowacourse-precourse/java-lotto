package lotto;

public class WinningStatistics {

    private static Integer TREE_CORRECT_COUNT;
    private static Integer FOUR_CORRECT_COUNT;
    private static Integer FIVE_CORRECT_COUNT;
    private static Integer FIVE_AND_BONUS_CORRECT_COUNT;
    private static Integer ALL_COUNT;

    public static void plus(CorrectType correctType) {
        if (correctType == CorrectType.TREE_CORRECT) {
            plusTreeCorrect();
        }

        if (correctType == CorrectType.FOUR_CORRECT) {
            plusFourCorrect();
        }

        if (correctType == CorrectType.FIVE_CORRECT) {
            plusFiveCorrect();
        }

        if (correctType == CorrectType.FIVE_AND_BONUS_CORRECT) {
            plusFiveAndBonusCorrect();
        }

        if (correctType == CorrectType.ALL_CORRECT) {
            plusAllCorrect();
        }
    }

    private static void plusTreeCorrect() {
        TREE_CORRECT_COUNT++;
    }

    private static void plusFourCorrect() {
        FOUR_CORRECT_COUNT++;
    }

    private static void plusFiveCorrect() {
        FIVE_CORRECT_COUNT++;
    }

    private static void plusFiveAndBonusCorrect() {
        FIVE_AND_BONUS_CORRECT_COUNT++;
    }

    private static void plusAllCorrect() {
        ALL_COUNT++;
    }

    public static String printlnResultString() {
        StringBuilder sb = new StringBuilder();

        sb.append("3개 일치 (5,000원) - ").append(TREE_CORRECT_COUNT).append("개\n");
        sb.append("4개 일치 (50,000원) - ").append(FOUR_CORRECT_COUNT).append("개\n");
        sb.append("5개 일치 (1,500,000원) - ").append(FIVE_CORRECT_COUNT).append("개\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(FIVE_AND_BONUS_CORRECT_COUNT).append("개\n");
        sb.append("6개 일치 (2,000,000,000원) - ").append(ALL_COUNT).append("개");

        return sb.toString();
    }
}
