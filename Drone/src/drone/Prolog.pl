
sensor([10,10],[0,0,0,0,1,0]).
sensor([4,10],[0,0,0,1,0,0]).
sensor([4,10],[0,0,0,1,1,0]).
sensor([10,10],[0,0,1,0,0,0]).
sensor([10,10],[0,0,1,0,1,0]).
sensor([0,10],[0,0,1,1,0,0]).
sensor([0,10],[0,0,1,1,1,0]).
sensor([10,4],[0,1,0,0,0,0]).
sensor([10,4],[0,1,0,0,1,0]).
sensor([5,10],[0,1,0,1,0,0]).
sensor([5,10],[0,1,0,1,1,0]).
sensor([10,4],[0,1,1,0,0,0]).
sensor([10,4],[0,1,1,0,1,0]).
sensor([10,4],[0,1,1,1,0,0]).
sensor([10,4],[0,1,1,1,1,0]).
sensor([10,4],[1,0,0,0,0,0]).
sensor([10,4],[1,0,0,0,1,0]).
sensor([10,4],[1,0,0,1,0,0]).
sensor([10,4],[1,0,0,1,1,0]).
sensor([10,4],[1,0,1,0,0,0]).
sensor([10,4],[1,0,1,0,1,0]).
sensor([10,4],[1,0,1,1,0,0]).
sensor([10,4],[1,0,1,1,1,0]).
sensor([0,10],[1,1,0,0,0,0]).
sensor([10,0],[1,1,0,0,1,0]).
sensor([0,10],[1,1,0,1,0,0]).
sensor([0,10],[1,1,0,1,0,0]).
sensor([0,10],[1,1,1,0,0,0]).
sensor([10,4],[1,1,1,0,1,0]).
sensor([0,10],[1,1,1,1,0,0]).
sensor([10,0],[1,1,1,1,1,0]).

sensor([0,10],[0,0,0,0,0,1]).
sensor([4,10],[0,0,0,0,1,1]).
sensor([0,10],[0,0,0,1,0,1]).
sensor([4,10],[0,0,0,1,1,1]).
sensor([10,4],[0,0,1,0,0,1]).
sensor([10,4],[0,0,1,0,1,1]).
sensor([0,10],[0,0,1,1,0,1]).
sensor([0,10],[0,0,1,1,1,1]).
sensor([0,10],[0,1,0,0,0,1]).
sensor([10,4],[0,1,0,0,1,1]).
sensor([0,10],[0,1,0,1,0,1]).
sensor([5,10],[0,1,0,1,1,1]).
sensor([0,10],[0,1,1,0,0,1]).
sensor([10,4],[0,1,1,0,1,1]).
sensor([0,10],[0,1,1,1,0,1]).
sensor([10,4],[0,1,1,1,1,1]).
sensor([0,10],[1,0,0,0,0,1]).
sensor([10,4],[1,0,0,0,1,1]).
sensor([0,10],[1,0,0,1,0,1]).
sensor([10,4],[1,0,0,1,1,1]).
sensor([0,10],[1,0,1,0,0,1]).
sensor([10,4],[1,0,1,0,1,1]).
sensor([0,10],[1,0,1,1,0,1]).
sensor([10,4],[1,0,1,1,1,1]).
sensor([0,10],[1,1,0,0,0,1]).
sensor([10,0],[1,1,0,0,1,1]).
sensor([0,10],[1,1,0,1,0,1]).
sensor([0,10],[1,1,0,1,0,1]).
sensor([0,10],[1,1,1,0,0,1]).
sensor([10,4],[1,1,1,0,1,1]).
sensor([0,10],[1,1,1,1,0,1]).
sensor([10,0],[1,1,1,1,1,1]).


coordenada(Z,X):-sensor(X,Z).




