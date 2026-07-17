import java.util.*;

class ThroneInheritance {
    // Map to store the family tree: parent -> list of children
    private Map<String, List<String>> familyTree;
    // Set to keep track of dead family members
    private Set<String> deadSet;
    // Name of the king
    private String king;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.deadSet = new HashSet<>();
        // Initialize the king's family list
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        // Add the child to the parent's children list
        this.familyTree.get(parentName).add(childName);
        // Initialize the new child's list of children
        this.familyTree.put(childName, new ArrayList<>());
    }
    
    public void death(String name) {
        // Mark the person as dead
        this.deadSet.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        // Perform pre-order DFS starting from the king
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        // Only add to the final list if the person is alive
        if (!deadSet.contains(current)) {
            order.add(current);
        }
        
        // Recursively visit children in the order they were born
        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_4 = obj.getInheritanceOrder();
 */