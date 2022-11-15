package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startLotto();
    }

    public static void startLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        User.buyLotto();
        getLotto();
    }

    public static void getLotto() {
        User.makeLotto();
        inputGuess();
    }

    public static void inputGuess() {
        System.out.println("당첨 번호를 입력해 주세요.");
        User.guessLotto();
        inputBonus();
    }

    public static void inputBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        User.guessBonus();
        getResult();
    }

    public static void getResult() {
        Raffle.statistics();
    }
}
