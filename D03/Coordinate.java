
public class Coordinate {
	
	private String id;
	private Integer positionX;
	private Integer positionY;
	private Integer sizeX;
	private Integer sizeY;
	
	public Coordinate(String init) {
		super();
		this.id = identifyId(init);
		this.positionX = identifyPositionX(init);
		this.positionY = identifyPositionY(init);
		this.sizeX = identifySizeX(init);
		this.sizeY = identifySizeY(init);
	}
	
	private String identifyId(String raw) {
		return raw.split("@")[0].strip();
	}
	private Integer identifyPositionX(String raw) {
		return Integer.valueOf(raw.split("@")[1].split(":")[0].split(",")[0].strip());
	}
	private Integer identifyPositionY(String raw) {
		return Integer.valueOf(raw.split("@")[1].split(":")[0].split(",")[1].strip());
	}
	private Integer identifySizeX(String raw) {
		return Integer.valueOf(raw.split(":")[1].split("x")[0].strip());
	}
	private Integer identifySizeY(String raw) {
		return Integer.valueOf(raw.split(":")[1].split("x")[1].strip());
	}

	public String getId() {
		return id;
	}

	public Integer getPositionX() {
		return positionX;
	}

	public Integer getPositionY() {
		return positionY;
	}

	public Integer getSizeX() {
		return sizeX;
	}

	public Integer getSizeY() {
		return sizeY;
	}
}
