package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.model.*;
import edu.mcckc.gameoflife.eventhandling.ControlEvent;
import org.pmw.tinylog.Logger;

import javax.swing.*;
import java.awt.*;

public class PanelGrid extends JPanel implements Runnable
{
   private static final int MAX_SIZE = 25;
   private JLabel[][] arrLabels;
   private LifeGrid grid;
   private int gridSize;
   private boolean continueSim;
   private Thread lifeCycleThread;

   public PanelGrid()
   {
      setLayout(new GridLayout(MAX_SIZE, MAX_SIZE));

      arrLabels = new JLabel[MAX_SIZE][MAX_SIZE];

      for (int row = 0; row < MAX_SIZE; row++)
      {
         for (int col = 0; col < MAX_SIZE; col++)
         {
            arrLabels[row][col] = new JLabel("");
            add(arrLabels[row][col]);
         }
      }

      Logger.debug("JLabel array instantiated successfully");
   }

   public void doCommand(ControlEvent evt) throws LifeException
   {
      gridSize = evt.getGridSize();
      Logger.debug("INIT button clicked, user input: " + gridSize);

      if (gridSize > MAX_SIZE)
      {
         throw new LifeException();
      }
      else
      {
         grid = new LifeGrid(gridSize);
         grid.initializeGrid(evt.getCellChar());
      }

      wipeLifeGrid();
      displayLifeGrid();
      Logger.debug("displayLifeGrid complete");
   }

   private void displayLifeGrid()
   {
      for (int row = 0; row < gridSize; row++)
      {
         for (int col = 0; col < gridSize; col++)
         {
            String cell = grid.getCell(row, col).toString();
            arrLabels[row][col].setText(cell);
         }
      }
   }

   private void wipeLifeGrid()
   {
      for (int row = 0; row < MAX_SIZE; row++)
      {
         for (int col = 0; col < MAX_SIZE; col++)
         {
            arrLabels[row][col].setText("");
         }
      }

      Logger.debug("grid wiped");
   }

   private void displayNextGeneration()
   {
      grid.calcNextGeneration();
      displayLifeGrid();
   }

   public void setContinueSim(boolean continueSim)
   {
      this.continueSim = continueSim;
   }

   public boolean getContinueSim()
   {
      return continueSim;
   }

   @Override
   public void run()
   {
      while (continueSim)
      {
         displayNextGeneration();

         try
         {
            Thread.sleep(800);
         } catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
      Logger.debug("THREAD stopped");
   }

   public void start()
   {
      if (!continueSim)
      {
         continueSim = true;
         lifeCycleThread = new Thread(this);
         lifeCycleThread.start();
      }
      Logger.debug("START button pressed, THREAD instantiated");
   }
}
