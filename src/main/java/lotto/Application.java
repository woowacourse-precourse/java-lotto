package lotto;

public class Application {

    public static void main(String[] args) {
        LottoGameServiceImpl lottoGameService = new LottoGameServiceImpl();
        try {
            lottoGameService.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
