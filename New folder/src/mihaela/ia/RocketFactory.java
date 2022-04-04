package mihaela.ia;

public class RocketFactory {

	public Rocket getRocket (String rocketType) 
	{
		if(rocketType==null) {
			return null;
		}
		if(rocketType.equalsIgnoreCase("Nuclear")) {
			return new NuclearRocket();
		}else if(rocketType.equalsIgnoreCase("Hypersonic")) {
			return new HypersonicRocket();
		}
		return null;
	}
}
