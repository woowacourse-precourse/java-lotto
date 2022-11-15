package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    static final float first = 2000000000;
    static final float second = 30000000;
    static final float third = 1500000;
    static final float fourth = 50000;
    static final float fifth = 5000;

    public static void main(String[] args) {
        
        
        //구입금액
        int buyMoney = inputBuyMoney();

        //로또 구매및 출력
        ArrayList<Lotto> lottoList = buyLotto(countPurchaseLotto(buyMoney));

        //당첨번호 입력받기
        ArrayList<Integer> luckyList = inputLuckyNumber();
        //보너스 번호 입력받기
        int bonusNumber = inputBonusNumber();
        //당첨 확인
        ArrayList<Integer> winList = winCount(lottoList, luckyList, bonusNumber);
        //상금 리스트
        ArrayList<Float> rewardList = inputReward();
        //당첨통계
        printWinningDetails(winList, rewardList);
        //수익률 출력
        calcLotteryYield(winList, buyMoney, rewardList);
    }
    static int countPurchaseLotto(int buyMoney) {

        return buyMoney / 1000;
    }

    static ArrayList<Lotto> buyLotto(int countPurchase){

        System.out.println(countPurchase+"개를 구매했습니다.");
        ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
        for(int i=0; i<countPurchase; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Integer tmpList[] = numbers.toArray(new Integer[numbers.size()]);
            Arrays.sort(tmpList);
            List<Integer> sorted = Arrays.asList(tmpList);

            System.out.println(sorted);
            lottoList.add(new Lotto(sorted));

        }
        return lottoList;
    }

    static ArrayList<Integer> inputLuckyNumber(){
        ArrayList<Integer> luckyList = new ArrayList<Integer>();

        System.out.println("당첨 번호를 입력해 주세요.");
        //todo: 잘못입력시 에러발생 1~45, 숫자
        String inputLuckyNumber[] = Console.readLine().split(",");

        for(int i=0; i<inputLuckyNumber.length; i++){
            luckyList.add(Integer.parseInt(inputLuckyNumber[i]));
        }

        return luckyList;
    }

    static int inputBonusNumber() {
        int bonusNumber=0;
        System.out.println("보너스 번호를 입력해 주세요.");

        //todo: 잘못입력시 에러발생 1~45, 숫자
        bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

    static ArrayList<Integer> winCount(List<Lotto> lottoList, List<Integer> luckyList, int bonusNumber){
        ArrayList<Integer> winList = new ArrayList<Integer>();
        List<Integer> lotto;
        List<Integer> difference;
        int firstPlace= 0;
        int secondPlace= 0;
        int thirdPlace= 0;
        int fourthPlace= 0;
        int fifthPlace= 0;
        /*
        * 구매한 로또번호와 당첨번호를 차집합을 통해 비교
        * 차집합이 0일경우 1등
        * 차집합이 1일경우에 보너스가 일치하면 2등
        * 차집합이 1일경우에 보너스가 일치하지 않으면 3등
        * 차집합이 2일경우 4등
        * 차집합이 3일경우 5등
        */
        for(int i=0; i<lottoList.size(); i++){
            lotto = lottoList.get(i).getNumbers();

            difference = lotto.stream()
            .filter(k -> !luckyList.contains(k))
            .collect(Collectors.toList());

            if(difference.size() == 0){
                firstPlace += 1;
            }
            if(difference.size() == 1){
                if(difference.get(0) == bonusNumber){
                    secondPlace += 1;
                }
                else {
                    thirdPlace +=1;
                }
            }
            if(difference.size() ==2){
                fourthPlace +=1;
            }
            if(difference.size() ==3){
                fifthPlace += 1;
            }
        }
        winList.add(firstPlace);
        winList.add(secondPlace);
        winList.add(thirdPlace);
        winList.add(fourthPlace);
        winList.add(fifthPlace);

        return winList;
    }

    static void printWinningDetails(ArrayList<Integer> winList, ArrayList<Float> rewardList){
        DecimalFormat decFormat = new DecimalFormat("###,###");
        int count = 3;
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i=0; i<winList.size(); i++){
            if(i==3){
                count -= 1;
                System.out.println(count+"개 일치, 보너스 볼 일치 (" +decFormat.format(rewardList.get(i))+"원) - "+winList.get(winList.size()-1-i)+"개");
            }
            else{
                System.out.println(count+"개 일치 (" +decFormat.format(rewardList.get(i))+"원) - "+winList.get(winList.size()-1-i)+"개");
            }
            count+=1;
        }
    }
    static ArrayList<Float> inputReward(){
        ArrayList<Float> rewardList = new ArrayList<Float>();
        rewardList.add(fifth);
        rewardList.add(fourth);
        rewardList.add(third);
        rewardList.add(second);
        rewardList.add(first);
        return rewardList;
    }
    static void calcLotteryYield(ArrayList<Integer> winList, int buyMoney, ArrayList<Float> rewardList){
        //DecimalFormat decFormat = new DecimalFormat("###,###.#");

        float prizeSum =0;
        float LotteryYield;
        for(int i=0; i<winList.size(); i++){
            if(winList.get(i) == 0) continue;
            prizeSum += winList.get(i)* rewardList.get(rewardList.size()-1-i);
        }
        LotteryYield = prizeSum*100 / (float) buyMoney;
        System.out.println("총 수익률은 "+ String.format("%.1f", LotteryYield)+"%입니다.");
    }

    static int inputBuyMoney(){
        System.out.println("구입금액을 입력해주세요.");
        int buyMoney=0;
        ////todo: 1000원으로 나누어떨어지지않으면 오류발생시키기 추가예정
        try {
            buyMoney = Integer.parseInt(Console.readLine());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
