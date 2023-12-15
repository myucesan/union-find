
class UnionFind {

    private int[] parent;

    private int[] rank;

    // Union Find structure implemented with two arrays for Union by Rank
    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
    }

    /**
     * Merge two subtrees if they have a different parent, input is array indices
     *
     * @param i a node in the first subtree
     * @param j a node in the second subtree
     * @return true iff i and j had different parents.
     */
    boolean union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI == parentJ) {
            return false;
        }

        if (rank[parentI] > rank[parentJ]) {
            parent[j] = parent[i];

        } else if (rank[parentJ] > rank[parentI]) {
            parent[i] = parent[j];
        } else {
            parent[parentJ] = parentI;
            rank[parentJ]++;
        }
        return true; // change later
    }

    /**
     * NB: this function should also do path compression
     *
     * @param i index of a node
     * @return the root of the subtree containig i.
     */
    int find(int i) {
//        int result = i;
//        while (rank[result] != 0) {
//            result = parent[i];
//        }
        // thinking mistake above. Initially every node is the parent of itself, I was foolish comparing the rank.
        // I have to check when a node is the parent of itself, then you know you have the root node and you want to attach
        // other trees you union to that node

        if (parent[i] != i) { // as long as i is not the parent of itself
            parent[i] = find(parent[i]); // go up the tree until you reach the root (parent[i] == i)
        }

        return parent[i];
    }

    // Return the rank of the trees
    public int[] getRank() {
        return rank;
    }

    // Return the parent of the trees
    public int[] getParent() {
        return parent;
    }
}
