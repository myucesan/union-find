The Union-Find data structure allows us to maintain disjoint sets. One way to implement the Union-Find data structure is to use Union-by-Rank. This data structure can be implemented by using two arrays (root and rank). The data structure for this implementation uses pointers. Each node has an associated pointer to the name of the set that contains this node. The Union-by-Rank data structure has been partly implemented. Implement the missing find and union methods.

Note that the spec tests do not check whether you implemented the ranking correctly. They only check for the behaviour of the union and find methods, not their time!

**This solution is complete.**