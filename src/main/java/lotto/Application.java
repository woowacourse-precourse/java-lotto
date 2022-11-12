package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    static Map<String, Integer> sameNumberMap = new HashMap<>();
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        int buyMoney = 0;
        int buyLottoCount = 0;
        int bonusNumber = 0;
        List<Integer> winningNumber = new LinkedList<>();
        List<Lotto> saveLottoNumber = new LinkedList<>();

        setSameNumberMap();

        try {
            System.out.println("구매금액을 입력해 주세요.");
            buyMoney = Integer.parseInt(Console.readLine());
            moneyUnitCheck(buyMoney);
            System.out.println();

            buyLottoCount = buyMoney / 1000;
            System.out.println(buyLottoCount + "개를 구매했습니다.");
            for (int i = 0; i < buyLottoCount; i++) {
                Lotto lotto = new Lotto(buyLottoRandomNumber());
                saveLottoNumber.add(lotto);
                System.out.println(saveLottoNumber.get(i).getNumbers());
            }

            System.out.println("\n당첨 번호를 입력해 주세요.");
            String[] setWin = Console.readLine().split(",");
            System.out.println("\n보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
            winningNumber = setWinNumber(setWin);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for(int i = 0; i < buyLottoCount; i++){
            int count = saveLottoNumber.get(i).sameNumberCheck(winningNumber);
            boolean bonusCheck = saveLottoNumber.get(i).bonusBallCheck(bonusNumber);
            setSameNumberMap(count, bonusCheck);
        }

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(winStatistics());
        System.out.println("총 수익률은 "+totalPercent(buyMoney)+"%입니다.");
    }

    public static void setSameNumberMap(){
        sameNumberMap.put("3개", 0);
        sameNumberMap.put("4개", 0);
        sameNumberMap.put("5개", 0);
        sameNumberMap.put("5개+보너스", 0);
        sameNumberMap.put("6개", 0);
    }

    public static List<Integer> buyLottoRandomNumber(){
        List<Integer> buyLottoNumber;
        buyLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return buyLottoNumber;
    }

    public static void moneyUnitCheck(int inputMoney){
        if(inputMoney % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구매금액의 단위는 1000원 단위로 입력해주세요.");
        }
    }

    public static List<Integer> setWinNumber(String[] winNumber){
        List<Integer> win = new LinkedList<>();
        for(String value : winNumber) {
            win.add(Integer.parseInt(value));
        }
        return win;
    }

    public static void setSameNumberMap(int count, boolean bonus){
        if(count < 3){
            return;
        }
        if(bonus && count == 5 && !sameNumberMap.containsKey(count+"개+보너스")){
            sameNumberMap.put(count+"개+보너스", 1);
        }
        else if(bonus && count == 5 && sameNumberMap.containsKey(count+"개+보너스")){
            sameNumberMap.put(count+"개+보너스", sameNumberMap.get(count+"개+보너스")+1);
        }
        else if(!sameNumberMap.containsKey(count+"개")){
            sameNumberMap.put(count+"개", 1);
        }
        else{
            sameNumberMap.put(count+"개", sameNumberMap.get(count+"개")+1);
        }
    }

    public static String winStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5,000원) - ").append(sameNumberMap.get("3개")).append("개").append("\n");
        sb.append("4개 일치 (50,000원) - ").append(sameNumberMap.get("4개")).append("개").append("\n");
        sb.append("5개 일치 (1,500,000원) - ").append(sameNumberMap.get("5개")).append("개").append("\n");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(sameNumberMap.get("5개+보너스")).append("개").append("\n");
        sb.append("6개 일치 (2,000,000,000원) - ").append(sameNumberMap.get("6개")).append("개");
        return sb.toString();
    }

    public static double totalPercent(int buyMoney){
        double total = 0.0;
        total += (5000.0 * sameNumberMap.get("3개"));
        total += (50000.0 * sameNumberMap.get("4개"));
        total += (1500000.0 * sameNumberMap.get("5개"));
        total += (30000000.0 * sameNumberMap.get("5개+보너스"));
        total += (2000000000.0 * sameNumberMap.get("6개"));
        return (total / buyMoney)*100;
    }
}
