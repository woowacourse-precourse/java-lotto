package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller lottoController = new Controller();
        try{
            lottoController.execute();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
