import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HeadOffice {
    private List<Branch> branches;

    private volatile static HeadOffice headOffice;

    private HeadOffice() {
        branches = new ArrayList<>();
    }

    public static HeadOffice getInstance() {
        if (headOffice == null) {
            synchronized (HeadOffice.class) {
                if (headOffice == null) {
                    headOffice = new HeadOffice();
                }
            }
        }
        return headOffice;
    }


    public Branch createBranch() {

        int totalBranches = branches.size();
        int branchID = totalBranches + 1;
        Branch branch = new Branch(branchID);
        branches.add(branch);
        DataMapper dataMapper = DataMapper.getInstance();
        Map<Integer, Branch> branchIdMapping = dataMapper.getBranchIdMapping();
        branchIdMapping.put(branchID, branch);

        return branch;
    }

    public List<Branch> getAllBranchs() {

        return this.branches;
    }

    public Branch getBranchById(int branchID) {

        DataMapper dataMapper = DataMapper.getInstance();

        Map<Integer, Branch> branchIdMapping = dataMapper.getBranchIdMapping();
        if (branchIdMapping.containsKey(branchID)) {
            return branchIdMapping.get(branchID);
        } else {
//            StringBuilder formedErrorMessage = new StringBuilder("{Branch ID :-}" + branchID + " ");
//            formedErrorMessage.append(ErrorMessages.DATA_NOT_FOUND.getAction())
            throw new DataNotFoundException(ErrorMessages.DATA_NOT_FOUND);
        }
    }

}
