package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Manager Wooteco = new Manager();
        Player swJeong98 = new Player(Wooteco);
        swJeong98.LottoGamestart();
    }
}
