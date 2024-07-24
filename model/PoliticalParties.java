package model;

public class PoliticalParties {
	private long id;
	private String name;
	private String symbol;

	public PoliticalParties(String name, String symbol, long id) {
		this.name = name;
		this.symbol = symbol;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setsymbol(String symbol) {
		this.symbol = symbol;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
