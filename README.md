# Aufgabe5
Bauernopfer 

Das Spiel Bauernopfer wird zwischen weißen Bauern und einem schwarzen Turm auf einem Schachbrett gespielt. 
Zuerst stellen sich die weißen Bauern auf, wie sie wollen, jeder auf einem anderen Feld.
Danach stellt sich der schwarze Turm auf, wo er will, aber nicht, wo bereits ein Bauer steht.
Dann gibt es abwechselnd einen weißen und einen schwarzen Zug. 

In einem weißen Zug bewegt sich ein weißer Bauer einen Schritt (um ein Feld) nach oben, nach unten, nach links oder nach rechts.
In einem schwarzen Zug bewegt sich der schwarze Turm beliebig viele (evtl. null) Schritte nach oben, nach unten, nach links oder nach rechts,
wobei er allerdings weder ein Feld erreichen darf, das bereits von einem weißen Bauern belegt ist, noch durch ein solches Feld „hindurch-ziehen“ darf. 

Das Ziel der weißen Bauern ist, den schwarzen Turm zu fangen, nämlich dadurch, dass einer von ihnen das Feld erreicht, auf dem der Turm steht. 
Das Ziel des schwarzen Turms ist, nie gefangen zu werden.  

Aufgabe 

1. Acht weiße Bauern können den schwarzen Turm fangen, egal, wie sich dieser bewegt.
Beschreibe, wie sie dabei vorgehen sollen. Beschreibe auch, wie der Turm sich bewegen kann, um so lange wie möglich nicht gefangen zu werden.
Implementiere die Vorgehensweisen von Bauern und Turm und visualisiere die „Treibjagd“.  

2. Untersuche, ob sieben weiße Bauern den schwarzen Turm fangen können.
Falls ja, dann beschreibe, wie die Bauern vorgehen sollen.
Falls nein, dann beschreibe, wie sich der Turm verhalten soll, um nie gefangen zu werden.
Implementiere das Vorgehen der deiner Meinung nach erfolgreichen Spielpartei und ein möglichst gutes Vorgehen der anderen Spiel-partei.
Visualisiere das Spiel zwischen den beiden Kontrahenten.  

3. Betrachte jetzt eine wesentlich allgemeinere Situation:
Es gibt k weiße Bauern, von denen sich in jedem Zug l jeweils einen Schritt bewegen.
Für welche k und l können die weißen Bauern den schwarzen Turm wohl immer fangen? Was kannst du darüber herausfinden? 

Fange mit k = 7 an. 

4. Untersuche eine weitere Variante des Spiels,
zum Beispiel:
Was ändert sich, falls der schwarze Turm durch eine schwarze Dame ersetzt wird? Sie darf zusätzlich diagonal ziehen. 
