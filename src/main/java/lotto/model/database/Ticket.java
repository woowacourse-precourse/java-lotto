package lotto.model.database;

import lotto.model.Lotto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ticket {
    private static Ticket ticket;

    private final List<Lotto> database;

    private Ticket() {
        this.database = new LinkedList<>();
    }

    public static Ticket getInstance() {
        if (ticket == null) {
            ticket = newInstance();
        }

        return ticket;
    }

    public static Ticket newInstance() {
        return new Ticket();
    }

    public boolean insert(Lotto lotto) {
        return this.database.add(lotto);
    }

    public List<Lotto> getAll() {
        return Collections.unmodifiableList(this.database);
    }
}
