package game.sudoku;

import java.util.Scanner;

public class ConsoleGameDriver implements IConsoleOutput {

	private IConsoleGame program;
	private String level = null;

	private void init(IConsoleGame program, String level) {
		this.program = program;
		this.level = level;
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		do {
			if (level == null) {
				if (scanner.hasNextLine()) {
					level = scanner.nextLine();
				}
				message("Enter level: ");
				level = scanner.nextLine();
			}
			program.init(level);
			program.run(this);
			Integer result = null;
			while (result == null) {
				if (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					result = program.doLine(line);
				} else {
					result = 0;
				}
			}
			message("Game over" + (result != 0 ? "" : ", no result") + "!");
			if (result > 0) {
				level = null;
			}
			message("Another go (true/false)?");
		} while (scanner.nextBoolean());
		scanner.close();
	}

	@Override
	public void message(String message) {
		System.out.println(message);
	}

	@Override
	public void error(String message) {
		System.err.println(message);
	}

	public static void main(String[] args) throws Exception {
		ConsoleGameDriver driver = new ConsoleGameDriver();
		IConsoleGame program = (IConsoleGame) Class.forName(args[0]).newInstance();
		driver.init(program, args.length > 1 ? args[1] : null);
		driver.run();
	}
}