package lotto;

import lotto.controller.LottoController;

public class Application {
    private static final String ERROR = "[ERROR]";
    public static void main(String[] args) {
        LottoController lottoController = LottoController.create();
        try{
            lottoController.run();
        } catch (Exception e){
            System.out.println(ERROR + e.getMessage());
        }
    }
}