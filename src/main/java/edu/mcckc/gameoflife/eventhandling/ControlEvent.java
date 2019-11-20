package edu.mcckc.gameoflife.eventhandling;

import org.pmw.tinylog.Logger;

import java.util.EventObject;

public class ControlEvent extends EventObject
{
   public static final String INIT_COMMAND = "init";
   public static final String START_COMMAND = "start";
   public static final String STOP_COMMAND = "stop";

   private static String cellChar;
   private String command;
   private int gridSize;

   public ControlEvent(Object source)
   {
      super(source);
   }

   public ControlEvent(Object source, String command, int gridSize, String cellChar)
   {
      super(source);
      ControlEvent.cellChar = cellChar;
      this.command = command;
      this.gridSize = gridSize;
      Logger.debug("Inside ControlEvent");
   }

   public String getCellChar()
   {
      return cellChar;
   }

   public String getCommand()
   {
      return command;
   }

   public int getGridSize()
   {
      return gridSize;
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
