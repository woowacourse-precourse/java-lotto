package lotto;

public class View {
    void startMention() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    void purchaseNumber(int number, Computer[] computers) {
        System.out.println(number + "개를 구매했습니다.");
        for (Computer cp : computers) System.out.println(cp);
    }

    void inputNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    void inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    void printResult(int[] list) {
        int index = 0;
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Money value : Money.values()) {
            System.out.println(value.getMoney() + list[index++] + "개");
        }
    }

    void printBenfit(int input, int result) {
        double db = (double) result / input * 100;
        String answer = String.format("%.1f", db);
        System.out.println("총 수익률은 " + answer + "%입니다.");
    }
}
