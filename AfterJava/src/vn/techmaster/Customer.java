package vn.techmaster;

public class Customer {
	private CustomerType type;

	public Customer(CustomerType type) {
		super();
		this.type = type;
	}

	public Customer() {
		super();
	}

	/**
	 * @return the type
	 */
	public CustomerType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(CustomerType type) {
		this.type = type;
	}

	public MonthlyStatement generate(MonthlyUsage monthlyUsage) throws Exception {
		MonthlyStatement monthlyStatement = new MonthlyStatement();
		switch (type) {
		case PAY_AS_YOU_GO:
			monthlyStatement.setCallCost(0.12f * monthlyUsage.getCallMinutes());
			monthlyStatement.setSmsCost(0.12f * monthlyUsage.getSmsCount());
			monthlyStatement.setTotalCost(monthlyStatement.getCallCost() + monthlyStatement.getSmsCost());
			break;

		case UNLIMITED:
			monthlyStatement.setTotalCost(54.90f);
			break;

		default:
			throw new Exception("The current customer type is not supported");
		}
		return monthlyStatement;
	}
}
