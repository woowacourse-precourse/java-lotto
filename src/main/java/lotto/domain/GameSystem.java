package lotto.domain;

public class GameSystem {

    public static void startGame() {
        System.out.println("구입 금액을 입력해 주세요.");

        User user = new User();
        Computer computer = new Computer();

        try {
            //1. 사용자 로또 번호 입력
            user.pickLottoNumbers();

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
