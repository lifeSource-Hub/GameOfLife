package edu.mcckc.gameoflife.eventhandling;

import edu.mcckc.gameoflife.model.ControlCommand;

import java.util.EventObject;

public class ControlEvent extends EventObject
{
   private ControlCommand command;
   private int gridSize;
   private String cellDepiction;

   public ControlEvent(Object source)
   {
      super(source);
   }

   public ControlEvent(Object source, ControlCommand command, int gridSize, String cellDepiction)
   {
      super(source);
      this.command = command;
      this.gridSize = gridSize;
      this.cellDepiction = cellDepiction;
   }

   public ControlCommand getCommand()
   {
      return command;
   }

   public int getGridSize()
   {
      return gridSize;
   }

   public String getCellDepiction()
   {
      return cellDepiction;
   }

   @Override
   public Object getSource()
   {
      return super.getSource();
   }

   @Override
   public String toString()
   {
      return super.toString();
   }
}
