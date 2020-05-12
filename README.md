# Simulador-Drone
<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/sarev17/Simulador-Drone">

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/sarev17/Simulador-Drone">
  
  <a href="https://github.com/willianpraciano/Pong-C/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/sarev17/Simulador-Drone">
  </a>

  <img alt="License" src="https://img.shields.io/badge/license-MIT-brightgreen">
</p>

<p align="center">
  <img src="https://github.com/sarev17/Simulador-Drone/blob/master/Drone/src/Video_1589235675.gif">
</p>

## Tecnologias
- JavaFX
- Prolog

### Funcionamento
Todos os blocos são posicionáveis, o laranja representa o destino do drone. O drone possui seis sensores e cada vez que um deles toca uma elemento do cenário uma função colisao() é ativada enviando um array de seis posições para um função criada em prolog, onde já está definina uma coordenada de chegada para cada situação dos sensores. O bit 0 representa sem colisão e o bit 1 com colisão. Segue parte da tabela da logica feita no prolog:

|pixels(x,y)|  Sensores |
|-----------|-----------|
|   10,10   |0,0,0,0,1,0|
|   4,10    |0,0,0,1,0,0|
|   4,10    |0,0,0,1,1,0|
|   10,10   |0,0,1,0,0,0|
|   10,10   |0,0,1,0,1,0|

se a entrada for (0,0,0,1,0), ou seja, apenas o sensor 4 estiver colidindo o drone se movimentará 10px em x e y. A função é dada por **coordenada(Z,X):-sensor(X,Z).** e uma possivel entrada seria **sensor([10,4],[1,0,1,1,1,1]).**



#### todas as informações estão contidas no pdf do projeto
