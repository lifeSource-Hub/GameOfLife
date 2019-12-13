package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.eventhandling.*;
import edu.mcckc.gameoflife.model.LifeException;
import org.pmw.tinylog.Logger;

import javax.swing.*;
import java.awt.*;

public class FrameApp extends JFrame
{
   private ControlPanel pnlControl;
   private ColonyPanel pnlGrid;

   public FrameApp() throws LifeException
   {
      this("The Game of Life: A Cell Colony Simulation", 950, 800);
   }

   public FrameApp(String title, int width, int height) throws LifeException
   {
      pnlControl = new ControlPanel();
      pnlGrid = new ColonyPanel();

      pnlControl.setListener(new Controllable()
      {
         @Override
         public void controlActionPerformed(ControlEvent evt)
         {
            // Logger.debug("Inside controlActionPerformed, action command: " + btnCmd);

            switch (evt.getCommand())
            {
               case INIT:
                  try
                  {
                     pnlGrid.initializePnlGrid(evt);
                  }
                  catch (LifeException e)
                  {
                     Logger.error(e.toString());
                  }
                  break;
               case START:
                  pnlGrid.start();
                  pnlControl.setLblThreadStatus("Running", new Color(22, 168, 29, 255));
                  break;
               case STOP:
                  pnlGrid.setContinueSim(false);
                  pnlControl.setLblThreadStatus("Stopped", new Color(255, 0, 0, 200));
                  break;
               case SINGLE_PATTERN:
               case STAR_PATTERN:
                  pnlGrid.setPattern(evt.getCommand());
                  break;
            }
         }
      });

      add(pnlControl, BorderLayout.NORTH);
      add(pnlGrid, BorderLayout.CENTER);
      // Logger.debug("Inside FrameApp, panels added to frame");

      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      setTitle(title);
      setSize(width, height);
      setLocationRelativeTo(null);
      setVisible(true);
   }
}