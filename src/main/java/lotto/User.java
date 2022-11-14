package lotto;

import java.lang.reflect.Array;
import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    static final String NUMBER_OF_LOTTO_MESSAGE = "개를 구매했습니다.";
    static final String LOTTO_PRICE_MESSAGE = "구입 금액을 입력해주세요.";
    static final String FIRST_PLACE_MESSAGE = "6개 일치 (2,000,000,000원) - ";
    static final String SECOND_PLACE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    static final String THIRD_PLACE_MESSAGE = "5개 일치 (1,500,000원) - ";
    static final String FOURTH_PLACE_MESSAGE = "4개 일치 (50,000원) - ";
    static final String FIFTH_PLACE_MESSAGE = "3개 일치 (5,000원) - ";
    static final String TOTAL_MESSAGE = "당첨 통계\n---";
    static final String UNIT_MESSAGE = "개";
    static final String PROFIT_PERCENTAGE_MESSAGE = "총 수익률은 ";
    static final String PROFIT_PERCENTAGE_PERCENT_MESSAGE = "%입니다.";
    public static List<Lotto> lottos;
    int numberOfLotto;
    List<Integer> winningNumbers;
    int bonusNumber;

    int[] winningCount = new int[5];
    public static EnumMap<Application.Places,Integer> winnings;


    long totalWinnings;

    static int totalPrice;
    static double profitPercentage;
    public User() {
        System.out.println(LOTTO_PRICE_MESSAGE);
        numberOfLotto = getNumberOfLotto();

        lottos = getlottos(numberOfLotto);
        printLottos(numberOfLotto,lottos);

        winnings = new EnumMap<>(Application.Places.class); // 1~5등까지 로또 몇개가 들어있는 지 저장
        compareLottosToWinningNumbers();

        totalWinnings = calculateWinnings();
        profitPercentage = calculateProfitPercentage();

        printTotalWinning();
        printProfitPercentage();
        }


    public static int getNumberOfLotto() {
        String price = readLine();

        // 예외 검사 실시 - 순서대로 - "사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다."
        // 1. 숫자로만 이루어졌어?
        // 2. 1000원으로 나누어 떨어져?
        // 3.  --  또 있나 생각해보기  --
        // 따로 메서드 만들어서 test하기!! -> 구현할 기능 목록에도 추가하기
        totalPrice = Integer.parseInt(price);

        int numberOfLotto = totalPrice / 1000;
        return numberOfLotto;
    }

    public static List<Integer> getLottoNumbers() { // 랜덤으로 6개의 숫자 뽑기
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        // sort
        return numbers;
    }

    public static List<Lotto> getlottos(int numberOfLotto) {
        List<Lotto> newLottos = new ArrayList<Lotto>();

        for(int i=0;i<numberOfLotto;i++) newLottos.add(new Lotto(getLottoNumbers()));

        return newLottos;
    }

    public static void printLottos(int numberOfLotto,List<Lotto> lottos){
        System.out.println( numberOfLotto + NUMBER_OF_LOTTO_MESSAGE);
        for(int orderOfLottos=0;orderOfLottos<lottos.size();orderOfLottos++) System.out.println(lottos.get(orderOfLottos));
    }

    public void compareLottosToWinningNumbers(){
        Lotto lotto;
        List<Integer> lottoNumbers;
        int matchingPoint=0;
        boolean matchingBonusPoint;
        for(int order=0;order<lottos.size();order++){
            lotto = lottos.get(order);
            lottoNumbers = lotto.getLottoNumbers();
            matchingPoint = countCoincidentNumber(lottoNumbers,winningNumbers);
            matchingBonusPoint = countBonusNumber(lottoNumbers,bonusNumber);
            // 이제 matchingPoint 에 따라 enumMap의 key에 넣을 값을 결정하면 됨
            countPlaces(matchingPoint,matchingBonusPoint);
        }
    }
    public static int countCoincidentNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        int winningNumber;
        int countMatching=0;
        for(int i=0;i<winningNumbers.size();i++){
            winningNumber = winningNumbers.get(i);
            if(lottoNumbers.contains(winningNumber)) countMatching++;
        }
        return countMatching;
    }
    public boolean countBonusNumber(List<Integer> lottoNumbers,int bonusNumber){
        if(lottoNumbers.contains(bonusNumber)) return true;

        return false;
    }
    public void countPlaces(int matchingPoint,boolean matchingBonusPoint){
        if(matchingPoint == 6) winnings.put(Application.Places.FIRST,winnings.get(Application.Places.FIRST)+1);
        if(matchingPoint == 5 && matchingBonusPoint == true) winnings.put(Application.Places.SECOND,winnings.get(Application.Places.SECOND)+1);
        if(matchingPoint == 5 && matchingBonusPoint == false) winnings.put(Application.Places.THIRD,winnings.get(Application.Places.THIRD)+1);
        if(matchingPoint == 4) winnings.put(Application.Places.FOURTH,winnings.get(Application.Places.FOURTH)+1);
        if(matchingPoint == 3) winnings.put(Application.Places.FIFTH,winnings.get(Application.Places.FIFTH)+1);
        if(matchingPoint <= 2) winnings.put(Application.Places.OTHERS,winnings.get(Application.Places.OTHERS)+1);
    }
    public long calculateWinnings(){
        return (winnings.get(Application.Places.FIRST)*2000000000) + (winnings.get(Application.Places.SECOND) * 30000000)
                + (winnings.get(Application.Places.THIRD) * 1500000) + (winnings.get(Application.Places.FOURTH) * 50000)
                + (winnings.get(Application.Places.FIFTH) * 5000);
    }
    public double calculateProfitPercentage(){
        return (totalWinnings / totalPrice ) * 100;
    }
    public void getWinningNumbers(List<Integer> winningNumbers){
        this.winningNumbers = winningNumbers;
    }
    public void getBonusNumbers(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }
    public void printTotalWinning(){
        System.out.println(TOTAL_MESSAGE);
        System.out.println(FIFTH_PLACE_MESSAGE +winnings.get(Application.Places.FIFTH) + UNIT_MESSAGE ) ;
        System.out.println(FOURTH_PLACE_MESSAGE +winnings.get(Application.Places.FOURTH) + UNIT_MESSAGE );
        System.out.println(THIRD_PLACE_MESSAGE +winnings.get(Application.Places.THIRD) + UNIT_MESSAGE );
        System.out.println(SECOND_PLACE_MESSAGE +winnings.get(Application.Places.SECOND) + UNIT_MESSAGE );
        System.out.println(FIRST_PLACE_MESSAGE +winnings.get(Application.Places.FIRST) + UNIT_MESSAGE );

    }
    public void printProfitPercentage(){
        System.out.println(PROFIT_PERCENTAGE_MESSAGE + profitPercentage + PROFIT_PERCENTAGE_PERCENT_MESSAGE);
    }
}
