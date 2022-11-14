package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static Game gameData;

    static List<Lotto> lottos;
    final static int LOTTO_PRICE = 1000;

    final static int MIN = 1;

    final static int MAX = 45;

    final static int NUMBER_SIZE = 6;
    public static void main(String[] args) {
        saveInput();
        gameStart();
        // TODO: 프로그램 구현
    }

    public static void gameStart(){
        //TODO: 게임 시작 구현
        int gameTurn = gameData.getLottoCount();
        while(gameTurn > 0){


            gameTurn--;
        }
    }

    public static void saveInput(){
        System.out.println("구입금액을 입력해 주세요.");
        Integer money = Integer.valueOf(Console.readLine());
        gameData.changeLottoCount(money / LOTTO_PRICE);
        System.out.println(gameData.getLottoCount()+"개를 구매했습니다.");

        publishLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNumbers = Console.readLine().split(",");
        List<Integer> winning = new ArrayList<>();
        for(String number : winningNumbers){
            winning.add(Integer.parseInt(number));
        }

        gameData.changeWinningNumbers(winning);

        System.out.println("보너스 번호를 입력해 주세요.");
        gameData.changeBonusNumber(Integer.parseInt(Console.readLine()));
    }

    public static void publishLotto(){
        for(int i=1; i <= gameData.getLottoCount() ; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, NUMBER_SIZE);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);

            System.out.println(numbers);
        }
        //TODO: 로또 발행 구현
    }

    public void calculateWinning(){
        //TODO: 당첨 내역 계산 구현
    }

    public void calculateRate(){
        //TODO: 수익률 계산 구현
    }

}
