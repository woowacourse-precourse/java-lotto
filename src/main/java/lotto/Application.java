package lotto;

import lotto.controller.Lotto_Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Lotto_Controller lotto_controller = new Lotto_Controller();
        try {
            lotto_controller.start_Lotto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}