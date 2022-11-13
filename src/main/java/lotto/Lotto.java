package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        try{
            validate(numbers);
        }catch(IllegalArgumentException e){
            System.err.println("[ERROR] "+e);
        }
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public static void lottoMaking(Integer lottoAmount){
        System.out.println(lottoAmount+"개를 구매했습니다.");
        List<List<Integer>> allLottos = new ArrayList<>();
        for (int i=0; i<lottoAmount; i++){
            List<Integer> userLotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            System.out.println(userLotto);
            allLottos.add(userLotto);
        }

    }

    private void validate(List<Integer> guess) throws IllegalArgumentException{
        if (guess.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int i=0; i<6; i++) {
            validateOne(guess.get(i));
        }
        Set<Integer> guessNoDup = new HashSet<>(guess);
        if (guessNoDup.size() != 6){
            throw new IllegalArgumentException();
        }
    }

    // check individual
    public static void validateOne(Integer bonus) throws IllegalArgumentException{
        if (bonus>46 || bonus<1){
            throw new IllegalArgumentException();
        }
    }

    // check duplicate of bonus and guess
    public static void validDuplicate(Integer bonus) throws IllegalArgumentException{
        if (User.guess.contains(String.valueOf(bonus))){
            throw new IllegalArgumentException();
        }
    }
}
