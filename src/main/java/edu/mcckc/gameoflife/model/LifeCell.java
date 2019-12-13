package edu.mcckc.gameoflife.model;

import java.awt.*;
import java.util.HashMap;

public class LifeCell extends Cell
{
    public LifeCell()
    {
        this(false, null);
    }

    public LifeCell(boolean isAlive, HashMap<CellType, Integer> neighborCount)
    {
        setIsAlive(isAlive);
        setNeighborCount(neighborCount);
        setCellType(CellType.LIFE);
        setCellColor(new Color(0, 0, 0));
    }

    @Override
    public void regenerate()
    {
        if (isAlive)
        {
            if (neighborCount.get(CellType.LIFE) < 2 || neighborCount.get(CellType.LIFE) > 3)
            {
                setIsAlive(false);
            }
        }

        if (!isAlive)
        {
            if (neighborCount.get(CellType.LIFE) == 3)
            {
                setIsAlive(true);
            }
        }
    }
}
