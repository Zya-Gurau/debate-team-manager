package match;

/**
 * 
 * This class implements a moot the is used in matches between teams of debators
 *
 */
public class Moot {
	/**
	 * the 'name' of the moot/the premise of the debate
	 */
	private String name;
	/**
	 * the style of the moot
	 */
	private String style;
	
	/**
	 * The constructor for the moot
	 * initialises the moots variables.
	 * 
	 * @param name the name of the moot
	 * @param style the style of the moot
	 */
	public Moot(String name, String style) {
		this.setName(name);
		this.style = style;
	}
	
	/**
	 * gets the name of the moot
	 * 
	 * @return the name of the moot
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of the moot
	 * 
	 * @param name the name of the moot
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * gets the style of the moot
	 * 
	 * @return style the style of the moot
	 */
	public String getStyle() {
		return style;
	}
	
	/**
	 * sets the style of the moot
	 * 
	 * @param style the style of the moot
	 */
	public void setStyle(String style) {
		this.style = style;
	}
}
