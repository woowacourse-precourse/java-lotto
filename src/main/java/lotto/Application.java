package lotto;

import lotto.domain.LottoSystem;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        try{
            lottoSystem.run();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
