package lotto.data.type;

import java.util.Collections;
import java.util.List;

public enum StepType {
    INIT,
    BUY_LOTTO,
    DECIDE_WINNER,
    DECIDE_BONUS,
    GIVE_RESULT,
    FINISH;

    private StepType nextStep;
    private StepType prevStep;

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
