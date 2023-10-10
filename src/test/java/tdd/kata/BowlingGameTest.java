package tdd.kata;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {
	private static void fullfilWithStrike(BowlingGame game, int complementaryRoll) {
		IntStream.range(0, complementaryRoll).forEach(idx -> game.roll(10));
	}

	private static void fulfillRollGame(BowlingGame game, int complementaryRolls, int rollToUse) {
		IntStream.range(0, complementaryRolls).forEach(
				(idx) -> game.roll(rollToUse)
		);
	}

	@Test
	void score_return_the_number_of_pin_when_a_uniq_success_roll_is_done_with_9pins() {
		BowlingGame game = new BowlingGame();

		game.roll(9);
		fulfillRollGame(game, 19, 0);

		assertThat(game.score()).isEqualTo(9);
	}

	@Test
	void score_return_the_number_of_pin_when_a_uniq_success_roll_is_done_with_8pins() {
		BowlingGame game = new BowlingGame();

		game.roll(8);
		fulfillRollGame(game, 19, 0);

		assertThat(game.score()).isEqualTo(8);
	}

	@Test
	void score_return_the_number_of_pin_when_a_spare_is_done() {
		BowlingGame game = new BowlingGame();

		game.roll(8);
		game.roll(2);
		game.roll(1);
		fulfillRollGame(game, 17, 0);

		assertThat(game.score()).isEqualTo(12);
	}

	@Test
	void score_a_strike_should_apply_a_bonus_with_2_following_rolls() {
		BowlingGame game = new BowlingGame();

		game.roll(10);
		game.roll(2);
		game.roll(2);
		fulfillRollGame(game, 16, 0);

		assertThat(game.score()).isEqualTo(18);
	}

	@Test
	void score_a_perfect_game() {
		BowlingGame game = new BowlingGame();


		fullfilWithStrike(game, 12);

		assertThat(game.score()).isEqualTo(300);
	}

	@Test
	void score_a_game_without_spare_and_strike() {
		BowlingGame game = new BowlingGame();


		fulfillRollGame(game, 20, 1);
		assertThat(game.score()).isEqualTo(20);
	}


	@Test
	void score_a_game_with_only_spare() {
		BowlingGame game = new BowlingGame();
		fulfillRollGame(game, 21, 5);
		assertThat(game.score()).isEqualTo(150);
	}


	@Test
	void score_game_with_strike_at_the_end() {
		BowlingGame game = new BowlingGame();

		fulfillRollGame(game, 18, 1);
		fulfillRollGame(game, 3, 10);
		assertThat(game.score()).isEqualTo(48);
	}
}
