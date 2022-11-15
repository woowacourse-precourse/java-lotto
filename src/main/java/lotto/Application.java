package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int buyMoney = buyLotto();
        List<Integer> lottoRandomNum = lottoRandomNum();
        List<List<Integer>> buyLottoPrint = buyLottoPrint(buyMoney);
        Lotto myLottoNum = myLottoNum();
        int bonusNum = bonusNum(myLottoNum);
        int lottoStart = lottoStart(lottoRandomNum, myLottoNum);
        boolean bonusAgreement = bonusAgreement(bonusNum, lottoRandomNum);
        int agreementLotto = agreementLotto(lottoStart, bonusAgreement);
    }

//    int lottoStart;

    // 구매금액입력
    /**
     * 6. buyLotto (로또 구입) 완료 <br/>
     * 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다. <br/>
     * 1장에 1,000원. 소숫점 예외처리 발생 <br/>
     * inputMoney % 1000 != 0 예외발생!<br/>
     * buyLotto return 값으로 1. lottoRandomNum n회차 돌리기
     * 
     * @return
     */
    public static int buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 타입 오류.");
        }
        if (inputMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액 입력 오류.");
        }

        int buyLotto = inputMoney / 1000;

        return buyLotto;
    }

    // 랜덤 로또번호 뽑기
    /**
     * 1. lottoRandomNum (Lotto 랜덤 숫자뽑기) 완료 <br/>
     * 숫자 1 ~ 45 Random, 중복되지 않는 숫자 6개 오름차순 저장
     * 
     * @return
     */
    public static List<Integer> lottoRandomNum() {
        List<Integer> lottoRandomNum = new ArrayList<Integer>();
        while (lottoRandomNum.size() < 6) {
            List<Integer> lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            if (!lottoRandomNum.contains(lottoNum)) {
                lottoRandomNum.addAll(lottoNum);
                Collections.sort(lottoRandomNum);
            }
        }
        return lottoRandomNum;
    }

    // 랜덤 로또번호 리스트 출력
    /**
     * 10. buyLottoPrint (구매한 로또 lottoRandomNum 리스트 출력) 완료 <br/>
     * 
     * @param lottoRandomNum
     * @return
     */
    public static List<List<Integer>> buyLottoPrint(int buyLotto) {
        List<List<Integer>> buyLottoPrint = new ArrayList<List<Integer>>();
        System.out.println(buyLotto + "개를 구매했습니다.");

        for (int i = 0; i < buyLotto; i++) {
            buyLottoPrint.add(lottoRandomNum());
        }
        for (int i = 0; i < buyLottoPrint.size(); i++) {
            System.out.println(buyLottoPrint.get(i));
        }
        return buyLottoPrint;
    }

    // 당첨번호 입력
    /**
     * 2. myLottoNum (내가 뽑은 Lotto 숫자) 완료
     * 
     * @param myLottoNum
     */
    public static Lotto myLottoNum() {
        System.out.print("당첨 번호를 입력해 주세요.");
        String myPickNum = Console.readLine();

        String[] numbers = myPickNum.split(",");

        List<Integer> myLottoNum = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            try {
                myLottoNum.add(Integer.parseInt(numbers[i]));
                Collections.sort(myLottoNum);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력 타입 오류.");
            }
        }
        return new Lotto(myLottoNum);
    }

    // 보너스 번호 입력
    /**
     * 2-1. bonusNum (보너스 번호) 완료
     * 
     * @return
     */
    public static int bonusNum(Lotto myLottoNum) {
        System.out.print("보너스 번호를 입력해 주세요.");
        int bonusPick = 0;
        try {
            bonusPick = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 타입 오류.");
        }

        int bonusNum = 0;
        if (myLottoNum.contains(bonusPick)) {
            throw new IllegalArgumentException("[ERROR] 중복입력.에러 발생.");
        }
        if (!myLottoNum.contains(bonusPick)) {

        }

        return bonusPick;
    }

    // 로또번호 대조
    /**
     * 4. lottoStart (로또 번호 대조하기) 완료 <br/>
     * 
     * @param lottoRandomNum
     * @param myLottoNum
     * @return
     */
    public static int lottoStart(List<Integer> lottoRandomNum, Lotto myLottoNum) {

        int agreementCount = 0;

        for (int i = 0; i < lottoRandomNum.size(); i++) {
            if (myLottoNum.contains(lottoRandomNum.get(i))) {
                agreementCount++;
            }
        }
        System.out.println(agreementCount);
        return agreementCount;
    }

    // 보너스 번호 대조
    /**
     * 4-1. bonusAgreement (보너스 번호 대조) 완료 <br/>
     * bonusNum, lottoRandomNum 전달 return
     * 
     * @param bonusNum
     * @param lottoRandomNum
     * @return
     */
    public static boolean bonusAgreement(int bonusNum, List<Integer> lottoRandomNum) {
        return lottoRandomNum.contains(bonusNum);
    }

    // 당첨 등수 리턴
    /**
     * 4-2. agreementLotto (로또 당첨 등수 리턴) 완료 <br/>
     * lottoStart (로또 번호 대조하기) 값에 따른 등수 리턴 <br/>
     * 
     * @param lottoStart
     * @return
     */
    public static int agreementLotto(int lottoStart, boolean bonusAgreement) {
        int agreementLotto = 0;

        if (lottoStart == 6) {
            agreementLotto = 1;
        }
        if (lottoStart == 5 && bonusAgreement) {
            agreementLotto = 2;
        }
        if (lottoStart == 5) {
            agreementLotto = 3;
        }
        if (lottoStart == 4) {
            agreementLotto = 4;
        }
        if (lottoStart == 3) {
            agreementLotto = 5;
        }
        return agreementLotto;
    }
}
