package lotto.screen;

/*
키보드로 입력해서 테스트 하기 위한 클래스
 */

import java.util.Scanner;
import java.util.function.Function;

public class KeyboardInput implements Input {
    private static KeyboardInput keyboardInput = new KeyboardInput();

    private KeyboardInput() {
    }

    public static KeyboardInput getInstance() {
        return keyboardInput;
    }
    @Override
    public String inputValue() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public Object input(String prompt, Function<String , Object> function) {
        System.out.print(prompt);
        return function.apply(inputValue());
    }
}
