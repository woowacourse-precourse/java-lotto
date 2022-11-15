package lotto.domain;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class GameSystem {

    public static void startGame() {

        /* Domain */
        User user = new User();
        Computer computer = new Computer();

        /* Game Component */
        int gameCount = 0;
        List<Lotto> lottoGames = new ArrayList<>();

        System.out.println("구입 금액을 입력해 주세요.");

        try {
            //1. 사용자 로또 번호 입력
            user.pickLottoNumbers();

            //2. 컴퓨터 생성 로또 번호 저장
            gameCount = user.getGameCount();
            lottoGames = computer.getLottoGames(gameCount);

            //3. 컴퓨터가 생성한 로또 번호 출력
            printGeneratedLottoNumbers(lottoGames);

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public static void printGeneratedLottoNumbers(List<Lotto> lottoGames) {
        System.out.println("\n" + lottoGames.size() +"개를 구매했습니다.");

        for(Lotto game : lottoGames) {
            System.out.println(game.getNumbers());
        }
    }

}
