package tdd.kata;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	public static final int MAX_PIN_ON_A_FRAME = 10;
	public static final int MAX_FRAME = 10;
	private final List<Integer> rolls = new ArrayList<>();


	public void roll(int i) {
		this.rolls.add(i);
	}

	public int score() {
		int score = 0;
		int currRoll = 0;

		for (int currFrame = 0; currFrame < MAX_FRAME; currFrame++) {

			if (isStrike(currRoll)) {
				score += MAX_PIN_ON_A_FRAME + strikeBonus(currRoll);
			} else if (isSpare(currRoll)) {
				score += MAX_PIN_ON_A_FRAME + spareBonus(currRoll);
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
