package lotto.utils;

public enum ResultMessage {
    THREE_CORRECT_NUMBERS("3개 일치 (5,000원) - %d개", 3, 0, false, 5000),
    FOUR_CORRECT_NUMBERS("4개 일치 (50,000원) - %d개", 4, 0, false, 50000),
    FIVE_CORRECT_NUMBERS("5개 일치 (1,500,000원) - %d개", 5, 0, false, 1500000),
    FIVE_CORRECT_NUMBERS_AND_BONUS_NUMBER("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 5, 0, true, 30000000),
    SIX_CORRECT_NUMBERS("6개 일치 (2,000,000,000원) - %d개", 6, 0, false, 2000000000),
    ;

    private final String message;
    private final int correctStandard;
    private int countResult;
    private final boolean checkBonusNum;

    private final int money;

    ResultMessage(String message,
                  int correctStandard,
                  int countResult,
                  boolean checkBonusNum,
                  int money) {
        this.message = message;
        this.correctStandard = correctStandard;
        this.countResult = countResult;
        this.checkBonusNum = checkBonusNum;
        this.money = money;
    }

    public static void increaseCountResult(int countResult, boolean bonusNum) {
        for (ResultMessage value : ResultMessage.values()) {
            if (value.correctStandard == countResult && value.checkBonusNum == bonusNum) {
                value.countResult++;
            }
        }
    }

    public static void printLottoCountResult() {
        for (ResultMessage result : ResultMessage.values()) {
            String singleMessage = String.format(result.message, result.countResult);
            System.out.println(singleMessage);
        }
    }
}
