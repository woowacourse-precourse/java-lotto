package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    public static int pickBonusNumber(Lotto luckyLotto){
        int bonusNumber;
        try{
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값을 입력할 수 없습니다.");
        }

        validateBonusNumber(bonusNumber, luckyLotto.getLottoNumbers());

        return 0;
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> luckyNumber){
        if (bonusNumber < 1 || bonusNumber > 45){
            throw new IllegalArgumentException("[ERROR] 1~45 범위를 벗어나는 값을 입력할 수 없습니다.");
        }
        if (luckyNumber.stream().anyMatch(i -> i.equals(bonusNumber))){
            throw new IllegalArgumentException("[ERROR] 기존 당첨 번호와 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    /**
     * 로또 번호들과 당첨 번호를 비교하여 당첨 결과를 반환
     * @param lottos 로또 번호들
     * @param luckyNumber 당첨 번호
     * @param bonusNumber 보너스 숫자
     * @return
     */
    public static HashMap<Prize, Integer> getLottoResult(List<Lotto> lottos, Lotto luckyNumber, int bonusNumber){
        HashMap<Prize, Integer> prizes = new HashMap<>();
        for(Lotto lotto : lottos){
            int duplicated = getDuplicatedNumber(lotto.getLottoNumbers(), luckyNumber.getLottoNumbers());
            boolean bonused = hasBonusNumber(lotto.getLottoNumbers(), bonusNumber);
            Prize prize = ranking(duplicated, bonused);
            if (!prizes.containsKey(prize)){
                prizes.put(prize, 0);
            }
            prizes.put(prize, prizes.get(prize).intValue() + 1);
        }
        return prizes;
    }

    public static int getDuplicatedNumber(List<Integer> target, List<Integer> luckyNumber){
        int duplicated = 0;
        for(Integer number : luckyNumber){
            if (target.contains(number)){
                duplicated++;
            }
        }
        return duplicated;
    }

    public static boolean hasBonusNumber(List<Integer> target, int bonusNumber){
        if (target.contains(bonusNumber))
            return true;
        return false;
    }

    public static Prize ranking(int duplicated, boolean bonused){
        if (duplicated < 3){
            return Prize.NONE;
        }
        if (duplicated == 5 && bonused){
            return Prize.SECOND;
        }
        List<Prize> prizes = List.of(Prize.FIRST, Prize.THIRD, Prize.FOURTH, Prize.FIFTH);
        Prize prize = prizes.get(6 - duplicated);
        return prizes.get(6 - duplicated);
    }

    /**
     * 로또 구매 금액과 당첨 금액을 바탕으로 수익률을 계산
     * @return 수익률
     */
    public static BigDecimal getProfitRate(int purchased, int profit){
        // double 연산 시 연산 결과가 지수 표현으로 나오는 경우 -> 알아보기가 힘듦
        // BigDecimal을 이용하여 지수 표현 제거
        BigDecimal a = new BigDecimal(purchased / 100);
        BigDecimal b = new BigDecimal(profit);
        BigDecimal profitRate = b.divide(a, 2, RoundingMode.HALF_EVEN).stripTrailingZeros();
        System.out.println(profitRate.toPlainString());
        return profitRate;
    }

    public static int getProfit(HashMap<Prize, Integer> prizes){
        int profit = 0;
        for (Prize prize : prizes.keySet()){
            profit += prizes.get(prize).intValue() * prize.getValue();
        }
        return profit;
    }

    /**
     * 당첨 결과 상수를 정의하고 있는 enum
     */
    enum Prize{
        FIRST(2_000_000_000),
        SECOND(30_000_000),
        THIRD(1_500_000),
        FOURTH(50_000),
        FIFTH(5_000),
        NONE(0);
        private final int prizeMoney;
        Prize(int prizeMoney) { this.prizeMoney = prizeMoney; }
        public int getValue() { return prizeMoney; }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}