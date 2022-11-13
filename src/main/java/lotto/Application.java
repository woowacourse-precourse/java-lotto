package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

enum Rank{
    FIRST(6),SECOND(5),THIRD(5),FOURTH(4),FIFTH(3);
    final private int correctNumber;
    public int getCorrectNumber(){
        return correctNumber;
    }
    private Rank(int correctNumber){
        this.correctNumber = correctNumber;
    }

    public Rank getRank(final int correctNumber,boolean bonusCheck){
        if(correctNumber == FIRST.getCorrectNumber())
            return FIRST;
        if(correctNumber == SECOND.getCorrectNumber())
            return SECOND;
        if(correctNumber == THIRD.getCorrectNumber() && !bonusCheck)
            return THIRD;
        if(correctNumber == FOURTH.getCorrectNumber())
            return FOURTH;

        return FIFTH;
    }
}
public class Application {
    static int pay = 0;
    static int tickets = 0;
    static List<List<Integer>> allLottoNumbers = new ArrayList<>();
    static List<Integer> winningNumber = new ArrayList<>();
    static int bonus = 0;
    static Rank rank;
    static Rank rankName;
    static boolean bonusCheck = false;
    static Map<Rank,Integer> rankMap = new EnumMap<>(Rank.class);
    static Stack<String> printResult = new Stack<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        buyLotto();
        tickets = ticketCal(pay);
        getLottoNumber(tickets);
        sortLottoNumber();
        inputWinningNumber();
        inputBonus();
        compareNumber(allLottoNumbers);

        printWinMessage();
        resultLotto();
    }
    public static void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        pay = Integer.parseInt(Console.readLine());
    }

    public static int ticketCal(int pay){
        int ticketNumber = 0;
        ticketNumber = pay/1000;
        System.out.println(ticketNumber+"개를 구매했습니다.");
        return pay/1000;
    }

    public static void getLottoNumber(int tickets){
        for(int i=0;i<tickets;i++){
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            allLottoNumbers.add(lottoNumbers);
        }
    }

    public static void sortLottoNumber(){
        for(int i=0;i<allLottoNumbers.size();i++){
            Collections.sort(allLottoNumbers.get(i));
        }
    }

    public static void inputWinningNumber(){
        String inputNumber;
        String[] processNumber;
        System.out.println("당첨 번호를 입력해 주세요.");

        inputNumber = Console.readLine();
        processNumber = inputNumber.split(",");

        for(int i=0;i<processNumber.length;i++){
            winningNumber.add(Integer.parseInt(processNumber[i]));
        }

        Collections.sort(winningNumber);
    }

    public static void inputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        bonus = Integer.parseInt(Console.readLine());
    }

    public static void compareNumber(List<List<Integer>> allLottoNumbers){
        int count = 0;
        initRankMap();
        for(int i=0;i<allLottoNumbers.size();i++){
            count = 0;
            bonusCheck = false;
            Lotto lotto = new Lotto(allLottoNumbers.get(i));
            count = lotto.compareNumber(winningNumber);
            if(count==5){
                bonusCheck = lotto.checkBonus(bonus);
            }
            rankName = rank.getRank(count,bonusCheck);
            rankMap.put(rankName, rankMap.getOrDefault(rankName,0)+1);
        }
    }

    public static void initRankMap(){
        for(Rank r : Rank.values()){
            rankMap.put(r,0);
        }
    }

    public static void printWinMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void resultLotto(){
        System.out.println("3개 일치 (5,000원) - " + rankMap.get(Rank.FIFTH));
        System.out.println("4개 일치 (50,000원) - " + rankMap.get(Rank.FOURTH));
        System.out.println("5개 일치 (1,500,000원) - " + rankMap.get(Rank.THIRD));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankMap.get(Rank.SECOND));
        System.out.println("6개 일치 (2,000,000,000원) - " + rankMap.get(Rank.FIRST));
    }


}
