package lotto;

import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        try {
            new LottoService().lottery();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
