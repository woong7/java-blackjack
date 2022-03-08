import java.util.List;
import java.util.stream.Collectors;

public class Blackjack {
	private static final String ERROR_MESSAGE_PLAYER_NUMBER_EXCEED = "[ERROR] 참가자의 수는 8명을 초과할 수 없습니다.";
	private static final int MAX_PLAYER_NUMBER = 8;

	private final List<Player> players;

	private Blackjack(List<Player> players) {
		this.players = players;
	}

	public static Blackjack createFrom(List<String> playerNames){
		validatePlayerNumber(playerNames);
		List<Player> players = playerNames.stream()
				.map(Player::new)
				.collect(Collectors.toList());

		return new Blackjack(players);
	}

	private static void validatePlayerNumber(List<String> players) {
		if (players.size() > MAX_PLAYER_NUMBER) {
			throw new IllegalArgumentException(ERROR_MESSAGE_PLAYER_NUMBER_EXCEED);
		}
	}
}
