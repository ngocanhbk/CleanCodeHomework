package vn.techmaster;

public class Main {

	public static void main(String[] args) throws Exception {
		Customer customer = new Customer(CustomerType.PAY_AS_YOU_GO);
//		Customer customer = new Customer(CustomerType.UNLIMITED);
		MonthlyUsage monthlyUsage = new MonthlyUsage(customer, 100, 500);

		MonthlyStatement monthlyStatement = customer.generate(monthlyUsage);
		System.out.println(monthlyStatement.getTotalCost());
	}
}
