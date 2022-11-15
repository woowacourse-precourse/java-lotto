package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LottoView {
    public static String moneyInput(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
    private static void winNumberValidation(List<String> winNumber){
        for(int i=0; i<winNumber.size(); i++){
            if(winNumber.get(i).matches("(.*)[^0-9](.*)")){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        for(int i=0; i<winNumber.size(); i++){
            if(Integer.parseInt(winNumber.get(i))<1 || Integer.parseInt(winNumber.get(i))>45){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        if(winNumber.size()!=6){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static List<Integer> winNumber(){
        System.out.println("당첨번호를 입력해 주세요.");
        String inputWinNumber = Console.readLine();
        String[] inputWinNumberSplit = inputWinNumber.split(",");
        winNumberValidation(Arrays.asList(inputWinNumberSplit));

        List<Integer> winNumber = new ArrayList<>();
        for(int i=0; i< inputWinNumberSplit.length; i++){
            winNumber.add(Integer.parseInt(inputWinNumberSplit[i]));
        }
        //오름차순
        List<Integer> ascendWinNumber = Lotto.ascendSorting(winNumber);
        return ascendWinNumber;
    }

    private static void bonusNumberValidation(Integer bonusNumber){
        if(bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static int bonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        bonusNumberValidation(bonusNumber);
        return bonusNumber;
    }

    public static void sameValidation(List<Integer> winNumbers, Integer bonusNumber){
        List<Integer> totalNumbers = new ArrayList<>();
        totalNumbers.add(bonusNumber);
        for(int i=0; i<winNumbers.size(); i++){
            totalNumbers.add(winNumbers.get(i));
        }

        Set<Integer> notSameNumbers = new HashSet<>(totalNumbers);
        if(notSameNumbers.size()!=totalNumbers.size()){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public static void printIssueLotto(int theNumberOfLotto, LottoModel lottoModel){
        String numberOfLotto = Integer.toString(theNumberOfLotto);
        String printNumberOfLotto = String.format("%s개를 구매했습니다.",numberOfLotto);
        System.out.println(printNumberOfLotto);
        for(int i=0; i<lottoModel.getSavedIssueLotto().size(); i++){
            String printIssueLotto = String.format("%s",lottoModel.getSavedIssueLotto().get(i));
            System.out.println(printIssueLotto);
        }
    }

    public static void printResult(int first, int second, int third, int fourth, int fifth){
        System.out.println("당첨 통계");
        System.out.println("---");
        String printFifth = String.format("3개 일치 (5,000원) - %s개",fifth);
        System.out.println(printFifth);
        String printFourth = String.format("4개 일치 (50,000원) - %s개", fourth);
        System.out.println(printFourth);
        String printThird = String.format("5개 일치 (1,500,000원) - %s개", third);
        System.out.println(printThird);
        String printSecond = String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개", second);
        System.out.println(printSecond);
        String printFirst = String.format("6개 일치 (2,000,000,000원) - %s개", first);
        System.out.println(printFirst);
    }

    public static void printEarningRate(int theNumberOfLotto,
                                        int first, int second, int third, int fourth, int fifth){
        int price = theNumberOfLotto*LottoEnum.PRICE.getValue();
        long earn = first*LottoEnum.FIRST.getValue() + second*LottoEnum.SECOND.getValue() +
                third*LottoEnum.THIRD.getValue() + fourth*LottoEnum.FOURTH.getValue() +
                fifth*LottoEnum.FIFTH.getValue();
        BigDecimal exactPrice = new BigDecimal(Integer.toString(price));
        BigDecimal exactEarn = new BigDecimal(String.valueOf(earn*100));
        BigDecimal result = exactEarn.divide(exactPrice, 1, RoundingMode.HALF_EVEN);
        String printResult = String.format("총 수익률은 %s", result);
        System.out.println(printResult+"%입니다.");
    }
}
