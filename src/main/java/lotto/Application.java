package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoSystem lottoSystem = new LottoSystem();
        try {
            lottoSystem.loop();
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 출력해야 함
        }
    }
}
