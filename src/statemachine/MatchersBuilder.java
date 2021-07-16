package statemachine;

import java.util.HashMap;
import java.util.Map;

public class MatchersBuilder {

	private Map<State, Matcher> matchers;
	
	public MatchersBuilder() {
		this.matchers = new HashMap<>();
	}
	
	public MatchersBuilder addMatcher(Matcher matcher, State state) {
		matchers.put(state, matcher);
		return this;
	}
	
	Map<State, Matcher> getMatchers() {
		return matchers;
	}
}
