package htw.robot.scraping.model.json;

import htw.common.enums.ElementTarget;
import htw.common.enums.NumberOfElements;
import htw.common.enums.SelectorType;
import htw.robot.scraping.model.RobotScrapingSelector;

public class RobotScrapingSelectorJson {
	
	private String selector;
	
	private SelectorType type;
	
	private int rank;
	
	private ElementTarget elementTarget;
	
	private NumberOfElements numberOfElements;

	public RobotScrapingSelectorJson() {}

	public RobotScrapingSelectorJson(String selector, SelectorType type, int rank, ElementTarget elementTarget,
			NumberOfElements numberOfElements) {
		this.selector = selector;
		this.type = type;
		this.rank = rank;
		this.elementTarget = elementTarget;
		this.numberOfElements = numberOfElements;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	public SelectorType getType() {
		return type;
	}

	public void setType(SelectorType type) {
		this.type = type;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public ElementTarget getElementTarget() {
		return elementTarget;
	}

	public void setElementTarget(ElementTarget elementTarget) {
		this.elementTarget = elementTarget;
	}

	public NumberOfElements getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(NumberOfElements numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((elementTarget == null) ? 0 : elementTarget.hashCode());
		result = prime * result + ((numberOfElements == null) ? 0 : numberOfElements.hashCode());
		result = prime * result + rank;
		result = prime * result + ((selector == null) ? 0 : selector.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RobotScrapingSelectorJson other = (RobotScrapingSelectorJson) obj;
		if (elementTarget != other.elementTarget)
			return false;
		if (numberOfElements != other.numberOfElements)
			return false;
		if (rank != other.rank)
			return false;
		if (selector == null) {
			if (other.selector != null)
				return false;
		} else if (!selector.equals(other.selector))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RobotScrapingSelectorJson [selector=" + selector + ", type=" + type + ", rank=" + rank
				+ ", elementTarget=" + elementTarget + ", numberOfElements=" + numberOfElements + "]";
	}
	
	

}
