package tdd.kata;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingGameTest {
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

    private static void fulfillGameWithGutterRoll(BowlingGame game, int complementaryRolls) {
        IntStream.range(0, complementaryRolls).forEach(
                (idx) -> game.roll(0)
        );
    }
}
