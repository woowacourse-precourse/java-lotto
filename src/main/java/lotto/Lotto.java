package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static List<Integer> numbers = new ArrayList<>();
    private static List<List> myLottoNum = new ArrayList<>();
    private static List<Integer> bonusNum = new ArrayList<>();
    private static int howManyLotto;
    private static int inputMoney;
    private static int first, second, third, fourth, fifth;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 구입 금액 입력
    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int typeInputMoney = Integer.parseInt(Console.readLine());
        inputMoney = typeInputMoney;
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }
        return inputMoney;
    }

    // 로또 구입 갯수
    public static int theNumberOfLotto() {
        howManyLotto = inputMoney / 1000;
        System.out.println(howManyLotto + "개를 구매했습니다.");
        return howManyLotto;
    }

    // 구입한 만큼 로또 생성
    public static List<List> myLottoNumber() {
        for (int i = 0; i < howManyLotto; i++) {
            List<Integer> ranLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(ranLotto);
            myLottoNum.add(ranLotto);
        }
        return myLottoNum;
    }

    // 1등 당첨 번호 입력
    public static List<Integer> winnerNumber() {
        System.out.println("당첨 번호를 입력해주세요");
        String num = Console.readLine();
        String[] nums = num.split(",");
        for (int i = 0; i < nums.length; i++) {
            numbers.add(Integer.parseInt(nums[i]));
        }
        if(numbers.size() > 6){
            throw new IllegalArgumentException("[ERROR] 로또는 6자리의 숫자여야 합니다.");
        }
        return numbers;
    }

    // 보너스 번호 입력
    public static List<Integer> bonusNumber() {
        System.out.println("보너스 번호를 입력해주세요");
        int bonus = Integer.parseInt(Console.readLine());
        if(bonus <= 0 || bonus > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        bonusNum.add(bonus);

        return bonusNum;
    }

    // 로또 당첨 확인
//    public static void compareLotto() {
//        checkWin();
//        int lottoSize = myLottoNum.size();
//        if(myLottoNum.contains(bonusNum)){
//            if(lottoSize == 3){
//                fifth++;
//            }
//            if(lottoSize == 4){
//                fourth++;
//            }
//            if(lottoSize == 5){
//                second++;
//            }
//            if(lottoSize == 6){
//                first++;
//            }
//        }
//        if(!myLottoNum.contains(bonusNum)){
//            if(lottoSize == 3){
//                fifth++;
//            }
//            if(lottoSize == 4){
//                fourth++;
//            }
//            if(lottoSize == 5){
//                third++;
//            }
//            if(lottoSize == 6){
//                first++;
//            }
//        }
//    }

    public static void checkWin(){
        for (int i = 0; i < Lotto.howManyLotto; i++){
            if(myLottoNum.get(i).contains(bonusNum.get(0))){
                myLottoNum.get(i).retainAll(numbers);
                int lottoSize = myLottoNum.get(i).size();
                if(lottoSize == 3){
                    fifth++;
                }
                if(lottoSize == 4){
                    fourth++;
                }
                if(lottoSize == 5){
                    second++;
                }
                if(lottoSize == 6){
                    first++;
                }
            }
            if(!myLottoNum.get(i).contains(bonusNum.get(0))){
                myLottoNum.get(i).retainAll((numbers));
                int lottoSize = myLottoNum.get(i).size();
                if(lottoSize == 3){
                    fifth++;
                }
                if(lottoSize == 4){
                    fourth++;
                }
                if(lottoSize == 5){
                    third++;
                }
                if(lottoSize == 6){
                    first++;
                }
            }
        }
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6자리의 숫자여야 합니다.");
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) <= 0 || numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERRO] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
}