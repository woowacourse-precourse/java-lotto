package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.Constant.*;

public class LottoSeller {
    int payAmount;
    int numberOfTickets;
    List<List<Integer>> newLottos = new ArrayList<>();

    public void getPayAmount() {
        System.out.println(MESSAGE_INPUT_PAY_AMOUNT);
        this.payAmount = Integer.parseInt(Console.readLine());

        if (payAmount > 0 && payAmount % 1000 == 0) {

        }
        if (payAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INPUT_PAY_AMOUNT);
        }
    }

    public int countTicket() {
        return payAmount / 1000;
    }

    public void generateTickets() {
        NumberGenerator newNumbers = new NumberGenerator(numberOfTickets);
        newNumbers.generateNumbers();
        newLottos = newNumbers.myLotto;
    }

    public void printTicket() {
        System.out.println(numberOfTickets + MESSAGE_NUMBER_OF_TICKET_IS);

        this.generateTickets();

        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println(newLottos.get(i).toString());
        }
    }

}