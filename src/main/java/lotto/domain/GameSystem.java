package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class GameSystem {

    public static void startGame() {

        /* Domain */
        User user = new User();
        Computer computer = new Computer();
        Game game = new Game(user, computer);

        /* Game Component */
        int gameCount = 0;
        List<Lotto> lottoGames = new ArrayList<>();

        //1. 게임 시작 문구 출력
        System.out.println("구입 금액을 입력해 주세요.");

        try {
            //2. 사용자 로또 번호 입력
            user.enterLottoBuyAmount();

            //3. 컴퓨터 생성 로또 번호 저장
            gameCount = user.getGameCount();
            lottoGames = computer.getLottoGames(gameCount);

            //4. 컴퓨터가 생성한 로또 번호 출력
            printGeneratedLottoNumbers(lottoGames);

            //5. 당첨 번호 입력
            System.out.println("당첨 번호를 입력해 주세요.");
            game.enterWinningNumber();

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
