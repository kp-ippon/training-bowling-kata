package tdd.kata;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
class BowlingGameTest {


	@Test
	void score_return_the_number_of_pin_when_a_uniq_success_roll_is_done_with_9pins() {
		BowlingGame game = new BowlingGame();

		game.roll(9);
		fullfilGameWithGlutterRoll(game);

		assertThat(game.score()).isEqualTo(9);
	}

	private static void fullfilGameWithGlutterRoll(BowlingGame game) {
		IntStream.range(0, 19).forEach(
				(idx) -> game.roll(0)
		);
	}
}
