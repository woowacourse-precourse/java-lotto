package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public enum Grade {
        THREE, THREEANDBONUS, FOUR, FOURANDBONUS, FIVE, FIVEANDBONUS, SIX, SIXANDBONUS
    }
    private static List<Lotto> userLottoNum = new ArrayList<>();
    private static List<Integer> lottoNumbers = new ArrayList<>();
    private static int lottoBonusNumber;
    private static HashMap<Grade,Integer> lottoStatistics = new HashMap<>();

    // 구입금액 입력
    private static int inputBuyMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(Console.readLine());

        if(money%1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 단위로 입력해야 합니다.");
        }
        System.out.println();

        return money;
    }

    // 로또 번호 생성
    private static void generateLottoNumbers(int lottoCnt){
        for(int i=0; i<lottoCnt; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            userLottoNum.add(lotto);
        }
    }

    // 로또 번호 출력
    private static void printLottoNumbers(){
        System.out.println(userLottoNum.size()+"개를 구매했습니다.");
        for(Lotto lotto : userLottoNum){
            lotto.printLottoNumbers();
        }
        System.out.println();
    }

    // 당첨 번호 입력
    private static void inputLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String[] inputLottoNumbers = Console.readLine().split(",");
            for(String number : inputLottoNumbers){
                lottoNumbers.add(Integer.parseInt(number));
            }
        } catch (IllegalArgumentException exception){
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
        }

        if(lottoNumbers.size()!=6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
        }
        System.out.println();
    }

    // 보너스 번호 입력
    private static void inputLottoBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            lottoBonusNumber = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException exception){
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 입력입니다.");
        }
        System.out.println();
    }

    // 당첨 통계 계산
    private static void calculateLottoGrade(){
        for(Lotto userLotto : userLottoNum){
            boolean checkBonus = userLotto.isBonusNumber(lottoBonusNumber);
            int sameCnt = userLotto.getLottoNumber(lottoNumbers);
            if(checkBonus){
                saveCalculateLottoIncludeBonus(sameCnt+1);
            } else if(checkBonus==false){
                saveCalculateLottoNotIncludeBonus(sameCnt);
            }
        }
    }

    // 당첨 내역 저장 - 보너스 번호 있는 경우
    private static void saveCalculateLottoIncludeBonus(int sameCnt){
        if(sameCnt==3){
            lottoStatistics.put(Grade.THREEANDBONUS, lottoStatistics.getOrDefault(Grade.THREEANDBONUS,0)+1);
        } else if(sameCnt==4){
            lottoStatistics.put(Grade.FOURANDBONUS, lottoStatistics.getOrDefault(Grade.FOURANDBONUS,0)+1);
        } else if(sameCnt==5){
            lottoStatistics.put(Grade.FIVEANDBONUS, lottoStatistics.getOrDefault(Grade.FIVEANDBONUS,0)+1);
        } else if(sameCnt==6){
            lottoStatistics.put(Grade.SIXANDBONUS, lottoStatistics.getOrDefault(Grade.SIXANDBONUS,0)+1);
        }
    }

    // 당첨 내역 저장 - 보너스 번호 없는 경우
    private static void saveCalculateLottoNotIncludeBonus(int sameCnt){
        if(sameCnt==3){
            lottoStatistics.put(Grade.THREE, lottoStatistics.getOrDefault(Grade.THREE,0)+1);
        } else if(sameCnt==4){
            lottoStatistics.put(Grade.FOUR, lottoStatistics.getOrDefault(Grade.FOUR,0)+1);
        } else if(sameCnt==5){
            lottoStatistics.put(Grade.FIVE, lottoStatistics.getOrDefault(Grade.FIVE,0)+1);
        } else if(sameCnt==6){
            lottoStatistics.put(Grade.SIX, lottoStatistics.getOrDefault(Grade.SIX,0)+1);
        }
    }

    public static void main(String[] args) {
        // 구입금액 입력
        int lottoCnt = inputBuyMoney()/1000;

        // 로또 번호 생성
        generateLottoNumbers(lottoCnt);

        // 로또 번호 출력
        printLottoNumbers();

        // 당첨 번호 입력
        inputLottoNumbers();

        // 보너스 번호 입력
        inputLottoBonusNumber();

        // 당첨 통계 저장
        calculateLottoGrade();
    }
}
