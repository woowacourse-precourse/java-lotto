package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Lotto {
    enum statistics {
        PRIZE5(3,0,"5,000"),
        PRIZE4(4,1,"50,000"),
        PRIZE3(5, 2,"1,500,000"),
        PRIZE2(5, 3,"30,000,000"),
        PRIZE1(6, 4,"2,000,000,000"),
        NOPRIZE(0,-1,"0");
        private final int COUNT, INDEX;
        private final String MONEY;
        statistics( int count,int index, String money){
            this.COUNT = count;
            this.INDEX = index;
            this.MONEY = money;
        }
    }
    private static int number_of_lotto;
    private static List<List<Integer>> purchased_lotto_numbers;
    private int bonus_number;
    private List<statistics> win_lotto = new ArrayList<>();
    private int[] status_of_win = { 0, 0, 0, 0, 0 };
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
	@@ -11,10 +35,159 @@ public Lotto(List<Integer> numbers) {
    }

    private void validate(List<Integer> numbers) {

        if (numbers.size() != 6) {
            System.out.println("[ERROR] 유효한 로또 번호를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size()!=numbers.size()){
            System.out.println("[ERROR] 로또 번호는 중복된 숫자가 없어야 합니다.");
            throw new IllegalArgumentException();
        }

    }

    // TODO: 추가 기능 구현

    static void enterPriceOfLotto() {
        System.out.println("구입금액을 입력해주세요.");
        String price = Console.readLine();
        try {
            calculateNumOfLotto(Integer.parseInt(price));
        } catch (NumberFormatException e){
            System.out.println("[ERROR] 문자열을 포함하지 않은 숫자를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }

    }

    static void calculateNumOfLotto(int price_of_lotto) {
        number_of_lotto = price_of_lotto / 1000;
        System.out.println();
        System.out.println(number_of_lotto + "개를 구매했습니다.");
    }

    static void createRandomNumbers() {
        purchased_lotto_numbers = new ArrayList<>(number_of_lotto);
        for (int count = 0; count < number_of_lotto; count++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            purchased_lotto_numbers.add(lotto);
        }
    }

    static void printPurchasedLotto() {
        for (List<Integer> purchased_lotto : purchased_lotto_numbers) {
            List<Integer> arr = new ArrayList<>(purchased_lotto);
            Collections.sort(arr);
            System.out.println(arr);
        }
    }

    void enterBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        bonus_number = Integer.parseInt(Console.readLine());

        if (bonus_number>45 || bonus_number<1) {
            System.out.println("[ERROR] 1~45 숫자 범위의 수를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.contains(bonus_number)){
            System.out.println("[ERROR] 당첨 번호가 아닌 보너스 번호를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    void calculatePrize() {
        for (int i = 0;i<number_of_lotto;i++){
            setPrize(getCountOfSameNumbers(i), purchased_lotto_numbers.get(i));

            int index = win_lotto.get(i).INDEX;
            if (index != -1){
                status_of_win[index] = status_of_win[index] + 1;
            }
        }
    }

    private int getCountOfSameNumbers(int i) {
        int count = 0;
        for (int j = 0; j < 6;j++){
            if (numbers.contains(purchased_lotto_numbers.get(i).get(j))){
                count++;
            }
        }
        return count;
    }

    private void setPrize(int count, List<Integer> my_lotto) {
        if (count == 5){
            determinePrize2Prize3(my_lotto);
        }
        if (count == 6){
            determinePrize1();
        }
        if (count == 4){
            determinPrize4();
        }
        if (count == 3){
            determinePrize5();
        }
        if (count <= 2 || count >= 7){
            determineNoprize();
        }

    }

    private void determineNoprize() {
        win_lotto.add(statistics.NOPRIZE);
    }

    private void determinePrize5() {
        win_lotto.add(statistics.PRIZE5);
    }

    private void determinPrize4() {
        win_lotto.add(statistics.PRIZE4);
    }

    private void determinePrize1() {
        win_lotto.add(statistics.PRIZE1);
    }

    private void determinePrize2Prize3(List<Integer> my_lotto) {
        if (my_lotto.contains(bonus_number)){
            win_lotto.add(statistics.PRIZE2);
        }
        if (!my_lotto.contains(bonus_number)){
            win_lotto.add(statistics.PRIZE3);
        }
    }

    void printStatisticsForLotto(){
        System.out.println("\n당첨 통계\n---");
        System.out.println(statistics.PRIZE5.COUNT + "개 일치 ("+statistics.PRIZE5.MONEY + "원) - "+status_of_win[0]+"개");
        System.out.println(statistics.PRIZE4.COUNT + "개 일치 ("+statistics.PRIZE4.MONEY + "원) - "+status_of_win[1]+"개");
        System.out.println(statistics.PRIZE3.COUNT + "개 일치 ("+statistics.PRIZE3.MONEY + "원) - "+status_of_win[2]+"개");
        System.out.println(statistics.PRIZE2.COUNT + "개 일치, 보너스 볼 일치 ("+statistics.PRIZE2.MONEY + "원) - "+status_of_win[3]+"개");
        System.out.println(statistics.PRIZE1.COUNT + "개 일치 ("+statistics.PRIZE1.MONEY + "원) - "+status_of_win[4]+"개");
    }

    void calculateRateOfEarning(){
        double total_money = 0.0;
        total_money += status_of_win[0]*getMoney(statistics.PRIZE5);
        total_money += status_of_win[1]*getMoney(statistics.PRIZE4);
        total_money += status_of_win[2]*getMoney(statistics.PRIZE3);
        total_money += status_of_win[3]*getMoney(statistics.PRIZE2);
        total_money += status_of_win[4]*getMoney(statistics.PRIZE1);
        printRateOfEarning((total_money / (number_of_lotto * 1000.0)) * 100.0);
    }

    private Integer getMoney(statistics prize) {
        return Integer.parseInt(prize.MONEY.replace(",", ""));
    }

    private void printRateOfEarning(double rate_of_earning) {
        System.out.println("총 수익률은 "+String.format("%.1f",rate_of_earning)+"%입니다.");
    }

}