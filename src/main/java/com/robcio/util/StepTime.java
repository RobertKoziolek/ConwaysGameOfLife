package com.robcio.util;

import lombok.Getter;

import static com.robcio.util.Constants.*;

public class StepTime {
    @Getter
    private int stepTime = STEP_TIME;
    private final int changeStep = MAX_STEP_TIME / 30;
    private float changeValue = 1.2f;

    public void slowSpeed() {
        stepTime = (int)Math.min(stepTime * changeValue, MAX_STEP_TIME);
    }

    public void hastenSpeed() {
        stepTime = (int)Math.max(changeStep / changeValue, MIN_STEP_TIME);
    }
}
