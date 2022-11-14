package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public void playGame() {
        System.out.println("당첨번를 입력해 주세요.");
        String userInput = Console.readLine();
        this.numbers = makeList(userInput);
        validate(numbers);

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusInput = Integer.parseInt(Console.readLine());
        numbers.add(bonusInput);
        checkNum(numbers);

    }

    //사용자 입력받은거 리스트로 바꾸기
    public List<Integer> makeList(String userInput) {
        String[] arrayInput = userInput.split(",");
        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            userNumbers.add(Integer.parseInt(arrayInput[i]));
        }
        return userNumbers;
    }
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }

    }

    private void checkNum(List<Integer> numbers){
        // TODO: 중복
        if(numbers.size() != numbers.stream().distinct().count()){
            throw new IllegalArgumentException();
        }
    }

}
