package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.eventhandling.*;
import edu.mcckc.gameoflife.model.ControlCommand;
import edu.mcckc.gameoflife.model.LifeException;
import org.pmw.tinylog.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlPanel extends JPanel implements ActionListener
{
   private UserInputPanel inputPnl;
   private JLabel invalidInputMsg;
   private JLabel threadStatus;

   private final int MAX_SIZE = 25;

   private Controllable listener;

   public ControlPanel()
   {
      setLayout(new GridLayout(0,3));

      inputPnl = new UserInputPanel("Represent Cells With:", "Set Grid Size:", 6);
      invalidInputMsg = new JLabel("");
      threadStatus = new JLabel("");

      JButton initBtn = new JButton("Init Colony");
      initBtn.addActionListener(this);
      initBtn.setActionCommand(ControlCommand.INIT.toString());

      JButton startBtn = new JButton("Start SIM");
      startBtn.addActionListener(this);
      startBtn.setActionCommand(ControlCommand.START.toString());
      startBtn.setForeground(new Color(22, 168, 29, 255));

      JButton stopBtn = new JButton("Stop SIM");
      stopBtn.addActionListener(this);
      stopBtn.setActionCommand(ControlCommand.STOP.toString());
      stopBtn.setForeground(new Color(255, 0, 0, 200));

      JLabel patternLbl = new JLabel("Dominant Cell Injection Pattern");

      JLabel singlePatternLbl = new JLabel("Single:");
      JRadioButton singlePattern = new JRadioButton("", true);
      singlePattern.addActionListener(this);
      singlePattern.setActionCommand(ControlCommand.SINGLE_PATTERN.toString());

      JLabel starPatternLbl = new JLabel("Star:");
      JRadioButton starPattern = new JRadioButton();
      starPattern.addActionListener(this);
      starPattern.setActionCommand(ControlCommand.STAR_PATTERN.toString());

      ButtonGroup radioGroup = new ButtonGroup();
      radioGroup.add(singlePattern);
      radioGroup.add(starPattern);

      JPanel pnl1 = new JPanel();
      JPanel pnlContainer = new JPanel(new GridLayout(0, 1));
      JPanel pnl2Upper = new JPanel();
      JPanel pnl2Lower = new JPanel();
      JPanel pnl3 = new JPanel();
      JPanel pnl4 = new JPanel();
      JPanel pnl6 = new JPanel();

      pnl1.add(inputPnl);

      pnl2Upper.add(patternLbl);
      pnl2Lower.add(singlePatternLbl);
      pnl2Lower.add(singlePattern);
      pnl2Lower.add(starPatternLbl);
      pnl2Lower.add(starPattern);

      pnlContainer.add(pnl2Upper);
      pnlContainer.add(pnl2Lower);

      pnl3.add(initBtn);
      pnl3.add(startBtn);
      pnl3.add(stopBtn);

      pnl4.add(invalidInputMsg);

      pnl6.add(threadStatus);

      add(pnl1);
      add(pnlContainer);
      add(pnl3);
      add(pnl4);
      add(new JPanel());
      add(pnl6);
   }

   public void setLblThreadStatus(String lblThreadStatus, Color lblColor)
   {
      this.threadStatus.setText(lblThreadStatus);
      this.threadStatus.setForeground(lblColor);
   }

   public void setMessage(String message)
   {
      invalidInputMsg.setText(message);
   }

   public void setListener(Controllable listener)
   {
      this.listener = listener;
   }

   @Override
   public void actionPerformed(ActionEvent e)
   {
      // Logger.debug("Inside actionPerformed");

      setMessage("");
      int inputNum = 0;
      String inputChar = "";

      // Ensure user input does not exceed MAX and send event to listener in FrameApp
      try
      {
         inputNum = inputPnl.getGridSizeInt();
         inputChar = inputPnl.getCellChar();

         if ((inputNum <= MAX_SIZE) && (inputNum > 0))
         {
            listener.controlActionPerformed(new ControlEvent(this, ControlCommand.valueOf(e.getActionCommand()), inputNum, inputChar));
         }
         else if (inputNum > MAX_SIZE)
         {
            throw new LifeException(MAX_SIZE);
         }
         else
         {
            throw new LifeException("Grid size must be greater than 0");
         }
      } catch (LifeException liex)
      {
         setMessage(liex.getMessage());
         Logger.error(liex.toString());
      }
   }
}