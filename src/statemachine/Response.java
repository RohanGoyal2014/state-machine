package statemachine;

public abstract class Response {
	
	private MatchersBuilder matchersBuilder;
	
	public Response() {
		this.matchersBuilder = matchers();
	}
	
	public abstract MatchersBuilder matchers();
	
	public State respond(Influence influence) {
		return matchersBuilder.getMatchers()
				.entrySet()
				.stream()
				.filter(e -> e.getValue().test(influence) == true)
				.findFirst()
				.orElseThrow(() -> new NoMatchingResponseFoundException())
				.getKey();
	}

	@Override
	public String toString() {
		return "Response [matchersBuilder=" + matchersBuilder + "]";
	}
	
	

}
