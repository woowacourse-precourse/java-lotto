package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumber {
    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }


    public void generateLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        userInput = userInput.replaceAll(" ", "");
        List<String> temporaryList = new ArrayList<String>(Arrays.asList(userInput.split(",")));
        List<Integer> numbers = temporaryList.stream().map(Integer::parseInt).collect(Collectors.toList());
        setNumbers(numbers);
    }

}
