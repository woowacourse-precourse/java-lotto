package lotto.data.type;

import java.util.Collections;
import java.util.List;

public enum StepType {
    INIT(List.of()),
    BUY_LOTTO(List.of(CommandType.BUY_WITH_MONEY)),
    DECIDE_WINNER(List.of(CommandType.WINNING_NUMBER)),
    DECIDE_BONUS(List.of(CommandType.BONUS_NUMBER)),
    GIVE_RESULT(List.of()),
    FINISH(List.of());

    private final List<CommandType> possibleCommands;
    private StepType nextStep;
    private StepType prevStep;

    StepType(List<CommandType> commandTypes) {
        this.possibleCommands = Collections.unmodifiableList(commandTypes);
    }

    public List<CommandType> getPossibleCommands() {
        return this.possibleCommands;
    }

    public StepType getNextStep() {
        return this.nextStep;
    }

    public StepType getPrevStep() {
        return this.prevStep;
    }

    static {
        StepType[] stepTypes = StepType.values();
        int bound = stepTypes.length - 1;
        for (int index = 0; index < bound; index++) {
            stepTypes[index].nextStep = stepTypes[index + 1];
            stepTypes[index + 1].prevStep = stepTypes[index];
        }
    }
}
