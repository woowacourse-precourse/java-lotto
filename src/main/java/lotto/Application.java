package lotto;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.create(new LottoStore());
        try {
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
