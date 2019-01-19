package htw.common.enums;

public enum FileDirectoryName {
	LOOKS("looks"), ARTICLES("articles"), IMAGES("images");
	
	private final String value;

	FileDirectoryName(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return this.value;
    }
}
