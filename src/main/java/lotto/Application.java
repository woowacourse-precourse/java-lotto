package lotto;


import lotto.Controller.LottoController;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.lottoStart();
        } catch (IllegalArgumentException e){
            System.out.println("시스템을 종료합니다.");
        }//try-catch
    }// main
}// end class
