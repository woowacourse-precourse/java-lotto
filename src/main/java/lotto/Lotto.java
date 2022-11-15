package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    public enum uiMessage{
        correctLottoNumberIsThree(3,0,"3개 일치 (5,000원)"),
        correctLottoNumberIsFour(4,0,"4개 일치 (50,000원)"),
        correctLottoNumberIsFive(5,0,"5개 일치 (1,500,000원)"),
        correctLottoNumberIsFiveAndBonus(5,1,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
        correctLottoNumberIsSix(6,0,"6개 일치 (2,000,000,000원)");
        private final String message;
        private final int number;
        private final int bonus;
        uiMessage(int number, int bonus, String message) {
            this.number = number;
            this.bonus = bonus;
            this.message = message;
        }
        public int getNumber() {
            return number;
        }
        public int getBonus() {
            return bonus;
        }
        public String getMessage() {
            return message;
        }

    }
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6자리여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
    public static Integer amountOfLotto(String lottoPayment){
        try{
            Integer amount = 0;
            Integer payment = Integer.parseInt(lottoPayment);
            if(payment%1000 != 0){
                System.out.println("[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
                throw new IllegalArgumentException();
            }
            amount = payment/1000;
            return amount;
        } catch (NumberFormatException e){
            System.out.println("[ERROR]구입 금액 입력은 숫자만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }
    public static ArrayList<List<Integer>> getRandomLottoNumber(int amountOfLotto){
        ArrayList<List<Integer>> randomLottoNumber = new ArrayList<>();
        for(int amount=0;amount<amountOfLotto;amount++){
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
            randomLottoNumber.add(lottoNumbers);
        }
        return randomLottoNumber;
    }

    public static List<Integer> getTypingWinningNumber(String typing){
        try{
            String[] splitTypingNumber = typing.split(",");
            List<Integer> getWinningNumber = conversionArrayToList(splitTypingNumber);
            Lotto lotto = new Lotto(getWinningNumber);
            lotto.validate(getWinningNumber);
            System.out.println(getWinningNumber);
            return getWinningNumber;
        }
        catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호 입력은 숫자와 ','만 가능합니다");
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> conversionArrayToList(String[] arr){
        List<Integer> getWinningNumber = new ArrayList<>();
        for(int arrayIndex=0;arrayIndex<arr.length;arrayIndex++){
            int number = Integer.parseInt(arr[arrayIndex]);
            if(number>45 || number<1){
                System.out.println("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            } else if (getWinningNumber.contains(number)) {
                System.out.println("[ERROR] 당첨 번호는 중복을 허용하지 않습니다.");
                throw new IllegalArgumentException();
            }
            getWinningNumber.add(number);
        }
        return getWinningNumber;
    }

    public static void winningStatistics(Integer[] winningCount){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+winningCount[0]+"개");
        System.out.println("4개 일치 (50,000원) - "+winningCount[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - "+winningCount[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+winningCount[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+winningCount[4]+"개");
    }
    public static Integer compareToNumber(List<Integer> myLotto, List<Integer> winningNum){
        Integer count = 0;
        for(int winNum=0;winNum<winningNum.size();winNum++){
            if(myLotto.contains(winningNum.get(winNum))){
                count++;
            }
        }
        return count;
    }

    public static Integer[] getWinningCount (ArrayList<List<Integer>> myLotto, List<Integer> winningNum, Integer bonus){
        Integer[] winningCount = {0,0,0,0,0};
        for(int myNum=0;myNum<myLotto.size();myNum++){
            if(compareToNumber(myLotto.get(myNum),winningNum) == 5 && myLotto.get(myNum).contains(bonus)){
                winningCount[3]++;
            } else if (compareToNumber(myLotto.get(myNum),winningNum) == 5 && !myLotto.get(myNum).contains(bonus)) {
                winningCount[2]++;
            } else if (compareToNumber(myLotto.get(myNum),winningNum) != 5 && compareToNumber(myLotto.get(myNum),winningNum) >= 3) {
                winningCount[compareToNumber(myLotto.get(myNum),winningNum)-3]++;
            } else if (compareToNumber(myLotto.get(myNum),winningNum) < 3) {
                continue;
            }
        }
        return winningCount;
    }

    public static String getRevenueRate(Integer cost, Integer[] count){
        String revenueRate = "";
        Integer sum = (count[0]*5000)+(count[1]*50000)+
                (count[2]*1500000)+(count[3]*30000000)+(count[4]*2000000000);
        revenueRate = String.format("%.1f", (sum*1.0/cost*1.0)*100);
        return revenueRate;
    }
}

