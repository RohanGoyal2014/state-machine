package statemachine;

public class Runner {

	public static void main(String[] args) {
		StatefulEntity<String> statefulEntity = new StatefulEntity<String>("ABC", State.READY, new Response() {
			
			@Override
			public MatchersBuilder matchers() {
				return new MatchersBuilder()
						.addMatcher(e -> e.getInput() instanceof Boolean, State.CONNECTED)
						.addMatcher(e -> e.getInput() instanceof String, State.CONNECTION_IN_PROGRESS);
			
			}
		});
		
		statefulEntity.applyInfluence(new Influence("Ou"));
		System.out.println(statefulEntity.getState());
	}
	
}
