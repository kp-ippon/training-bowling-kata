package tdd.kata;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	public static final int MAX_PIN_ON_A_FRAME = 10;
	private final List<Integer> rolls = new ArrayList<>();

	private static int goToEndOfFrame(int rollIdx) {
		return rollIdx + 2;
	}

	public void roll(int i) {
		this.rolls.add(i);
	}

	public int score() {
		int score = 0;
		int currRoll = 0;

		for (int currFrame = 0; currFrame < 10; currFrame++) {

			if (isStrike(currRoll)) {
				score += MAX_PIN_ON_A_FRAME + strikeBonus(currRoll);
			} else if (isSpare(currRoll)) {
				score += getFrameScore(currRoll) + spareBonus(currRoll);
			} else {
				score += getFrameScore(currRoll);
			}

			currRoll = goToNextFrame(currRoll);
		}

		return score;
	}

	private int goToNextFrame(int currRoll) {
		if (isStrike(currRoll)) {

			return currRoll + 1;
		}
		return currRoll + 2;
	}

	private boolean isLastFrame(int rollIdx) {
		return rollIdx == (rolls.size() - 3);
	}

	private boolean isSpare(int rollIdx) {
		return getFrameScore(rollIdx) == MAX_PIN_ON_A_FRAME;
	}

	private boolean isStrike(int rollIdx) {
		return rolls.get(rollIdx) == MAX_PIN_ON_A_FRAME;
	}

	private int getFrameScore(int rollIdx) {
		return rolls.get(rollIdx) + rolls.get(rollIdx + 1);
	}

	private Integer spareBonus(int rollIndex) {
		return rolls.get(rollIndex + 2);
	}

	private int strikeBonus(int rollIndex) {
		return rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
	}


}
