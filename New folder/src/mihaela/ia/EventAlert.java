package mihaela.ia;

import java.util.Random;

public class EventAlert {

	public void AlertEveryone(Localities observerList) {
		for (Locality l : observerList.getLocalities()) {
			Random rand = new Random();
			// double randomValue = rand.nextDouble();
			// int value =(int) (randomValue*1000);
            //System.out.println("double"+value + " rand int "+ randomValue);
			// nr par
            //boolean isEvenNumber=(value%2==0);
			l.setState(rand.nextInt(2));
			// System.out.println("Subject: My state has just changed to: " + l.state);
		}
		observerList.notifyAllObservers();
	}

}
