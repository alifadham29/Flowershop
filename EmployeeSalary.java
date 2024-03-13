import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EmployeeSalary {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        String inputFile = "C:/Users/alifa/Downloads/employeeSalaries.txt";
        String outputFile = "C:/Users/alifa/Downloads/employeeData.txt";
        double maxAnnualSalary = Double.MIN_VALUE;
        String topPerformer = "";
        int minYearsOfService = Integer.MAX_VALUE;
        String leastServiceEmployee = "";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                if (st.countTokens() != 3) {
                    System.out.println("Incomplete Employee Data: " + line);
                    continue;
                }

                String name = st.nextToken().trim();
                double salary = Double.parseDouble(st.nextToken().trim());
                int yearsOfService = Integer.parseInt(st.nextToken().trim());
                employees.add(new Employee(name, salary, yearsOfService));

                double annualSalary = salary + (salary * 0.05 * yearsOfService);

                if (annualSalary > maxAnnualSalary) {
                    maxAnnualSalary = annualSalary;
                    topPerformer = name;
                }

                if (yearsOfService < minYearsOfService) {
                    minYearsOfService = yearsOfService;
                    leastServiceEmployee = name;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        try (PrintWriter employeeDataWriter = new PrintWriter(new FileWriter(outputFile))) {
            System.out.printf("\t\tList of Employee Salary%n");
            System.out.printf("%-24s%-15s%-15s%-15s%n", "Employee Name", "Base Salary", "Annual Salary", "Years of Service");
            System.out.println("\t*************************************************************");

            for (Employee employee : employees) {
                double annualSalary = employee.salary + (employee.salary * 0.05 * employee.yearsOfService);

                System.out.printf("%-24s%-15.2f%-15.2f%-15d%n", employee.name, employee.salary, annualSalary, employee.yearsOfService);
                employeeDataWriter.printf("%-24s%-15.2f%-15.2f%-15d%n", employee.name, employee.salary, annualSalary, employee.yearsOfService);
            }

            System.out.println("Top Performing Employee: " + topPerformer + ", Annual Salary: " + maxAnnualSalary);
            System.out.println("Employee with Least Years of Service: " + leastServiceEmployee + ", Years of Service: " + minYearsOfService);
        } catch (IOException e) {
            System.out.println("Problem writing to file: " + e.getMessage());
        }
    }

    static class Employee {
        String name;
        double salary;
        int yearsOfService;

        public Employee(String name, double salary, int yearsOfService) {
            this.name = name;
            this.salary = salary;
            this.yearsOfService = yearsOfService;
        }
    }
}