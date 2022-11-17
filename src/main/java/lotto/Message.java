package lotto;

public enum Message {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTERY_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE("개를 구매했습니다."),
    CORRECT_THREE("3개 일치 (5,000원) - "),
    CORRECT_FOUR("4개 일치 (50,000원) - "),
    CORRECT_FIVE("5개 일치 (1,500,000원) - "),
    CORRECT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    CORRECT_SIX("6개 일치 (2,000,000,000원) - "),
    PROFIT("총 수익률은 "),
    STATISTICS("당첨 통계"),
    BOUNDARY_LINE("---"),
    BLANK_LINE("");


    final String msg;

    Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }

    void printResult(long count) {
        System.out.println(this.msg + count + "개");
    }

    void print() {
        System.out.println(msg);
    }

    void printProfit(double profit) {
        System.out.printf("%s%.1f%%입니다.", msg, profit);
    }

    void printPurchase(long quantity) {
        String message = String.format("%d%s", quantity, msg);
        System.out.println(message);
    }
}
