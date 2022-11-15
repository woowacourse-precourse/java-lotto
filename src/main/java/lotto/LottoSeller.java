package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static Constants.Constant.*;
import static Constants.Error.ERROR_INPUT_PAY_AMOUNT;

public class LottoSeller {
    int payAmount;
    int numberOfTickets;
    List<List<Integer>> newLottos = new ArrayList<>();

    public void getPayAmount() {
        System.out.println(MESSAGE_INPUT_PAY_AMOUNT);

        String inputMoney = Console.readLine();
        validate(inputMoney);

        this.payAmount = Integer.parseInt(inputMoney);
    }

    public void validate(String inputMoney) {
        checkRange(inputMoney);
        checkAmount(inputMoney);
    }

    private void checkRange(String inputMoney){
        if (!inputMoney.matches("[0-9]+")) {
            System.out.println(ERROR_INPUT_PAY_AMOUNT);
            throw new IllegalArgumentException();
        }
    }
    private void checkAmount(String inputMoney){
        if (Integer.parseInt(inputMoney) % 1000 != 0) {
            System.out.println(ERROR_INPUT_PAY_AMOUNT);
            throw new IllegalArgumentException(ERROR_INPUT_PAY_AMOUNT);
        }
    }
    public int countNumberOfTickets() {
        this.numberOfTickets = payAmount / 1000;
        return numberOfTickets;
    }

    public List<List<Integer>> generateTickets() {
        NumberGenerator newNumbers = new NumberGenerator(numberOfTickets);

        newNumbers.generateNumbers();
        newLottos = newNumbers.myLotto;
        return newLottos;
    }

    public void printTicket() {
        System.out.println(numberOfTickets + MESSAGE_NUMBER_OF_TICKET_IS);

        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println(newLottos.get(i).toString());
        }
    }
}