package edu.mcckc.gameoflife.model;

public enum ControlCommand
{
    INIT("INIT"),
    START("START"),
    STOP("STOP"),
    STAR_PATTERN("STAR_PATTERN"),
    SINGLE_PATTERN("SINGLE_PATTERN");

    private final String command;

    ControlCommand(String command)
    {
        this.command = command;
    }

    public String getCommand()
    {
        return command;
    }
}
