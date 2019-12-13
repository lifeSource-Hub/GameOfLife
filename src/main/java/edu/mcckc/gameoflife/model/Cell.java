package edu.mcckc.gameoflife.model;

import java.awt.*;
import java.util.HashMap;

public abstract class Cell
{
    protected boolean isAlive;
    protected HashMap<CellType, Integer> neighborCount;
    protected CellType cellType;
    protected Color cellColor;

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public HashMap<CellType, Integer> getNeighborCount()
    {
        return neighborCount;
    }

    public Color getCellColor()
    {
        return cellColor;
    }

    public CellType getCellType()
    {
        return cellType;
    }

    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }

    public void setNeighborCount(HashMap<CellType, Integer> neighborCount)
    {
        this.neighborCount = neighborCount;
    }

    protected void setCellType(CellType cellType)
    {
        this.cellType = cellType;
    }

    protected void setCellColor(Color cellColor)
    {
        this.cellColor = cellColor;
    }

    /**
     *  Update cell life status, determined by cell's neighbor count
     */
    public abstract void regenerate();

    @Override
    public String toString()
    {
        return cellType.name();
    }

    public enum CellType
    {
        LIFE,
        DOMINANT;
    }
}
