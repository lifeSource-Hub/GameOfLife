package edu.mcckc.gameoflife.gui;

import edu.mcckc.gameoflife.model.*;
import edu.mcckc.gameoflife.eventhandling.ControlEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColonyPanel extends JPanel implements Runnable
{
    private static final int MAX_SIZE = 25;
    private JLabel[][] cellLabels;

    private CellColony cellColony;
    private int gridSize;
    private boolean continueSim;
    private Thread lifeCycleThread;
    private ControlCommand pattern;
    private String lifeCellDepiction = "O";
    private String dominantCellDepiction = "X";

    public ColonyPanel()
    {
        setLayout(new GridLayout(MAX_SIZE, MAX_SIZE));
        setPattern(ControlCommand.SINGLE_PATTERN);

        cellLabels = new JLabel[MAX_SIZE][MAX_SIZE];

        for (int row = 0; row < MAX_SIZE; row++)
        {
            for (int col = 0; col < MAX_SIZE; col++)
            {
                cellLabels[row][col] = new JLabel("");
                addClickListener(cellLabels[row][col], row, col);

                add(cellLabels[row][col]);
            }
        }
    }

    public void initializePnlGrid(ControlEvent evt) throws LifeException
    {
        gridSize = evt.getGridSize();
        // Logger.debug("INIT button clicked, user input: " + gridSize);

        if (gridSize > MAX_SIZE)
        {
            throw new LifeException();
        }
        else
        {
            if (!evt.getCellDepiction().equals(""))
            {
                lifeCellDepiction = evt.getCellDepiction();
            }

            cellColony = new CellColony(gridSize);
            cellColony.initializeGrid();
        }

        wipeCellGrid();
        displayCellGrid();
    }

    public void setPattern(ControlCommand pattern)
    {
        this.pattern = pattern;
    }

    private void displayCellGrid()
    {
        for (int row = 0; row < gridSize; row++)
        {
            for (int col = 0; col < gridSize; col++)
            {
                Cell cell = cellColony.getCell(row, col);
                String depiction = "";

                if (cell.getIsAlive())
                {
                    if (cell.getCellType() == Cell.CellType.LIFE)
                    {
                        depiction = lifeCellDepiction;
                    }
                    else if (cell.getCellType() == Cell.CellType.DOMINANT)
                    {
                        depiction = dominantCellDepiction;
                    }
                }

                cellLabels[row][col].setText(depiction);

                cellLabels[row][col].setForeground(cell.getCellColor());
            }
        }
    }

    private void wipeCellGrid()
    {
        for (int row = 0; row < MAX_SIZE; row++)
        {
            for (int col = 0; col < MAX_SIZE; col++)
            {
                cellLabels[row][col].setText("");
            }
        }
    }

    private void displayNextGeneration()
    {
        cellColony.calcNextGeneration();
        displayCellGrid();
    }

    public boolean getContinueSim()
    {
        return continueSim;
    }

    public void setContinueSim(boolean continueSim)
    {
        this.continueSim = continueSim;
    }

    @Override
    public void run()
    {
        while (continueSim)
        {
            displayNextGeneration();

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void start()
    {
        if (!continueSim)
        {
            setContinueSim(true);
            lifeCycleThread = new Thread(this);
            lifeCycleThread.start();
        }
    }

    public void addClickListener(JLabel label, int row, int col)
    {
        label.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                super.mouseClicked(e);

                if (cellColony != null && row < gridSize && col < gridSize)
                {
                    cellColony.injectDominantCells(pattern, row, col);
                    displayCellGrid();
                }
            }
        });
    }
}
