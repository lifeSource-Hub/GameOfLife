package edu.mcckc.gameoflife.model;

import java.util.Objects;

public class LifeCell
{
   private boolean isAlive;
   private int neighborCount;
   private static String cellChar;

   public LifeCell()
   {
      isAlive = false;
      neighborCount = 0;
   }

   public LifeCell(boolean isAlive, int neighborCount)
   {
      setIsAlive(isAlive);
      setNeighborCount(neighborCount);
   }

   public boolean getIsAlive()
   {
      return isAlive;
   }

   public int getNeighborCount()
   {
      return neighborCount;
   }

   public void setIsAlive(boolean isAlive)
   {
      this.isAlive = isAlive;
   }

   public void setNeighborCount(int neighborCount)
   {
      this.neighborCount = neighborCount;
   }

   public void regenerate()
   {
      if (isAlive)
      {
         if (neighborCount < 2 || neighborCount > 3)
         {
            isAlive = false;
         }
      }

      if (!isAlive)
      {
         if (neighborCount == 3)
         {
            isAlive = true;
         }
      }
   }

   public void setCellChar(String cellChar)
   {
      // set default char
      if (Objects.equals(cellChar.trim(), ""))
      {
         cellChar = "O";
      }

      this.cellChar = cellChar;
   }

   @Override
   public String toString()
   {
      return isAlive ? cellChar : " ";
   }
}
