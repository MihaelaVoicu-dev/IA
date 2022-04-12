# IA
La tema 5 am folosit patternul Factory:
Am creat interfata Rocket, ce reprezinta racheta cu functia explosion(). 
Tinand cont ca Rocket este interfata va obliga clasele care o implementeaza(HypersonicRocket si NuclearRocket) sa faca override la functia explosion => Hypersonic= hypersonic explosion 
Nuclear=nuclear explosion.
In momentul acesta am creat clasa  RocketFactory (clasa care implementeaza pattern-ul Factory) si functia getRocket(string type) care  imi returneaza tipul obiectului in functie de string,astfel ca daca
stringul este Nuclear=> NuclearRocket object  si daca este Hypersonic => HypersonicRocket. 
In main am folosit un obiect de tip RocketFactory caruia i-am apelat metoda getRocket(string) si am observat ca daca apelez functia suprascrisa explosion imi realizeaza metoda din intermediul
clasei care coincide stringului dat.
Pattern Observer:
Am considerat doua interfete: 
-Observer cu functia update.
-Subject  cu functiile register, unregister, notifyAllObserver.
Am considerat clasa Localities ca implementeaza clasa Subject supraincarcand metodele de mai sus.
Clasa Locality implementeaza clasa Observer,supraincarcand doar update.
Am implementat ideea ca daca o Localitate lanseaza racheta le va anunta pe celelalte localitati ca racheta a pornit, neprecizand catre care se va duce. 
Din acest motiv m-am gandit sa creez o variabila state(pe care am generat-o random)=> care reprezinta starea lansarii . 
De aceasta m-am folosit in metoda update pe care am apelat-o in metoda NotifyAllObserver.
