package tdd.kata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BowlingGame {
    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int i) {
        this.rolls.add(i);
    }

    public int score() {
        int score = 0;
        for (int index = 0; index < rolls.size(); index++) {
            if (index + 1 < rolls.size() && frameScore(index) == 10) {
                score += frameScore(index) + firstRollOfNextFrame(index);
                index++;
            } else {
                score += currentRollScore(index);
            }
        }
        return score;
    }

    private Integer currentRollScore(int index) {
        return rolls.get(index);
    }

    private Integer firstRollOfNextFrame(int index) {
        return rolls.get(index + 2);
    }

    private int frameScore(int index) {
        return currentRollScore(index) + rolls.get(index + 1);
    }
}
