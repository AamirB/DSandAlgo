package google.graph;

public class Other {
}


//https://leetcode.com/discuss/interview-question/326705/Google-or-Onsite-or-Rooms-and-keys
//Do an initial DFS from the starting room, maintaining a 2D array to mark visitable rooms.
// Meanwhile collect keys. Unlock all keys, and repeat the DFS, until you get a DFS when you did not
// get any key. Then check, if end room is reachable, return true, else false.
// This is O(m^2 n^2) solution.