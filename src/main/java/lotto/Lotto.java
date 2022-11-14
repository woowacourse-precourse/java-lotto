package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lotto {
    User user = new User();

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

    public List<Integer> getNumbers(){
        return numbers;
    }

    public static void inputBuyPirce1() {
        System.out.println("구입금액을 입력해주세요");
    }

    public static void buySucess(int Countlotto) {
        System.out.println(Countlotto + "개를 구매하였습니다.");
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

    public static void LottoResultMessage() {
        System.out.println("\n당첨 통계\n---");
    }



    public static void toResult(Integer number, int Countlotto) {
        User user = new User();

        String lottoInput = user.lottoListSix();
        List<Integer> lottoToList = user.lottoToList(lottoInput);

        List<List<Integer>> lottoRandomNumber = user.lottoRandomNumber((Integer) (Countlotto));  //숫자에서 숫자로 형변환시킬때

        int cnt = 0;
        for (int i = 0; i < number; i++) {
            if (!lottoRandomNumber.contains(lottoToList))
                lottoRandomNumber.contains(lottoToList);
                cnt++;
        }
    }


    public boolean BonuseChoose(List<Lotto> listchoose, int intchoose){
        for(Lotto lotto : listchoose){
            if(lotto.getNumbers().contains(intchoose))
                return true;
        }
        return false;
    }

    public List<Integer> BonusChooseList(List<Lotto> listchoose, int intchoose){
        List<Integer> Bonuse = new ArrayList<>();

        if(!Bonuse.contains(BonuseChoose(listchoose, intchoose))){
            Bonuse.contains(BonuseChoose(listchoose, intchoose));
        }
        return Bonuse;
    }


    public int[] ScoreNumber(List<Integer> correct, List<Boolean> BonusBoolean) {


        int[] CountNumber = {1, 2, 3, 4, 5};
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


    public int[] TotalNumber(List<Integer> correct, List<Boolean> BonusCorrect) {


        int[] totalNumber = {};

        for (int index = 0; index < correct.size(); index++) {
            if (correct.get(index) == 3) {
                totalNumber[0] += 5000;
            }
            if (correct.get(index) == 4) {
                totalNumber[1] += 50000;
            }
            if (correct.get(index) == 5 && !BonusCorrect.get(index)) {
                totalNumber[2] += 1500000;
            }
            if (correct.get(index) == 5 && BonusCorrect.get(index)) {
                totalNumber[3] += 30000000;
            }
            if (correct.get(index) == 6) {
                totalNumber[4] += 2000000000;
            }
        }

        return totalNumber;

    }


        public int countNumber(List<Integer> countNum){
            int countN = 0;
            for(int index = 0; index < countNum.size(); index++){
                if(countN == countNum.get(index))
                    countN++;
            }
            return countN;
        }


        public void decimalPointCirculator(int decimalpoint1, int decimalpoint2){

        double filed  = ((double)decimalpoint1 / decimalpoint2) * 100;
        filed = Math.round(filed*100);


        System.out.println("총 수익률은"+filed/100 +"%입니다.");

        }



}







