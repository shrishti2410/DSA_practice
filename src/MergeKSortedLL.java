//Brute force-We initialise an array to temporarily hold the extracted nodes during the traversal. Then the array is sorted to arrange all values sequentially and a new linked list from that array is created and returned.
//TC-O(N*K)+O(MlogM)+O(M)=O(2*N*M)
//M=N*K
//SC-O(2*M)

//Better-Merge two lists, then use recursion
//TC=O(2*M*N)
//SC=O(N)

public class MergeKSortedLL {
}
