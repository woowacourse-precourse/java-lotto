package lotto;

public class View {
    final String Cost = "구입금액을 입력해 주세요.";
    final String Winning = "당첨 번호를 입력해 주세요.";
    final String Bonus = "보너스 번호를 입력해 주세요.";
    void startMention() {
        System.out.println(Cost);
    }

    void purchaseNumber(int number, Computer[] computers) {
        System.out.println(number + "개를 구매했습니다.");
        for (Computer cp : computers) System.out.println(cp);
    }

    void inputNumber() {
        System.out.println(Winning);
    }

    void inputBonus() {
        System.out.println(Bonus);
    }

    void printResult(int[] list) {
        int index = 7;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Money value : Money.values()) {
            System.out.println(value.getMoneyString() + list[index--] + "개");
        }
    }

    void printBenfit(int input, long result) {
        double db = (double) result / input * 100;
        String answer = String.format("%.1f", db);
        System.out.println("총 수익률은 " + answer + "%입니다.");
    }
}
