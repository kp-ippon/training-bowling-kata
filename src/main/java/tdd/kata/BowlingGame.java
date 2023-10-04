package tdd.kata;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	public static final int MAX_PIN_ON_A_FRAME = 10;
	private final List<Integer> rolls = new ArrayList<>();

	private static int goToEndOfFrame(int rollIdx) {
		return rollIdx + 1;
	}

	public void roll(int i) {
		this.rolls.add(i);
	}

	public int score() {
		int score = 0;
		int rollIdx = 0;

		while (rollIdx < rolls.size()) {
			if (isStrike(rollIdx)) {
				score += MAX_PIN_ON_A_FRAME + strikeBonus(rollIdx);
				if (isLastFrame(rollIdx)) {
					break;
				}
			} else if (isSpare(rollIdx)) {
				score += getFrameScore(rollIdx) + spareBonus(rollIdx);
				if (isLastFrame(rollIdx)) {
					break;
				} else {
					rollIdx = goToEndOfFrame(rollIdx);
				}
			} else {
				score += getFrameScore(rollIdx);
				rollIdx = goToEndOfFrame(rollIdx);
			}
			rollIdx++;
		}


		return score;
	}

	private boolean isLastFrame(int rollIdx) {
		return rollIdx == (rolls.size() - 3);
	}


	private static boolean isSpareLastFrame(int rollIdx) {
		return rollIdx == 19;
	}

	private static boolean isStrikeLastFrame(int rollIdx) {
		return rollIdx == 9;
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
