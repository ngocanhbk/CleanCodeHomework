package vn.techmaster;

public class MonthlyStatement {
	private float callCost;
	private float smsCost;
	private float totalCost;

	public MonthlyStatement() {
		// Do nothing
	}

	/**
	 * @return the callCost
	 */
	public float getCallCost() {
		return callCost;
	}

	/**
	 * @return the smsCost
	 */
	public float getSmsCost() {
		return smsCost;
	}

	/**
	 * @return the totalCost
	 */
	public float getTotalCost() {
		return totalCost;
	}

	/**
	 * @param callCost
	 *            the callCost to set
	 */
	public void setCallCost(float callCost) {
		this.callCost = callCost;
	}

	/**
	 * @param smsCost
	 *            the smsCost to set
	 */
	public void setSmsCost(float smsCost) {
		this.smsCost = smsCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

}
