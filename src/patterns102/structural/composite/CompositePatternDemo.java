package patterns102.structural.composite;

public class CompositePatternDemo {
	public static void pprint(Employee emp) {
		// print all employees of the organisation
		System.out.println(emp);
		for (Employee headEmployee : emp.getSubordinates()) {
			System.out.println(headEmployee);
			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}
	}
	
	public static void pprint2(Employee emp) {
		System.out.println(emp.getDept());
		for (Employee headEmployee : emp.getSubordinates()) {
			System.out.println("  "+headEmployee.getDept());
			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println("    "+employee.getDept());
			}
		}
	}
	
	public static void pprint3(String ident, Employee emp) {
		System.out.format("\n%s %s: %s ==>%d", ident, emp.getDept(), emp.getName(), emp.getSalary());
		if(emp.getSubordinates() != null) {
			for(Employee em :emp.getSubordinates()) {
				pprint3(ident+"  ", em);
			}
		}
	}
	
	public static void main(String[] args) {
		Employee ceo = new Employee("John", "CEO", 30000);
		Employee headSales = new Employee("Robert", "Head Sales", 20000);
		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);
		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);
		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);
		
		ceo.add(headSales);
		ceo.add(headMarketing);
		
		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);
		
		headMarketing.add(clerk1);
		headMarketing.add(clerk2);
		pprint(ceo);
		pprint3("", ceo);
		
	}
}