package lotto;

public class Application {
    public static void main(String[] args) {
        LottoApplication lottoApplication = new LottoApplication();
        try {
            lottoApplication.run();
        }catch (IllegalArgumentException e){

        }

    }
}
