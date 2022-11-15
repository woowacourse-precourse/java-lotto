package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoSystem lottosystem = LottoSystem.start();
            lottosystem.result();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
