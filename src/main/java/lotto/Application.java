package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    final static int AMOUNT_PER_LOTTO = 1000;

    /**
     * 입력한 금액을 바탕으로 구매한 로또의 개수를 반환(로또 1장 당 1000원)
     * @return 구매한 로또의 개수
     */
    public static int buyLotto(){
        System.out.println("구입금액을 입력해 주세요.");
        // 구입 금액을 로또 한 장 가격으로 나누면 몇 장을 사는 지 알 수 있음
        int count = validatedAmountInput() / AMOUNT_PER_LOTTO;
        return count;
    }

    /**
     * 구입 금액을 AMOUNT_PER_LOTTO 로 나눴을 때 나누어 떨어지는 않을 시 예외 처리
     */
    public static int validatedAmountInput(){
        int amount;
        try{
            amount = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
        }
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
        return amount;
    }

    /**
     * 1~45 사이의 랜덤한 로또 번호 6자리를 선택
     * @param count 구매한 로또의 개수
     * @return 구매한 로또 개수 크기의 로또 번호가 들어있는 리스트
     */
    public static List<Lotto> pickLottoNumber(int count){
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < count){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            if (validateLottoNumber(numbers, lottos)){
                System.out.println(numbers);
                lottos.add(new Lotto(numbers));
            }
        }
        return lottos;
    }

    /**
     * 로또 번호가 겹치지 않도록 검증
     * @param lottos 로또 번호가 선택된 로또들
     * @param numbers 랜덤으로 선택한 숫자들
     * @return 중복된 값인지 여부
     */
    public static boolean validateLottoNumber(List<Integer> numbers, List<Lotto> lottos){
        for(Lotto lotto : lottos){
            if (lotto.getLottoNumbers().equals(numbers)){
                return false;
            }
        }
        return true;
    }

    /**
     * 당첨 번호를 입력받음
     * @return 당첨 번호
     */
    public static Lotto pickLuckyNumber(){
        List<String> input = List.of(Console.readLine().split(","));
        List<Integer> numbers;
        try{
            numbers = input.stream()
                    .map(s -> Integer.parseInt(s))
                    .collect(Collectors.toList());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
        }
        Lotto luckyLotto = new Lotto(numbers);
        return luckyLotto;
    }


    /**
     * 보너스 번호를 입력받음
     * @return 보너스 번호
     */
    public static int pickBonusNumber(){
        // TODO: 보너스 숫자 하나를 입력받아 리턴
        // TODO: 잘못된 값을 입력했을 경우 예외처리
        return 0;
    }

    /**
     * 로또 번호들과 당첨 번호를 비교하여 당첨 결과를 반환
     * @param lottos 로또 번호들
     * @param luckyNumber 당첨 번호
     * @param BonusNumber 보너스 숫자
     * @return
     */
    public static List<Prize> getLottoResult(List<Lotto> lottos, Lotto luckyNumber, int BonusNumber){
        // TODO: 로또 번호들과 당첨 번호 및 보너스 숫자를 비교하여 결과 도출
        return null;
    }

    /**
     * 로또 구매 금액과 당첨 금액을 바탕으로 수익률을 계산
     * @return 수익률
     */
    public static float getProfitRate(int buyingCharge, int profit){
        // TODO: 로또 구매 금액과 당첨 금액을 바탕으로 수익률 계산
        return 0f;
    }

    /**
     * 당첨 결과 상수를 정의하고 있는 enum
     */
    enum Prize{
        // TODO: 당첨 결과 enum 구현
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}