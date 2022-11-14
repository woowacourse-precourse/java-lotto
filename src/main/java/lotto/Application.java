package lotto;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager = new LottoManager();
        try {
            lottoManager.buyLotto();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
