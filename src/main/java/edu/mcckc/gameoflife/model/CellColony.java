package edu.mcckc.gameoflife.model;

import java.util.HashMap;
import java.util.Random;

public class CellColony
{
    Random random;
    private Cell[][] cells;
    private int gridSize;
    private HashMap<Cell.CellType, Integer> neighborCount;
    private final int INITIAL_LIFE_PERCENTAGE = 25;

    public CellColony() throws LifeException
    {
        this(25);
    }

    public CellColony(int gridSize)
    {
        this.gridSize = gridSize;
        random = new Random(System.currentTimeMillis());

        neighborCount = new HashMap<>();
        neighborCount.put(Cell.CellType.LIFE, 0);
        neighborCount.put(Cell.CellType.DOMINANT, 0);
    }

    public void initializeGrid() throws LifeException
    {
        cells = new Cell[gridSize][gridSize];

        for (int row = 0; row < gridSize; row++)
        {
            for (int col = 0; col < gridSize; col++)
            {
                int randomNumber = random.nextInt(100);

                if (randomNumber < INITIAL_LIFE_PERCENTAGE)
                {
                    cells[row][col] = new LifeCell(true, null);
                }
                else
                {
                    cells[row][col] = new LifeCell(false, null);
                }
            }
        }
    }

    public Cell getCell(int row, int col)
    {
        return cells[row][col];
    }

    public void calcNextGeneration()
    {
        for (int row = 0; row < cells.length; row++)
        {
            for (int col = 0; col < cells[row].length; col++)
            {
                updateNeighborCount(row, col);
            }
        }

        regenerateColony();
    }

    // Count adjacent, live cells
    private void updateNeighborCount(int row, int col)
    {
        for (int rowDelta = row - 1; rowDelta < row + 2; rowDelta++)
        {
            for (int colDelta = col - 1; colDelta < col + 2; colDelta++)
            {
                // Boundary check and don't count self
                if ((rowDelta < cells.length && colDelta < cells[row].length)
                        && (rowDelta >= 0 && colDelta >= 0)
                        && (rowDelta != row || colDelta != col)
                        && cells[rowDelta][colDelta].getIsAlive())
                {
                    Cell.CellType cellType = cells[rowDelta][colDelta].getCellType();
                    neighborCount.put(cellType, neighborCount.get(cellType) + 1);
                }
            }
        }

        HashMap<Cell.CellType, Integer> mapCopy = new HashMap<>(neighborCount);
        cells[row][col].setNeighborCount(mapCopy);
        neighborCount.replaceAll((t, v) -> 0);
    }

    // Update Cell isAlive property for all cells
    private void regenerateColony()
    {
        for (int row = 0; row < cells.length; row++)
        {
            for (int col = 0; col < cells[row].length; col++)
            {
                // LifeCell consumed by Dominant cell
                if (cells[row][col].getCellType() == Cell.CellType.LIFE && cells[row][col].getNeighborCount().get(Cell.CellType.DOMINANT) > 1)
                {
                    cells[row][col] = new DominantCell(true, cells[row][col].getNeighborCount());
                }

                // Dead Dominant cells becomes dead LifeCell for chance of revival
                if (cells[row][col].getCellType() == Cell.CellType.DOMINANT && !(cells[row][col].getIsAlive()))
                {
                    cells[row][col] = new LifeCell(false, cells[row][col].getNeighborCount());
                }

                cells[row][col].regenerate();
            }
        }
    }

    public void injectDominantCells(ControlCommand pattern, int row, int col)
    {
        transformCells(row, col);

        if (pattern == ControlCommand.STAR_PATTERN)
        {
            if (row - 1 >= 0)
            {
                transformCells(row - 1, col);
            }

            if (col - 1 >= 0)
            {
                transformCells(row, col - 1);
            }

            if (row + 1 < gridSize)
            {
                transformCells(row + 1, col);
            }

            if (col + 1 < gridSize)
            {
                transformCells(row, col + 1);
            }
        }
    }

    private void transformCells(int row, int col)
    {
        if (getCell(row, col).getCellType() != Cell.CellType.DOMINANT)
        {
            cells[row][col] = new DominantCell(true, cells[row][col].getNeighborCount());
        }
    }
}
