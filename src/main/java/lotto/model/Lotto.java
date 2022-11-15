package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> game;
    private final int NUMBERS_SIZE = 6;
    private final int MIN_RANGE_NUMBER = 1;
    private final int MAX_RANGE_NUMBER = 45;

    public Lotto(List<Integer> game) {
        validate(game);
        this.game = game;
    }

    public List<Integer> getGame() {
        return game;
    }

    protected void validate(List<Integer> game) {
        validateSize(game);
        validateOverlap(game);
        game.forEach(this::validateRange);
        game.sort(Comparator.naturalOrder());
    }
    protected void validateOverlap(List<Integer> game){
        if(game.size() != game.stream().distinct().count()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
    protected void validateSize(List<Integer> game){
        if (game.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야만 합니다.");
        }
    }
    protected void validateRange(int number){
        if(number < MIN_RANGE_NUMBER || number > MAX_RANGE_NUMBER){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
