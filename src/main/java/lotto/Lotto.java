package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Lotto {
    enum statistics {
        prize1(1, 6, 4,"2,000,000,000"),
        prize2(2,5, 3,"30,000,000"),
        prize3(3,5, 2,"1,500,000"),
        prize4(4, 4,1,"50,000"),
        prize5(5,3,0,"5,000"),
        noprize(0,0,-1,"0");

        // 순위
        private int rank;
        // 상금
        private String money;
        // 일치하는 번호 개수
        private int count;
        // 통계를 저장할 통계 리스트 인덱스
        private int index;

        statistics(int rank, int count,int index, String money){
            this.rank = rank;
            this.money = money;
            this.count = count;
            this.index = index;
        }
    }
    private static int number_of_lotto;
    private static List<List<Integer>> purchased_lotto_numbers;
    private static int bonus_number = 0;
    private static List<statistics> win_lotto;
    private static ArrayList<Integer> status_of_win = new ArrayList<>(5);
    private static double rate_of_earning;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void enterPriceOfLotto(){
        System.out.println("구입금액을 입력해주세요.");
        int price_of_lotto = Integer.parseInt(Console.readLine());
        calculateNumOfLotto(price_of_lotto);
    }

    private void calculateNumOfLotto(int price_of_lotto){
        number_of_lotto = price_of_lotto / 1000;
        System.out.println("\n" + number_of_lotto + "개를 구매했습니다.");
    }

    private void createRandomNumbers() {
        for (int count = 0; count < number_of_lotto; count++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            purchased_lotto_numbers.add(lotto);
        }
    }

    private void printPurchasedLotto() {
        for (int lotto = 0; lotto < purchased_lotto_numbers.size(); lotto++){
            System.out.println(purchased_lotto_numbers.get(lotto));
        }
    }

    private void enterBonusNumber() {
        bonus_number = Integer.parseInt(Console.readLine());
    }

    private void calculatePrize() {
        int count = 0;
        for (int i = 0;i<purchased_lotto_numbers.size();i++){
            for (int j = 0; j<purchased_lotto_numbers.get(i).size();j++){
                if (numbers.contains(purchased_lotto_numbers.get(i).get(j))){
                    count++;
                }
            }
            setPrize(count,purchased_lotto_numbers.get(i),win_lotto.get(i));

            if (win_lotto.get(i).rank!=0){
                // 로또 당첨 통계를 계산해 status_of_win 리스트에 저장
                status_of_win.set(win_lotto.get(i).index,status_of_win.get(win_lotto.get(i).index)+1);
            }

        }
    }

    private void setPrize(int count, List<Integer> my_lotto, statistics win_lotto) {
        if (count==5){
            if (my_lotto.contains(bonus_number)){
                win_lotto = statistics.prize2;
            }
            if (!my_lotto.contains(bonus_number)){
                win_lotto = statistics.prize3;
            }
        }
        if (count == 6) {
            win_lotto = statistics.prize1;
        }
        if (count == 4){
            win_lotto = statistics.prize4;
        }
        if (count == 3){
            win_lotto = statistics.prize5;
        }
        if (count <=2 || count >= 7){
            win_lotto = statistics.noprize;
        }
        return;
    }


    private void printStatisticsForLotto(){
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 0; i < 6; i++){
            System.out.println(win_lotto.get(i).count+"개 일치 ("+win_lotto.get(i).money+"원) - "+status_of_win.get(i)+"개");
        }
    }

    private void calculateRateOfEarning(){
        double total_money = 0.0;
       for (int i = 0; i<6;i++){
           if (status_of_win.get(i)!=0){
               total_money += Double.parseDouble(win_lotto.get(i).money.replaceAll(",",""));
           }
       }

       rate_of_earning = (total_money / (number_of_lotto * 1000.0))*100;
    }


}
