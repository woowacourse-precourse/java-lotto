package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static User user;
    public static int lottoEA;
    public static ArrayList<List<Integer>> lotteryOfUser;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void buyer(User user){
        this.user = user;
    }

    private void printLotto(){
        int lottoPrice = user.getLottoPrice();
        this.lottoEA = lottoPrice / 1000;
        System.out.println(lottoEA + "개를 구매했습니다.");
    }

    private void printRandomNumbers(){
        for(int ea=1; ea<lottoEA; ea++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            lotteryOfUser.add(numbers);
            System.out.println(numbers);
        }
    }

    public ArrayList<List<Integer>> getLotteryOfUser(){
        return lotteryOfUser;
    }


}
