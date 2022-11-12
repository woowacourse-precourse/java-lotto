package lotto;

import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try{
            new LottoService().play();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
