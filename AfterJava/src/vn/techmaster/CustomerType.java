package vn.techmaster;

public enum CustomerType {
	PAY_AS_YOU_GO(1), UNLIMITED(0);

	private int typeCode;

	/**
	 * @return the typeCode
	 */
	public int getTypeCode() {
		return typeCode;
	}

	CustomerType(int typeCode) {
		this.typeCode = typeCode;
	}
}
