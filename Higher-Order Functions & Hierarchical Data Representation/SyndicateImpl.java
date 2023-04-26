/*
 * James Bebarski
 * SyndicateImpl.java
 * Concept 4 + 5
 */

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The SyndicateImpl class, it is the concrete implementation of the Syndicate interface. 
 * @author James Bebarski
 */
public class SyndicateImpl implements Syndicate{
	
	/** The root node of our syndicate.*/
    private TreeNode<Member> root;
    
    /**
     * Constructs a SyndicateImpl object. 
     * This takes in a given name for our Godfather, and their neighborhood.
     * It then initializes a godfather object GroupoNode as the root node of the syndicate.
     * @param godfatherName - the given godfathername. 
     * @param neighborhood - the given neighborhood of the Godfather.
     */
    public SyndicateImpl(String godfatherName, Neighborhood neighborhood) {
    	root = new GroupNode<>(new Godfather(godfatherName, neighborhood));
    }
    
    @Override
    public void addMember(Member member, String bossName) {
        TreeNode<Member> newNode;
        
        // Creates a new node based on the type of the given member.
        if (member instanceof Associate) {
            newNode = new LeafNode<>(member);
        } else if (member instanceof Soldier || member instanceof Capo) {
            newNode = new GroupNode<>(member);
        } else {
            System.out.println("Invalid input.");
            return;
        }
        // Adds the new node as a child of the boss node, which is found by the given name.
        root = root.addChild(m -> m.getName().equals(bossName), newNode);
    }

    @Override
    public int getSize() {
    	// Count the resulting stream of nodes.
    	return (int) root.toList().stream().count();
    }
    
    @Override
	public int getSize(Predicate<Member> predicate) {
    	// Filters the tree by the given predicate and count the resulting stream of nodes.
    	return (int) root.toList().stream()
    			.filter(predicate)
    			.count();
	}
    
	@Override
    public int getSizeByNeighborhood(Neighborhood neighborhood) {
        // Filters the tree by the given neighborhood and count the resulting stream of nodes.
		return (int) root.toList().stream()
				.filter(member -> member.getNeighborhood() == neighborhood)
				.count();
    }
	
	@Override
	public int getTotalFinancialObligations() {
		return root.map(Member::getIncome).toList().stream()
				.reduce(0, Integer::sum);
	}
	
	@Override
	public int cutAbove(int cut) {
		return (int) root.toList().stream()
				.filter(member -> member.getIncome() > cut)
				.count();
	}
	
	@Override
	public int countMembersByCutAndNeighborhood(int cut, Neighborhood neighborhood) {
	    return root.toList().stream()
	            .filter(member -> member.getNeighborhood() == neighborhood)
	            .filter(member -> member.getIncome() > cut)
	            .map(member -> 1)
	            .reduce(0, Integer::sum);
	}
	
    @Override
    public List<String> allMembers() {
    	return root.map(e->e.getName()).toList();
    }
	
	@Override
	public void printMembers() {
	    root.traverse((node, depth) -> {
	        for (int i = 0; i < depth; i++) {
	            System.out.print("  ");
	        }
	        System.out.println(node.getData().toString());
	    });
	}
    
	@Override
	public List<Member> getMembersByCondition(Predicate<Member> condition) {
	    return root.toList().stream()
	            .filter(condition)
	            .collect(Collectors.toList());
	}

}
