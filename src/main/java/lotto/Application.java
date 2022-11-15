package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static int money;   // 돈 액수
    static int[] correctNums;   // 당첨 번호 리스트
    static int bonusNum;    // 보너스 번호

    static int cntLotto;    // 로또 수량
    static List<Lotto> lottoList = new ArrayList<>();  // 생성한 로또들의 목록

    // 로또 번호 1개의 결과 타입
    enum compareType{Three, Four, FiveOnly, FiveAndBonus, Six};

    // countCompareType[Three] : Three 결과인 로또의 갯수
    static int[] countCompareType = new int[6];

    // moneyCompareType[Three] : Three 결과에 해당하는 상금
    static int[] moneyCompareType = {
            5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000 };

    /**
     * 중복값 없이 1부터 45 까지의 난수 6개로 이루어진 리스트를 생성해 반환한다.
     */
    static List<Integer> createRandomNumberList(){
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return nums;
    }

    /**
     * 입력받은 난수 리스트들을 오름차순으로 정렬해 반환한다.
     */
    static List<Integer> sortRandomNumberList(List<Integer> randomNumberList){
        ArrayList<Integer> sortNumbers = new ArrayList<>(randomNumberList);
        Collections.sort(sortNumbers);
        return randomNumberList;
    }

    /**
     * 로또 1장을 생성해 Lotto를 반환한다.
     */
    static Lotto createLottoOne(){
        return new Lotto(sortRandomNumberList(createRandomNumberList()));
    }

    /**
     * cntLotto 의 개수만큼 로또를 생성한다.
     */
    static void createLottoList(){
        cntLotto = money / 1000;
        for(int i = 0; i < cntLotto; i++){
            lottoList.add(createLottoOne());
        }
    }

    /**
     * 발행한 로또 수량 및 번호를 출력한다.
     * 로또 번호는 오름차순으로 정렬하여 보여준다.
     */
    static void printLotto(){
        System.out.println(cntLotto + "개를 구매했습니다.");   // 로또 수량 출력
        for(int i = 0; i < cntLotto; i++){
            lottoList.get(i).printNumbers();
        }
        System.out.println();
    }

    /**
     * 숫자를 입력받아 1000으로 나누어 떨어지지 않을 경우 예외 처리
     * @param num
     */
    static void checkCanDivideBy1000(int num){
        if(num % 1000 != 0){
            System.out.println("[ERROR] 1000원 단위의 금액을 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 로또 당첨 번호 일치 개수, 보너스 일치 여부를 입력받아
     * 로또 당첨 통계 결과를 세팅한다.
     */
    static void setResultOfLotto(int countCorrectNumbers, boolean sameWithBonumNum){
        if(countCorrectNumbers < 3) return;
        if(countCorrectNumbers == 3){
            countCompareType[compareType.Three.ordinal()] += 1;
            return;
        }
        if(countCorrectNumbers == 4){
            countCompareType[compareType.Four.ordinal()] += 1;
            return;
        }
        if(countCorrectNumbers == 5 && !sameWithBonumNum){
            countCompareType[compareType.FiveOnly.ordinal()] += 1;
            return;
        }
        if(countCorrectNumbers == 5 && sameWithBonumNum){
            countCompareType[compareType.FiveOnly.ordinal()] += 1;
            return;
        }
        countCompareType[compareType.Six.ordinal()] += 1;
    }

    /**
     * 각 로또의 당첨 통계를 낸다.
     */
    static void setResultOfLottoList(){
        for(Lotto lotto : lottoList){
            int countCorrectNumbers = lotto.getCountCorrectNumbers(correctNums);
            boolean sameWithBonumNum = lotto.isSameWithBonumNum(bonusNum);
            setResultOfLotto(countCorrectNumbers, sameWithBonumNum);
        }
    }

    /**
     * 로또 당첨 총 수익률을 반환한다.
     * 파라미터로 사용자가 사용한 금액을 입력받는다.
     */
    static double getYield(int money){
        double sum = 0;    // 총 벌어들인 금액
        System.out.println("countCompareType[compareType.Three.ordinal()] = " + countCompareType[compareType.Three.ordinal()]);
        System.out.println("compareType.Three.ordinal() = " + compareType.Three.ordinal());
        System.out.println(" moneyCompareType[compareType.Three.ordinal()] = " +  moneyCompareType[compareType.Three.ordinal()]);
        sum += countCompareType[compareType.Three.ordinal()] * moneyCompareType[compareType.Three.ordinal()];
        sum += countCompareType[compareType.Four.ordinal()] * moneyCompareType[compareType.Four.ordinal()];
        sum += countCompareType[compareType.FiveOnly.ordinal()] * moneyCompareType[compareType.FiveOnly.ordinal()];
        sum += countCompareType[compareType.FiveAndBonus.ordinal()] * moneyCompareType[compareType.FiveAndBonus.ordinal()];
        sum += countCompareType[compareType.Six.ordinal()] * moneyCompareType[compareType.Six.ordinal()];
        return (double)Math.round((sum*10000) / money) / 100;
    }

    /**
     * 로또 당첨 통계 결과를 출력한다.
     */
    static void printResult(int money){
        System.out.println(
                "당첨 통계\n" +
                "---\n" +
                "3개 일치 (5,000원) - " + countCompareType[compareType.Three.ordinal()] + "개\n" +
                "4개 일치 (50,000원) - " + countCompareType[compareType.Four.ordinal()] + "개\n" +
                "5개 일치 (1,500,000원) - " + countCompareType[compareType.FiveOnly.ordinal()] + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + countCompareType[compareType.FiveAndBonus.ordinal()] + "개\n" +
                "6개 일치 (2,000,000,000원) - " + countCompareType[compareType.Six.ordinal()] + "개\n" +
                "총 수익률은 " + getYield(money)+ "%입니다."
        );
    }

    public static int makeStringToInt(String sentence){
        try{
            return Integer.parseInt(sentence);
        }catch(NumberFormatException numberFormatException){
            System.out.println("[ERROR] 숫자를 입력하셔야 합니다.");
            return 0;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력
        System.out.println("구입 금액을 입력해주세요");
        String userInput = Console.readLine();
        money = makeStringToInt(userInput);
        System.out.println();

        // 1000원으로 나누어 떨어지지 않는 경우 예외 처리
        checkCanDivideBy1000(money);

        // 사용자가 입력한 금액/1000만큼의 로또를 생성한다.
        createLottoList();

        // 발행한 로또 수량 및 번호를 출력. 로또 번호는 오름차순으로 정렬해서 보여준다.
        printLotto();

        // 당첨 번호를 입력
        System.out.println("당첨 번호를 입력해주세요");
        userInput = Console.readLine();
        String[] splitedNumbers = userInput.split(",");
        System.out.println();

        correctNums = Arrays.stream(splitedNumbers)
                .mapToInt(Integer::parseInt)
                .toArray();

        // 보너스 번호 입력
        System.out.println("보너스 번호를 입력해주세요");
        userInput = Console.readLine();
        bonusNum = makeStringToInt(userInput);
        System.out.println();

        // 각 로또의 당첨 통계 설정
        setResultOfLottoList();

        // 당첨 통계 결과 출력
        printResult(money);
    }
}
