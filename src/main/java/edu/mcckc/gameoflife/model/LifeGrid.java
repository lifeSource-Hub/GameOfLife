package edu.mcckc.gameoflife.model;

import org.pmw.tinylog.Logger;

import java.util.Random;

public class LifeGrid
{
   Random rand;
   private static final int MAX_SIZE = 25;
   private LifeCell gridArray[][];
   private int gridSize;

   public LifeGrid() throws LifeException
   {
      this(MAX_SIZE);
   }

   public LifeGrid(int gridSize)
   {
      this.gridSize = gridSize;

      rand = new Random(System.currentTimeMillis());
   }

   public void initializeGrid(String cellChar) throws LifeException
   {
      gridArray = new LifeCell[gridSize][gridSize];

      for (int row = 0; row < gridSize; row++)
      {
         for (int col = 0; col < gridSize; col++)
         {
            // Set 25% cells alive
            int randomNumber = rand.nextInt(100);
            if (randomNumber < 25)
            {
               gridArray[row][col] = new LifeCell(true, 0);
            }
            else
            {
               gridArray[row][col] = new LifeCell(false, 0);
            }
         }
      }
      gridArray[0][0].setCellChar(cellChar);
      Logger.debug("LifeCell array initialized successfully");
   }

   public LifeCell getCell(int row, int col)
   {
      return gridArray[row][col];
   }

   // Set neighbor count then "regenerate" each one
   public void calcNextGeneration()
   {
      for (int row = 0; row < gridArray.length; row++)
      {
         for (int col = 0; col < gridArray[row].length; col++)
         {
            int neighborCount = 0;
            // for each LifeCell, check if surrounding cells are alive
            for (int rowDelta = row - 1; rowDelta < row + 2; rowDelta++)
            {
               for (int colDelta = col - 1; colDelta < col + 2; colDelta++)
               {
                  // don't go out of bounds and don't count self
                  if ((rowDelta < gridArray.length && colDelta < gridArray[row].length)
                          && (rowDelta >= 0 && colDelta >= 0)
                          && (rowDelta != row || colDelta != col))
                  {
                     if (gridArray[rowDelta][colDelta].getIsAlive())
                     {
                        neighborCount++;
                     }
                  }
               }
            }
            gridArray[row][col].setNeighborCount(neighborCount);
         }
      }

      for (LifeCell[] rowGridArray : gridArray)
      {
         for (LifeCell colGridArray : rowGridArray)
         {
            colGridArray.regenerate();
         }
      }
   }
}
