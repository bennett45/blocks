package pt314.blocks.game;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PuzzleLoader {
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static GameBoard ImportBoard(int level) throws Exception
	{
		String puzzleName = GetPuzzleName(level);		
		List<String> puzzle = readPuzzleFile(puzzleName);		
		return SetUpBoard(puzzle);
	}

	private static GameBoard SetUpBoard(List<String> puzzle) throws Exception 
	{
		int[] dimensions = GetDimensions(puzzle.get(0));
		GameBoard board = new GameBoard(dimensions[0], dimensions[1]);
		boolean TBlockFound = false;
		for(int i = 0; i < dimensions[0]; ++i)
		{
			for(int j = 0; j < dimensions[1]; ++j)
			{
				char block = puzzle.get(i+1).charAt(j);
				if(block == 'V')
					board.placeBlockAt(new VerticalBlock(), i, j);
				if(block == 'H')
					board.placeBlockAt(new HorizontalBlock(), i, j);
				if(block == 'T')
				{
					if(TBlockFound)
						throw new Exception("More then one target block found in puzzle");
					TBlockFound = true;
					board.placeBlockAt(new TargetBlock(), i, j);
				}
			}
		}
		if(!TBlockFound)
			throw new Exception("No target block found in puzzle");
		return board;
	}

	private static int[] GetDimensions(String sizeLine) throws Exception 
	{
		int[] dimensions = new int[2];
		dimensions[0] = sizeLine.charAt(0)-48;
		dimensions[1] = sizeLine.charAt(2)-48;
		
		if(dimensions[0] < 1 || dimensions[1] < 1)
			throw new Exception("Invalid puzzle dimensions");
		return dimensions;
	}

	private static String GetPuzzleName(int level) throws Exception 
	{
		String name = "puzzle-";
		
		if(level < 10)
			return name += "00" + Integer.toString(level) + ".txt";
		if(level < 100)
			return name += "0" + Integer.toString(level) + ".txt";
		if(level < 1000)
				return name += Integer.toString(level) + ".txt";
		throw new Exception("Not a valid level");
	}
	
	private static List<String> readPuzzleFile(String aFileName) throws IOException {
	    Path path = Paths.get("res/puzzles/" + aFileName);
	    return Files.readAllLines(path, ENCODING);
	  }

}
