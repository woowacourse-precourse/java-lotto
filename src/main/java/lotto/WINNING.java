package lotto;

public enum WINNING {
    FIRST("2,000,000,000", 6, 5),
    SECOND("30,000,000", 5, 4),
    THIRD("1,500,000", 5, 3),
    FOURTH("50,000", 4, 2),
    FIFTH("5,000", 3, 1),
    BOOM("0",0,0); // 낙첨

    String value;
    int correctCount; // 맞춘 갯수(출력용)
    int sortOrder; // 정렬 기준(정렬용)

    private WINNING(String value, int correctCount, int sortOrder)
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

    public static WINNING fromInteger(int correctCount, boolean isBonusCorrect){
        if(correctCount == 3)
            return WINNING.FIFTH;

        if(correctCount == 4)
            return WINNING.FOURTH;
        if(correctCount == 5) {
            if (isBonusCorrect)
                return WINNING.SECOND;
            return WINNING.THIRD;
        }

        if(correctCount == 6)
            return WINNING.FIRST;

        return WINNING.BOOM;
    }

    public static void printWinningInfo(WINNING winning, int winningCount){
        StringBuffer correctInfo = new StringBuffer(winning.getCorrectCount() + "개 일치");

        if(winning == WINNING.SECOND)
            correctInfo.append(", 보너스 볼 일치");

        correctInfo.append(" ("
                + winning.getValue() + "원) - "
                + winningCount + "개");

        System.out.println(correctInfo);
    }
}