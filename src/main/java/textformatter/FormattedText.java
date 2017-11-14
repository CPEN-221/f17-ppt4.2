package textformatter;

public class FormattedText {

	// we use a recursive list definition for our formatted text
	private String firstLine;
	private FormattedText remainingText;
	private FormattedText lastLine;

	/**
	 * A simple default constructor
	 */
	public FormattedText() {
		firstLine = null;
		remainingText = null;
		lastLine = null;
	}

	/**
	 * 
	 * @param line
	 *            represents a line of text
	 * @return true after the new line of text has been added to the existing
	 */
	public boolean add(String line) {

		if (line == null)
			return false;
		if (line.equals(""))
			return false;

		if (firstLine == null) {
			firstLine = line;
			lastLine = this;
		} else {
			// add a line between linegraphs
			FormattedText newline = new FormattedText();
			newline.firstLine = line;
			lastLine.remainingText = newline;
			lastLine = newline;
		}
		return true;
	}

	/**
	 * @return the number of lines in the FormattedText
	 */
	public int numlines() {
		// TODO implement this
		return 0;
	}

	@Override
	public String toString() {
		FormattedText currline = this;
		StringBuilder text = new StringBuilder();
		while (currline != null) {
			text.append(currline.firstLine);
			text.append("\n");
			currline = currline.remainingText;
		}
		return text.toString();
	}

}
