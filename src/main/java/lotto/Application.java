package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    // TODO : Enum class 활용하기
    static Game gameData = new Game();

    static StringBuilder sb = new StringBuilder();

    static List<Lotto> lottos = new ArrayList<>();

    final static int LOTTO_PRICE = 1000;

    final static int MIN = 1;

    final static int MAX = 45;

    final static int NUMBER_SIZE = 6;

    public static void main(String[] args) {
        saveInput();
        calculateWinnings();
        calculateRate();
    }

    public static void saveInput(){
        System.out.println("구입금액을 입력해 주세요.");
        gameData.changeMoney( Console.readLine() );
        gameData.changeLottoCount(gameData.getMoney() / LOTTO_PRICE);
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
        }
    }

    public static void calculateWinnings(){
        sb.append("당첨 통계\n---\n");

        for(Lotto lotto : lottos){
            List<Integer> sameNumbers = sameWith(lotto.getNumbers());
            final boolean hasBonus = sameNumbers.contains(gameData.getBonusNumber());
            setWinnings(sameNumbers.size(), hasBonus);
        }
        printLottos();
        printWinnings();
    }

    private static List<Integer> sameWith(List<Integer> numbers){
        final List<Integer> winningNumbers = gameData.getWinningNumbers();
        return numbers.stream()
                .filter(
                        num -> winningNumbers.stream().anyMatch((Predicate.isEqual(num)))
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

    private static void printWinnings(){
        sb.append("3개 일치 (5,000원) - ")
                .append(gameData.getHitThree())
                .append("개\n4개 일치 (50,000원) - ")
                .append(gameData.getHitFour())
                .append("개\n5개 일치 (1,500,000원) - ")
                .append(gameData.getHitFive())
                .append("개\n5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(gameData.getHitFiveAndBonus())
                .append("개\n6개 일치 (2,000,000,000원) - ")
                .append(gameData.getHitSix())
                .append("개\n");
        System.out.println(sb.toString());
    }

    public static void calculateRate(){
        int earnMoney = (gameData.getHitThree() * 5000) + (gameData.getHitFour() * 50000) +
                (gameData.getHitFive() * 1500000) + (gameData.getHitFiveAndBonus() * 30000000)
                + (gameData.getHitSix() * 2000000000);
        double rate = ((double) earnMoney / gameData.getMoney() ) * 100;
        System.out.println("총 수익률은 "+ String.format("%.1f", rate) + "%입니다.");
    }

    private static void printLottos(){
        for(Lotto lotto : lottos){
            sb.append(lotto.getNumbers()).append("\n");
        }
    }
}
