package vn.techmaster;

public class MonthlyUsage {
	private Customer customer;
	private int callMinutes;
	private int smsCount;

	public MonthlyUsage(Customer customer, int callMinutes, int smsCount) {
		this.customer = customer;
		this.callMinutes = callMinutes;
		this.smsCount = smsCount;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the callMinutes
	 */
	public int getCallMinutes() {
		return callMinutes;
	}

	/**
	 * @return the smsCount
	 */
	public int getSmsCount() {
		return smsCount;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param callMinutes
	 *            the callMinutes to set
	 */
	public void setCallMinutes(int callMinutes) {
		this.callMinutes = callMinutes;
	}

	/**
	 * @param smsCount
	 *            the smsCount to set
	 */
	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

}
