package tdd.kata;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	public static final int MAX_PIN_ON_A_FRAME = 10;
	private final List<Integer> rolls = new ArrayList<>();

	public void roll(int i) {
		this.rolls.add(i);
	}

	public int score() {
		int score = 0;

		for (int rollIdx = 0; rollIdx < rolls.size(); rollIdx++) {
			if (isStrike(rollIdx)) {
				score += MAX_PIN_ON_A_FRAME + strikeBonus(rollIdx);
				if (rollIdx == 9) {
					rollIdx = 11;
				}
			} else if (frameScore(rollIdx) == MAX_PIN_ON_A_FRAME) {
				score += frameScore(rollIdx) + spareBonus(rollIdx);
				rollIdx = rollIdx + 1;
				if (rollIdx == 19) {
					rollIdx = 21;
				}
			} else {
				score += frameScore(rollIdx);
				rollIdx = rollIdx + 1;
			}
		}


		return score;
	}

	private static boolean isLastFrame(int frame) {
		return frame == 9;
	}

	private int frameScore(int rollIndex) {
		return rolls.get(rollIndex) + rolls.get(rollIndex + 1);
	}

	private boolean isStrike(int currFrame) {
		return rolls.get(currFrame) == MAX_PIN_ON_A_FRAME;
	}

	private Integer spareBonus(int rollIndex) {
		return rolls.get(rollIndex + 2);
	}

	private int strikeBonus(int rollIndex) {
		return rolls.get(rollIndex + 1) + rolls.get(rollIndex + 2);
	}


}
