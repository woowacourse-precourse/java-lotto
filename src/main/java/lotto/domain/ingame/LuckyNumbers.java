package lotto.domain.ingame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckyNumbers {

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private final List<Integer> luckyBalls;
    private final int bonus;

    public LuckyNumbers(List<Integer> luckyBalls, int bonus) {

        validate(luckyBalls, bonus);

        Collections.sort(luckyBalls);

        this.luckyBalls = luckyBalls;
        this.bonus = bonus;
    }

    private static void validate(List<Integer> luckyBalls, int bonus) {

        List<Integer> balls = gatherBalls(luckyBalls, bonus);

        validateBallsInRange(balls);
        validateBallsUnique(balls);
    }

    private static void validateBallsUnique(List<Integer> balls) {
        if (balls.size()!= balls.stream().distinct().count()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    private static List<Integer> gatherBalls(List<Integer> luckyBalls, int bonus) {

        List<Integer> balls = new ArrayList<>();

        balls.addAll(luckyBalls);
        balls.add(bonus);

        return balls;
    }

    private static void validateBallsInRange(List<Integer> balls) {


        for (Integer ball : balls) {
            if (ball < LOTTO_MIN || ball > LOTTO_MAX) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getLuckyBalls() {
        return luckyBalls;
    }

    public int getBonus(){
        return bonus;
    }
}
