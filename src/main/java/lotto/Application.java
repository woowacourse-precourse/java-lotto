package lotto;

import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        try{
            new LottoService().play();
        }catch (IllegalArgumentException except){
            System.out.println(except.getMessage());
        }
    }
}
