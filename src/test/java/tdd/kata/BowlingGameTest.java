package tdd.kata;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {
	private static void fullfilWithStrike(BowlingGame game) {
		IntStream.range(0, 12).forEach(i -> {
			game.roll(10);
		});
	}

	private static void fulfillGameWithGutterRoll(BowlingGame game, int complementaryRolls) {
		IntStream.range(0, complementaryRolls).forEach(
				(idx) -> game.roll(0)
		);
	}

	@Test
	void score_return_the_number_of_pin_when_a_uniq_success_roll_is_done_with_9pins() {
		BowlingGame game = new BowlingGame();

		game.roll(9);
		fulfillGameWithGutterRoll(game, 19);

		assertThat(game.score()).isEqualTo(9);
	}

	@Test
	void score_return_the_number_of_pin_when_a_uniq_success_roll_is_done_with_8pins() {
		BowlingGame game = new BowlingGame();

		game.roll(8);
		fulfillGameWithGutterRoll(game, 19);

		assertThat(game.score()).isEqualTo(8);
	}

	@Test
	void score_return_the_number_of_pin_when_a_spare_is_done() {
		BowlingGame game = new BowlingGame();

		game.roll(8);
		game.roll(2);
		game.roll(1);
		fulfillGameWithGutterRoll(game, 17);

		assertThat(game.score()).isEqualTo(12);
	}


  /*  @Test
    void score_only_spare_and_finish_with_5pin_on_last_roll() {
        BowlingGame game = new BowlingGame();


        IntStream.range(0,21).forEach(i -> {
            game.roll(5);
        });

        assertThat(game.score()).isEqualTo(150);
    }*/

	@Test
	void score_a_strike_should_apply_a_bonus_with_2_following_rolls() {
		BowlingGame game = new BowlingGame();

		game.roll(10);
		game.roll(2);
		game.roll(2);
		fulfillGameWithGutterRoll(game, 16);

		assertThat(game.score()).isEqualTo(18);
	}

	@Test
	void score_a_perfect_game() {
		BowlingGame game = new BowlingGame();


		fullfilWithStrike(game);

		assertThat(game.score()).isEqualTo(300);
	}

	@Test
	void score_a_game_without_spare_and_strike() {
		BowlingGame game = new BowlingGame();


		IntStream.range(0, 20).forEach(
				(idx) -> game.roll(1)
		);
		assertThat(game.score()).isEqualTo(20);
	}


	@Test
	void score_a_game_with_only_spare() {
		BowlingGame game = new BowlingGame();


		IntStream.range(0, 21).forEach(
				(idx) -> game.roll(5)
		);
		assertThat(game.score()).isEqualTo(150);
	}


	@Test
	void score_game_with_strike_at_the_end() {
		BowlingGame game = new BowlingGame();

		IntStream.range(0, 18).forEach(
				(idx) -> game.roll(1)
		);
		IntStream.range(0, 3).forEach(
				(idx) -> game.roll(10)
		);
		assertThat(game.score()).isEqualTo(48);
	}
}
