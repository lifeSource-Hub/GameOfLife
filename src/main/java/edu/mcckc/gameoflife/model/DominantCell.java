package edu.mcckc.gameoflife.model;

import java.awt.*;
import java.util.HashMap;

public class DominantCell extends Cell
{
    public DominantCell()
    {
        this(false, null);
    }

    public DominantCell(boolean isAlive, HashMap<CellType, Integer> neighborCount)
    {
        setIsAlive(isAlive);
        setNeighborCount(neighborCount);
        setCellType(CellType.DOMINANT);
        setCellColor(new Color(255, 0, 0));
    }

    // Dominant cells will not actually regenerate. This method only checks whether living cells stay alive.
    @Override
    public void regenerate()
    {
        if (neighborCount.get(CellType.LIFE) < 1)
        {
            setIsAlive(false);
        }
    }
}
