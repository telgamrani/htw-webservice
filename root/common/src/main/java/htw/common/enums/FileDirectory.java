package htw.common.enums;

public enum FileDirectory {
	LOOKS("looks"), ARTICLES("articles"), IMAGES("images");
	
	private final String value;

	FileDirectory(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}
