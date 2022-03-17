package blackjack.domain;

import blackjack.domain.participant.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BlackJackTest {

    @Test
    @DisplayName("참가자의 수가 8명을 초과하면 예외처리")
    void Player_Number_Exceed_Exception() {
        assertThatThrownBy(() -> {
            List<String> playerNames = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i");
            BlackJack.createFrom(playerNames);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 참가자의 수는 8명을 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("카드를 해당 플레이어에게 한장 나누어주는지")
    void Hand_Out_Card_To() {
        List<String> playerNames = Arrays.asList("a", "b");
        BlackJack blackJack = BlackJack.createFrom(playerNames);
        List<Participant> players = blackJack.getParticipants().getPlayers();
        blackJack.handOutCardTo(players.get(0));
        assertThat(players.get(0).getCards().size()).isEqualTo(1);
        assertThat(players.get(1).getCards().size()).isEqualTo(0);
    }

    @Test
    @DisplayName("스타팅 카드를 두 장씩 배분하는지")
    void Hand_Out_Two_Starting_Cards() {
        List<String> playerNames = Arrays.asList("a", "b");
        BlackJack blackJack = BlackJack.createFrom(playerNames);
        Participant dealer = blackJack.getParticipants().getDealer();
        List<Participant> players = blackJack.getParticipants().getPlayers();
        blackJack.handOutStartingCards();
        assertThat(dealer.getCards().size()).isEqualTo(2);
        assertThat(players.get(0).getCards().size()).isEqualTo(2);
        assertThat(players.get(1).getCards().size()).isEqualTo(2);
    }

}
