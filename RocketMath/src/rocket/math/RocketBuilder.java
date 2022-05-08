package rocket.math;

public class RocketBuilder {

	private String name;
	private RocketBody rocketBody;
	private Reactor reactor;

	public RocketBuilder(String name, RocketBody rocketBody, Reactor reactor) {
		super();
		this.name = name;
		this.rocketBody = rocketBody;
		this.reactor = reactor;
	}

	public RocketBuilder() {
	}

	public Reactor getReactor() {
		return reactor;
	}

	public String getName() {
		return name;
	}

	public RocketBody getRocketBody() {
		return rocketBody;
	}

	public Rocket build() {
		return new Rocket(this);
	};

}