package lotto;

public class Application {
    public static void main(String[] args) {
        try {
            LottoService lottoService = new LottoService();
            lottoService.play();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
