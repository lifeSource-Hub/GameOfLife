package edu.mcckc.gameoflife.model;

public class LifeException extends Exception
{
   public LifeException()
   {
      super("Please enter valid data");
   }

   public LifeException(String errorMsg)
   {
      super(errorMsg);
   }

   public LifeException(int maxsize)
   {
      super("Grid size cannot exceed " + maxsize);
   }

   @Override
   public String toString()
   {
      return "Please enter valid data";
   }
}
