package statemachine;

public class StatefulEntity<T> {
	private State state;
	private final T entity;
	private final Response influenceResponse;
	
	public StatefulEntity(T entity, State state, Response influenceResponse) {
		this.state = state;
		this.entity = entity;
		this.influenceResponse = influenceResponse;
	}
	
	public void applyInfluence(Influence influence) {
		this.setState(influenceResponse.respond(influence));
	}

	public State getState() {
		return state;
	}
	
	private void setState(State state) {
		this.state = state;
	}

	public T getEntity() {
		return entity;
	}

}
