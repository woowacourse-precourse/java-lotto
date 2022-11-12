package lotto;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List <Integer> numbers = new ArrayList<>();
        Lotto lotto = new Lotto(numbers);

    }
}
