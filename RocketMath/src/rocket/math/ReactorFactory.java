package rocket.math;

public class ReactorFactory {

	public Reactor getReactor(String ReactorType) {
		if (ReactorType == null) {
			return null;
		}
		if (ReactorType.equalsIgnoreCase("Nuclear")) {
			return new NuclearReactor();
		} else if (ReactorType.equalsIgnoreCase("Hypersonic")) {
			return new ChemicalReactor();
		}
		return null;
	}
}
