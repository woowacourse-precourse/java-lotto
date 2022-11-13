package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

enum Rank{
    FIRST(6),SECOND(5),THIRD(5),FOURTH(4),FIFTH(3),MISS(0);
    private int correctNumber;
    public int getCorrectNumber(){
        return correctNumber;
    }
    Rank(int correctNumber){
        this.correctNumber = correctNumber;
    }

    public static Rank getRank(int correctNumber,boolean bonusCheck){

        if(correctNumber == FIRST.getCorrectNumber())
            return FIRST;
        if(correctNumber == SECOND.getCorrectNumber() && bonusCheck)
            return SECOND;
        if(correctNumber == THIRD.getCorrectNumber() && !bonusCheck)
            return THIRD;
        if(correctNumber == FOURTH.getCorrectNumber())
            return FOURTH;
        if(correctNumber == FIFTH.getCorrectNumber())
            return FIFTH;
        return MISS;
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
    static int winMoney = 0;
    static double winRate = 0.0;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        buyLotto();

        tickets = ticketCal(pay);

        getLottoNumber(tickets);
        printLotto();

        inputWinningNumber();
        inputBonus();
        compareNumber(allLottoNumbers);

        printWinMessage();
        resultLotto();

        calWinMoney();
        winRate = calYield();
        printYield();
    }
    public static void buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        pay = Integer.parseInt(Console.readLine());
        buyException(pay);
    }
    public static void buyException(int pay){
        if(pay%1000!=0)
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }

    public static int ticketCal(int pay){
        int ticketNumber = 0;
        ticketNumber = pay/1000;
        System.out.println(ticketNumber+"개를 구매했습니다.");
        return pay/1000;
    }

    public static void printLotto(){
        int printLottoNumber[] = new int[6];
        for(int i=0;i<allLottoNumbers.size();i++){
            for(int j=0;j<6;j++){
                printLottoNumber[j]= allLottoNumbers.get(i).get(j);
            }
            Arrays.sort(printLottoNumber);
            System.out.println(Arrays.toString(printLottoNumber));
        }
    }

    public static void getLottoNumber(int tickets) {
        for (int i = 0; i < tickets; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Collections.sort(lottoNumbers);
            allLottoNumbers.add(lottoNumbers);
        }
    }

    public static void inputWinningNumber(){
        String inputNumber;
        String[] processNumber;
        System.out.println("당첨 번호를 입력해 주세요.");

        inputNumber = Console.readLine();
        inputNumberException();
        processNumber = inputNumber.split(",");

        for(int i=0;i<processNumber.length;i++){
            winningNumber.add(Integer.parseInt(processNumber[i]));
        }
        Collections.sort(winningNumber);
        inputWinningNumberException();

    }

    public static void inputWinningNumberException(){
        for(int i=0;i<winningNumber.size();i++){
            if(winningNumber.get(i)<1||winningNumber.get(i)>45)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        for(int i=0;i<winningNumber.size()-1;i++){
            if(winningNumber.get(i)==winningNumber.get(i+1))
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복 되어서는 안됩니다.");
        }
    }

    public static void inputNumberException(){}


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
        System.out.println("3개 일치 (5,000원) - " + rankMap.get(Rank.FIFTH)+"개");
        System.out.println("4개 일치 (50,000원) - " + rankMap.get(Rank.FOURTH)+"개");
        System.out.println("5개 일치 (1,500,000원) - " + rankMap.get(Rank.THIRD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankMap.get(Rank.SECOND)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankMap.get(Rank.FIRST)+"개");
    }

    public static void calWinMoney(){
        winMoney += 5000 * rankMap.get(Rank.FIFTH);
        winMoney += 50000 * rankMap.get(Rank.FOURTH);
        winMoney += 1500000 * rankMap.get(Rank.THIRD);
        winMoney += 30000000 * rankMap.get(Rank.SECOND);
        winMoney += 2000000000 * rankMap.get(Rank.FIRST);
    }

    public static double calYield(){
        return ((double)winMoney/pay)*100.0;
    }

    public static void printYield(){
        String result = String.format("%.1f",winRate);
        System.out.println("총 수익률은 " + result + "%입니다.");
    }
}
