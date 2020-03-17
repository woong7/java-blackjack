package domain.result;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.user.Player;

class DealerResultTest {
	@DisplayName("Null값이 포함된 인자로 객체 생성시 예외 테스")
	@Test
	void createWithNullArgumentExceptionTest() {
		assertThatThrownBy(() -> new DealerResult(null))
			.isInstanceOf(NullPointerException.class);
	}

	@DisplayName("승패 집계가 제대로 이뤄지는지 테스트")
	@Test
	void calculateDealerResultTest() {
		DealerResult dealerResult = new DealerResult(Arrays.asList
			(new UserResult(new Player("둔덩"), MatchResult.WIN)));
		Map<MatchResult, Long> actual = dealerResult.reversePlayersResult();

		Map<MatchResult, Long> expected = new HashMap<>();
		expected.put(MatchResult.WIN, 0L);
		expected.put(MatchResult.LOSE, 1L);
		expected.put(MatchResult.DRAW, 0L);
		assertThat(actual).isEqualTo(expected);
	}
}