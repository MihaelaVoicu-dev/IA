package mihaela.ia;

public class Builder {

	 private String name;
	  private RocketBody rocketBody;
	  private Reactor reactor;
	  
	public Builder(String name, RocketBody rocketBody, Reactor reactor) {
		super();
		this.name = name;
		this.rocketBody = rocketBody;
		this.reactor = reactor;
	}
	 public Builder() {
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
	 public Builder setName(String name) {
		 this.name=name;
		 return this;
	 }
	 public Builder setRocketBody(RocketBody rocketBody) {
		 this.rocketBody=rocketBody;
		 return this;
	 }
	

	public Builder setReactor(Reactor reactor) {
		 this.reactor=reactor;
		 return this;
	 }
	
	 public Rocket build() {
		return new Rocket(this);
	};
	   
	
}
