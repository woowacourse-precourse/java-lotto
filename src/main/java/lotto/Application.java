package lotto;

import lotto.view.Print;

import java.util.ArrayList;
import java.util.List;

import static lotto.Player.numberOfLottos;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> numbers = new ArrayList<>();
        Print.requestMoneyMessage();
        Player.getMoney();
        System.out.println("총 " + numberOfLottos + " 개의 로또 구입");
    }
}
