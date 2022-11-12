package lotto;

import lotto.model.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        try { lottoService.playLotto();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
