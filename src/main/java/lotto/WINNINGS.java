package lotto;

import java.util.HashMap;
import java.util.Map;

public enum WINNINGS{
    FIRST("2,000,000,000", 6, 5),
    SECOND("30,000,000", 5, 4),
    THIRD("1,500,000", 5, 3),
    FOURTH("50,000", 4, 2),
    FIFTH("5,000", 3, 1);

    String value;
    int correctCount;
    int sortOrder;

    private WINNINGS(String value, int correctCount, int sortOrder)
    {
        this.value = value;
        this.correctCount = correctCount;
        this.sortOrder = sortOrder;
    }

    public String getValue(){
        return value;
    }
    public int getCorrectCount(){
        return correctCount;
    }
    public int getSortOrder(){return sortOrder; }

    public static WINNINGS fromInteger(int correctCount, boolean isBonusCorrect){
        if(correctCount == 3)
            return WINNINGS.FIFTH;

        if(correctCount == 4)
            return WINNINGS.FOURTH;
        if(correctCount == 5) {
            if (isBonusCorrect)
                return WINNINGS.SECOND;
            return WINNINGS.THIRD;
        }

        if(correctCount == 6)
            return WINNINGS.FIRST;

        return null;
    }

    public static void printWinningInfo(WINNINGS winning, int winningCount){
        if(winning == WINNINGS.SECOND){
            System.out.println(winning.getCorrectCount() + "개 일치, 보너스 볼 일치 ("
                    + winning.getValue() + "원) - "
                    + winningCount + "개");
            return;
        }

        System.out.println(winning.getCorrectCount() + "개 일치 ("
                + winning.getValue() + "원) - "
                + winningCount + "개");
    }
}