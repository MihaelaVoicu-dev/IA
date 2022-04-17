package mihaela.ia;

public class Rocket {

	private String name;
	private RocketBody rocketBody;
	private Reactor reactor;
	private float massOfRocket;

	public String getName() {
		return name;
	}

	public Rocket(String name, RocketBody rocketBody, Reactor reactor) {
		super();
		this.name = name;
		this.rocketBody = rocketBody;
		this.reactor = reactor;
	}

	Rocket(Builder builder) {
		this.name = builder.getName();
		this.reactor = builder.getReactor();
		this.rocketBody = builder.getRocketBody();
	}

}