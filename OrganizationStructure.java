import java.util.*;

public class OrganizationStructure {
    public Employee ceo;
    public OrganizationStructure(Employee ceo) {
        this.ceo = ceo;
    }

    public static class Employee {
        public String name;
        public String title;
        public List<Employee> directReports;

        public Employee(String name, String title) {
            this.name = name;
            this.title = title;
            this.directReports = new ArrayList<Employee>();
        }
        public Employee(String name, String title, List<Employee> directReports) {
            this.name = name;
            this.title = title;
            this.directReports = directReports;
        }

    }

    public static void main(String[] args) {
        OrganizationStructure.Employee theCEO = new OrganizationStructure.Employee("A", "CEO");
        OrganizationStructure.Employee cfo = new OrganizationStructure.Employee("B", "CFO");
        OrganizationStructure.Employee cto = new OrganizationStructure.Employee("C", "CTO");
        theCEO.directReports.add(cfo);
        theCEO.directReports.add(cto);
        OrganizationStructure.Employee director = new OrganizationStructure.Employee("I", "Director");
        cfo.directReports.add(director);
        OrganizationStructure.Employee salesRep = new OrganizationStructure.Employee("J", "Sales Representative");
        director.directReports.add(salesRep);
        OrganizationStructure.Employee salesIntern = new OrganizationStructure.Employee("K", "Sales Intern");
        salesRep.directReports.add(salesIntern);
        OrganizationStructure.Employee managerOne = new OrganizationStructure.Employee("D", "Manager");
        OrganizationStructure.Employee managerTwo = new OrganizationStructure.Employee("E", "Manager");
        cto.directReports.add(managerOne);
        cto.directReports.add(managerTwo);

        OrganizationStructure.Employee engineerOne = new OrganizationStructure.Employee("F", "Engineer");
        OrganizationStructure.Employee engineerTwo = new OrganizationStructure.Employee("G", "Engineer");
        OrganizationStructure.Employee engineerThree = new OrganizationStructure.Employee("H", "Engineer");

        managerOne.directReports.add(engineerOne);
        managerOne.directReports.add(engineerTwo);
        managerOne.directReports.add(engineerThree);

        OrganizationStructure company = new OrganizationStructure(theCEO);
        printLevelByLevel(company);
        int maxLevel = printNumLevels(company);
        System.out.println("Max Level: " + maxLevel);
    }
    public static void printLevelByLevel(OrganizationStructure company) {
        Queue<OrganizationStructure.Employee> que = new LinkedList<>();
        que.add(company.ceo);
        while (!que.isEmpty()) {
            OrganizationStructure.Employee ceo = que.remove();
            System.out.println("Name: " + ceo.name + ", " + "Title: " + ceo.title);
            for(int i = 0; i < ceo.directReports.size(); i++) {
                que.add(ceo.directReports.get(i));
            }
        }
    }
    public static int printNumLevels(OrganizationStructure company) {
        return printNumLevelsHelper(company.ceo , 1);
    }
    public static int printNumLevelsHelper(OrganizationStructure.Employee company, int level) {
        if (company.directReports.isEmpty()) {
            return level;
        }
        int maxLevel = -1;
        for (OrganizationStructure.Employee i : company.directReports) {
            int currentLevel = printNumLevelsHelper(i, level + 1);
            if (currentLevel > maxLevel) {
                maxLevel = currentLevel;
            }
        }
        return maxLevel;
    }

}
