package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static constants.Constant.*;
import static constants.Message.*;
import static constants.ErrorMessage.*;

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

    private void checkRange(String inputMoney) {
        if (!inputMoney.matches(REG_EXP_NUMBER_ONLY)) {
            System.out.println(ERROR_INPUT_PAY_AMOUNT);
            throw new IllegalArgumentException();
        }
    }

    private void checkAmount(String inputMoney) {
        if (Integer.parseInt(inputMoney) % PRICE_OF_ONE_TICKET != 0) {
            System.out.println(ERROR_INPUT_PAY_AMOUNT);
            throw new IllegalArgumentException(ERROR_INPUT_PAY_AMOUNT);
        }
    }

    public int countNumberOfTickets() {
        this.numberOfTickets = payAmount / PRICE_OF_ONE_TICKET;
        return numberOfTickets;
    }

    public List<List<Integer>> generateTickets() {
        TicketMachine newTickets = new TicketMachine(numberOfTickets);

        newLottos = newTickets.generateTickets();

        return newLottos;
    }

    public void printTicket() {
        System.out.println("\n" + numberOfTickets + MESSAGE_NUMBER_OF_TICKET_IS);

        for (int i = 0; i < numberOfTickets; i++) {
            System.out.println(newLottos.get(i).toString());
        }
    }
}