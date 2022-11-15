package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    User user = new User();
    Validator val = new Validator();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    public void validateDuplicate(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (Collections.frequency(numbers, number) > 1) {
                throw new IllegalArgumentException("[Error]");
            }
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 0) {
                throw new IllegalArgumentException("[Error]");
            }
        }
    }


    public List<Integer> getNumbers(){
        return numbers;
    }

    public static void inputBuyPirce1() {
        System.out.println("구입금액을 입력해주세요");
    }

    public static void buySucess(int Countlotto) {
        System.out.println(Countlotto + "개를 구매했습니다.");
    }

    public static int buyScuessCount(int Countlotto) {
        return Countlotto / 1000;
    }

    public static void sayLottoNumber() {
        System.out.println("당첨 번호를 입력해주세요");
    }

    public static void bonusSay() {
        System.out.println("보너스 번호를 입력해주세요");
    }

    public static void CountNumberMessage() {
        System.out.println("\n당첨 통계\n---");
    }



    public static List<Integer> toResult(List<Integer> InputNumber, List<List<Integer>> RandomNumberList) {
        List<Integer> CountList = new ArrayList<>();


        for(int index = 0; index < RandomNumberList.size(); index++){  //8
                int cnt = 0;
            for(int j = 0; j < RandomNumberList.get(index).size(); j++){    //6 각자
        if(InputNumber.contains(RandomNumberList.get(index).get(j))) {
                cnt++;
                }
            }
            CountList.add(cnt);
        }
        return CountList;
    }


    public static boolean BonuseChoose(List<List<Integer>> listchoose, int intchoose){
        for(List<Integer> lotto : listchoose){
            if(lotto.contains(intchoose))
                return true;
        }
        return false;
    }

    public static List<Boolean> BonusChooseList(List<List<Integer>> listchoose, int intchoose){
        List<Boolean> Bonuse = new ArrayList<>();

        for(List<Integer> lotto : listchoose){
            Bonuse.add(BonuseChoose(listchoose,intchoose));
        }

        return Bonuse;
    }


    public  static int[] ScoreNumber(List<Integer> correct, List<Boolean> BonusBoolean) {


        int[] CountNumber = new int[5];
        for (int index = 0; index < correct.size(); index++) {
            if (correct.get(index) == 3) {
                CountNumber[0]++;
            }
            if (correct.get(index) == 4) {
                CountNumber[1]++;
            }
            if (correct.get(index) == 5 && !BonusBoolean.get(index)) {
                CountNumber[2]++;
            }
            if (correct.get(index) == 5 && BonusBoolean.get(index)) {
                CountNumber[3]++;
            }
            if (correct.get(index) == 6) {
                CountNumber[4]++;
            }
        }
        return CountNumber;
    }


    public static int TotalNumber(List<Integer> correct, List<Boolean> BonusCorrect) {


        int totalNumber = 0;

        for (int index = 0; index < correct.size(); index++) {
            if (correct.get(index) == 3) {
                totalNumber += 5000;
            }
            if (correct.get(index) == 4) {
                totalNumber += 50000;
            }
            if (correct.get(index) == 5 && !BonusCorrect.get(index)) {
                totalNumber += 1500000;
            }
            if (correct.get(index) == 5 && BonusCorrect.get(index)) {
                totalNumber += 30000000;
            }
            if (correct.get(index) == 6) {
                totalNumber += 2000000000;
            }
        }

        return totalNumber;

    }

        public static void CountNumberMessage(int[] Board){
            for(int index = 0; index < Board.length; index++){
                System.out.println(scoreToWinningEnumMessage(index)+" - "+Board[index]+"개");
            }
        }





        public static void decimalPointCirculator(int decimalpoint1, int decimalpoint2){

        double filed  = ((double)decimalpoint1 / decimalpoint2) * 100;
        filed = Math.round(filed*100);


        System.out.println("총 수익률은 "+filed/100+"%입니다.");

        }

    public enum Winning {
        FIRST("6개 일치 (2,000,000,000원)"),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)"),
        THIRD("5개 일치 (1,500,000원)"),
        FOURTH("4개 일치 (50,000원)"),
        FIFTH("3개 일치 (5,000원)"),
        NOPE("NotThing");

        private final String message;

        Winning(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }


    public static String scoreToWinningEnumMessage(int score) {
        if (score == 0) {
            return Winning.FIFTH.getMessage();
        }
        if (score == 1) {
            return Winning.FOURTH.getMessage();
        }
        if (score == 2) {
            return Winning.THIRD.getMessage();
        }
        if (score == 3) {
            return Winning.SECOND.getMessage();
        }
        if (score == 4) {
            return Winning.FIRST.getMessage();
        }
        return Winning.NOPE.getMessage();
    }

}







