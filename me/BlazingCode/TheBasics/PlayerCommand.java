package me.BlazingCode.TheBasics;

import java.util.Arrays;
import java.util.List;

public class PlayerCommand
{
	public static final String HELP = "help";
	public static final String TPA = "tpa";
	public static final String TPACCEPT = "tpaccept";

	private static List<String> commands = Arrays.asList(HELP, TPA, TPACCEPT);

	public static List<String> getCommands()
	{
		return commands;
	}
}
