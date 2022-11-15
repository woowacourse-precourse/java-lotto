package lotto;

import lotto.view.LottoGame;

public class Application {
    public static void main(String[] args) {
        try {
            LottoGame lottoGame = new LottoGame();
            lottoGame.start();  // 프로그램 실행
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 발생시, 에러 메세지 출력
        }
    }
}
