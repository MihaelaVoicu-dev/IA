package mihaela.ia;

interface Subject {
	public void register() ;
	public void unregister(Observer o) ;
	public void notifyAllObservers() ;

}
