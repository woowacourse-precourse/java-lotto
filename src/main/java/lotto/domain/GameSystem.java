package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameSystem {

    public static void startGame() {

        /* Domain */
        User user = new User();
        Computer computer = new Computer();
        Game game = new Game(user, computer);

        /* Game Component */
        int gameCount = 0; // 유저가 구매한 로또 개수
        List<Integer> ranks = new ArrayList<>(); // 로또의 각 등수
        int[] counts = new int[5]; // 각 로또마다, 해당 로또의 1~5등 당첨 개수


        //1. 게임 시작 문구 출력
        System.out.println("구입 금액을 입력해 주세요.");

        try {
            //2. 사용자 로또 번호 입력
            user.enterLottoBuyAmount();

            //3. 컴퓨터 생성 로또 번호 저장
            gameCount = user.getGameCount();
            user.setBuyLottos(computer.getLottoGames(gameCount));

            //4. 컴퓨터가 생성한 로또 번호 출력
            printGeneratedLottoNumbers(user.getUserLottos());

            //5. 당첨 번호 입력
            System.out.println("당첨 번호를 입력해 주세요.");
            game.enterWinningNumber();

            //6. 보너스 번호 입력
            System.out.println("보너스 번호를 입력해 주세요.");
            game.enterBonusNumber();

            //7. 등수 확인
            ranks = game.discriminateRanking();
            counts = game.getRankCount(ranks);
            printLottoRank(ranks, counts);

            //8. 수익률 확인
            printYield(game.getYield(counts));

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

    /**
     * 로또 당첨 결과를 요구사항 포맷에 맞게 출력해주는 함수
    **/
    public static void printLottoRank(List<Integer> ranks, int[] counts) {
        List<String> prizeMoney = new ArrayList<>(Arrays.asList("2,000,000,000원", "30,000,000원", "1,500,000원", "50,000원", "5,000원"));
        List<String> matchNumber = new ArrayList<>(Arrays.asList("6", "5", "5", "4", "3"));

        System.out.println("당첨 통계\n---");

        for(int i = 4 ; i >= 0 ; i--) {

            if(i != 1) // 2등이 아닐 때
                System.out.println(matchNumber.get(i) + "개 일치 (" + prizeMoney.get(i) + ") - " + counts[i+1] + "개");
            else // 2등일 때
                System.out.println(matchNumber.get(i) + "개 일치, 보너스 볼 일치 (" + prizeMoney.get(i) + ") - " + counts[i+1] + "개");

        }

    }

    /**
     * 로또 수익률을 요구사항 포맷에 맞게 출력해주는 함수
     **/
    public static void printYield(String yield) {
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }

}
