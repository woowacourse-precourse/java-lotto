package lotto.model.database;

import lotto.model.Lotto;
import lotto.model.Raffle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Draw {
    private static Draw ticket;
    private final List<Raffle> database;

    private Draw() {
        this.database = new LinkedList<>();
    }

    public static Draw getInstance() {
        if (ticket == null) {
            ticket = newInstance();
        }

        return ticket;
    }

    public static Draw newInstance() {
        return new Draw();
    }

    public boolean insert(Raffle raffle) {
        return this.database.add(raffle);
    }

    public Raffle getLatest() {
        return this.database.get(this.database.size() - 1);
    }
}
