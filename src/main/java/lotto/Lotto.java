package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;
    private int bonus;

    private Map<String, Integer> sameNumberMap = new HashMap<>();

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
    //1. 로또 구매시 랜덤 번호를 담는 함수
    public List<Integer> buyLottoRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
    //2. 당첨에 개수를 반환하는 함수
    public int sameNumberCheck(List<Integer> buyLottoNumber){
        int count = 0;
        for(int i = 0; i < 6; i++){
            if(buyLottoNumber.contains(numbers.get(i))){
                count++;
            }
        }
        setSameNumberMap(count);
        return count;
    }
    // 2-1. 로또에서 3개 이상 당첨에 다른 개수 카운트
    public void setSameNumberMap(int count){
        if(count < 3){
            return;
        }
        if(!sameNumberMap.containsKey(count+"개")){
            sameNumberMap.put(count+"개", 1);
        }
        else if(count == 5 && !sameNumberMap.containsKey(count+"개+보너스")){
            sameNumberMap.put(count+"개+보너스", 1);
        }
        else{
            sameNumberMap.put(count+"개", sameNumberMap.get(count+"개")+1);
        }
    }
    //3. 입력 받은 금액이 1000원단위인지 확인하는 함수
    public void moneyUnitCheck(int inputMoney){
        if(inputMoney % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }
    //4. 당첨 번호와 보너스 번호를 입력받는 함수
    public void setWinAndBonusNumber(String[] winNumber, int bonusNumber){
        List<Integer> winAndBonus = new LinkedList<>();
        for(String value : winNumber) {
            winAndBonus.add(Integer.parseInt(value));
        }
        new Lotto(winAndBonus);
        this.bonus = bonusNumber;
    }
    //5. 발행한 로또 번호를 정렬 하는 함수 (오름차순)
    public void sortNumber(List<Integer> buyLottoNumber){
        Collections.sort(buyLottoNumber);
    }
    //6. 당첨 내역을 출력하는 함수
    public String winStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5,000원) - ").append(sameNumberMap.get("3개")).append("개");
        sb.append("4개 일치 (50,000원) - ").append(sameNumberMap.get("4개")).append("개");
        sb.append("5개 일치 (1,500,000원) - ").append(sameNumberMap.get("5개")).append("개");
        sb.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ").append(sameNumberMap.get("5개+보너스")).append("개");
        sb.append("6개 일치 (2,000,000,000원) - ").append(sameNumberMap.get("6개")).append("개");
        return sb.toString();
    }
    //7. 수익률을 계산하는 함수 (소수 두째자리에서 반올림)
    public double totalPercent(int buyMoney){
        double total = 0;
        total += (5000.0 * sameNumberMap.get("3개"));
        total += (50000.0 * sameNumberMap.get("4개"));
        total += (1500000.0 * sameNumberMap.get("5개"));
        total += (30000000.0 * sameNumberMap.get("5개+보너스"));
        total += (2000000000.0 * sameNumberMap.get("6개"));
        return Math.round((total / buyMoney)*100);
    }
    //8. 예외처리 에러 문구 출력 함수 (단, [ERROR] 로 시작)
    //9. 보너스 볼이 일치하는지 확인하는 함수
    public boolean bonusBallCheck(List<Integer> buyLottoNumber){
        return buyLottoNumber.contains(bonus);
    }
}
