package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    static Game gameData;

    static List<Lotto> lottos;
    final static int LOTTO_PRICE = 1000;

    final static int MIN = 1;

    final static int MAX = 45;

    final static int NUMBER_SIZE = 6;

    public static void main(String[] args) {
        saveInput();
//        gameStart();
        calculateWinning();
        calculateRate();
        // TODO: 프로그램 구현
    }

//    public static void gameStart(){
//        //TODO: 게임 시작 구현
//        int gameTurn = gameData.getLottoCount();
//        while(gameTurn > 0){
//
//            if(){
//                gameTurn--;
//            }
//        }
//    }

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

    public static void calculateWinnings(){
        //TODO: 당첨 내역 계산 구현
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n---\n");

        for(Lotto lotto : lottos){
            List<Integer> sameNumbers = sameWith(lotto.getNumbers());
            final int winningCount = sameNumbers.size();
            final boolean hasBonus = sameNumbers.contains(gameData.getBonusNumber());

        }
//        3개 일치 (5,000원) - 1개
//        4개 일치 (50,000원) - 0개
//        5개 일치 (1,500,000원) - 0개
//        5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//        6개 일치 (2,000,000,000원) - 0개

    }

    private static List<Integer> sameWith(List<Integer> numbers){
        final List<Integer> winningNumbers = gameData.getWinningNumbers();
        return numbers.stream()
                .filter(
                        num -> winningNumbers.stream().allMatch((Predicate.isEqual(num)))
                )
                .collect(Collectors.toList());

    }

    private static void setWinnings(int winningCount, boolean hasBonus){
        if(winningCount == 6 ) gameData.changehitSix(gameData.getHitSix()+1);
        if(winningCount == 5 && hasBonus) gameData.changehitFiveAndBonus(gameData.getHitFiveAndBonus()+1);
        if(winningCount == 5 && !hasBonus) gameData.changehitFive(gameData.getHitFive()+1);
        if(winningCount == 4 ) gameData.changehitFour(gameData.getHitFour()+1);
        if(winningCount == 3 ) gameData.changehitThree(gameData.getHitThree()+1);
    }
    public static void calculateRate(){
        //TODO: 수익률 계산 구현
    }

}
