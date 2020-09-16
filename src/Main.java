import java.util.List;

public class Main {

    public static void main(String[] args) {

        HeadOffice headOffice = HeadOffice.getInstance();

        Branch branch1 = headOffice.createBranch();
        //print branch data based on branchID
        System.out.println(headOffice.getBranchById(1));
        Branch branch2 = headOffice.createBranch();
        //print all branches
        System.out.println(headOffice.getAllBranchs());

        //throw an exception as branch id 12 is not present
        //System.out.println(headOffice.getBranchById(12));



        branch1.createBankAccount("123",AccountType.SAVING,20000.0);

        System.out.println(branch1);

        branch1.createBankAccount("123",AccountType.CURRENT,50000.0);
        System.out.println(".......................................");

        System.out.println(branch1.getCustomerByPanNumber("123"));

        BankAccount accounts = branch1.getCustomerByPanNumber("123").getAccounts().get(0);
        System.out.println(".......................................");
        System.out.println(accounts);

        accounts.deposit(1200.0);
        System.out.println(".......................................");
        System.out.println(accounts);
    }
}
