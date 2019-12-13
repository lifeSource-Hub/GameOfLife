# Game of Life #
The Game of Life represents the life cycle of a colony of cells. "Life" cells,
the default, are represented by the character "O" on a 25x25 grid. The size 
and representation can be adjusted by user. The colony is randomly initialized 
with %25 of the cells alive. Once the simulation is started the cycle of 
reproduction and death begins, each generation calculated and displayed in 1 
second intervals.

Clicking anywhere in the colony injects "Dominant" cells, represented by a 
red "X". These cells can only survive by feeding on the Life cells and can 
wipe out a colony, or be wiped out themselves if isolated from a food source.

## Requirements ##
* Java 11

## Installing ##
Download the latest release [here](https://github.com/lifeSource-Hub/GameOfLife/releases), then run the jar file.

This "fat jar" contains the necessary dependencies, all you need is Java 11.

## Built With ##
* Java
* Gradle

#### Screenshots: ####

![Screenshot of game](src/main/resources/gameScreenshot.png)
