package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import static lotto.ErrorCode.*;

public class Logic {

    static long MATCH_THREE = 5000;
    static long MATCH_FOUR = 50000;
    static long MATCH_FIVE = 1500000;
    static long MATCH_BONUS = 30000000;
    static long MATCH_SIX = 2000000000;

    int checkPieces(String input) {
        throwInputExceptions(input.length() > 3,
                PRICE_INCORRECT_INPUT);
        for(int i = input.length() - 1; i >= input.length() - 3; --i) {
            throwInputExceptions(input.charAt(i) == '0', PRICE_INCORRECT_INPUT);
        }
        int ans = 0;
        char c;
        for(int i = 0; i <= input.length() - 4; ++i) {
            ans *= 10;
            c = input.charAt(i);
            if(i == 0)
                throwInputExceptions(c > '0' && c <= '9', PRICE_INCORRECT_INPUT);
            throwInputExceptions(c >= '0' && c <= '9', PRICE_INCORRECT_INPUT);
            ans += c - '0';
        }
        return ans;
    }

    List<Integer> lotto_Validate(List<Integer> numbers) {
        throwInputExceptions(numbers.size() == 6, LOTTERY_INADEQUATE_NUMBER_AMOUNT);

        int frequency; // 확인할 빈도 수
        int comp; // 중복 확인하기 위해 각 순회마다 받을 배열
        Iterator<Integer> iter = numbers.iterator();
        while(iter.hasNext()) {
            comp = iter.next();
            throwInputExceptions(comp >= 1 && comp <= 45, LOTTERY_OUT_OF_RANGE);
            frequency = Collections.frequency(numbers, comp);
            throwInputExceptions(frequency == 1, LOTTERY_DUPLICATED_NUMBER);
        }
        return numbers;
    }

    void throwInputExceptions(boolean condition, ErrorCode exceptionMessage) {
        if(condition) {
            return;
        }
        throw new IllegalArgumentException(exceptionMessage.getMessage());
    }

    public List<Lotto> setLottos(int amount) {
        List<Lotto> answer = new ArrayList<>();
        for(int i = 0; i < amount; ++i) {
            List<Integer> lottoNum = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNum); // 여기서 에러 발생
            answer.add(new Lotto(lottoNum));
        }
        return answer;
    }

    public List<Integer> setJackpot(String input) {
        List<Integer> answer = new ArrayList<>();

        String[] temp = input.split(",");
        for(int i = 0; i < temp.length; ++i) {
            answer.add(checkNum(temp[i]));
        }
        return answer;
    }

    public int setBonus(String input, List<Integer> jackpot) {
        int ans = checkNum(input);
        int frequency = Collections.frequency(jackpot, ans);
        throwInputExceptions(frequency == 0, BONUS_DUPLICATED_NUMBER);
        return ans;
    }

    private int checkNum(String input) {
        int len = input.length();
        throwInputExceptions(len > 0, JACKPOT_OUT_OF_RANGE);
        int ans = 0;
        char c;
        for(int i = 0; i < input.length(); ++i) {
            ans *= 10;
            c = input.charAt(i);
            if(i == 0)
                throwInputExceptions(c > '0' && c <= '9', JACKPOT_OUT_OF_RANGE);
            throwInputExceptions(c >= '0' && c <= '9', JACKPOT_OUT_OF_RANGE);
            ans += c - '0';
        }
        throwInputExceptions(ans >= 1 && ans <= 45, JACKPOT_OUT_OF_RANGE);
        return ans;
    }

    int[] getCorrects(List<Integer> jackpot, List<Lotto> lottos, int bonus) {
        int[] ans = new int[5]; // 0번째 : 3개, 1번째 : 4개, 2번째 : 5개, 3번째 : 5개+보너스, 4번째: 6개
        int mode;
        for(int i = 0; i < lottos.size(); ++i) {
            mode = getLottoResult(jackpot, lottos.get(i).getNumbers(), bonus);
            if(mode < 0)
                continue;
            ans[mode] += 1;
        }
        return ans;
    }

    int getLottoResult(List<Integer> jackpot, List<Integer> comp, int bonus) {
        int count = 0;
        boolean bonusCheck = false;
        int frequency;
        for(int i = 0; i < comp.size(); ++i) {
            frequency = Collections.frequency(jackpot, comp.get(i));
            if(frequency == 1) {
                ++count;
            }
        }
        if(Collections.frequency(comp, bonus) > 0) {
            bonusCheck = true;
        }
        if(count <= 2) {
            return -1;
        }
        if(count == 3) {
            return 0;
        }
        if(count == 4) {
            return 1;
        }
        if(count == 5 && !bonusCheck) {
            return 2;
        }
        if(count == 5 && !bonusCheck) {
            return 3;
        }
        return 4; // 6일 때는 4번째에 넣기
    }

    long getPrices(int three, int four, int five, int fiveWithBonus, int six) {
        long ans = 0;
        ans += three * MATCH_THREE;
        ans += four * MATCH_FOUR;
        ans += five * MATCH_FIVE;
        ans += fiveWithBonus * MATCH_BONUS;
        ans += six * MATCH_SIX;
        return ans;
    }
}
