import java.util.*;
import java.util.stream.Stream;

public class GraphWithAdjacencyList {
    private static Map<GraphNode, List<GraphNode>> adjNodes = new HashMap<>();

    public List<GraphNode> getAdjNodes(int key) {
        return adjNodes.get(new GraphNode(key));
    }

    public void addNode(int key) {
        adjNodes.putIfAbsent(new GraphNode(key), new ArrayList<>());
    }

    public void addEdge(int node1, int node2) {
        GraphNode gn1 = new GraphNode(node1);
        GraphNode gn2 = new GraphNode(node2);
        adjNodes.get(gn1).add(gn2);
        adjNodes.get(gn2).add(gn1);
    }

    public void removeNode(int key) {
        GraphNode gn = new GraphNode(key);
        adjNodes.values().stream().forEach(e -> e.remove(gn));
        adjNodes.remove(new GraphNode(key));
    }

    public void removeEdge(int node1, int node2) {
        GraphNode gn1 = new GraphNode(node1);
        GraphNode gn2 = new GraphNode(node2);
        List<GraphNode> list1 = adjNodes.get(gn1);
        List<GraphNode> list2 = adjNodes.get(gn2);
        if (list1 != null) {
            list1.remove(gn2);
        }
        if (list2 != null) {
            list2.remove(gn1);
        }
    }

    public List<Integer> DFS(int key){
        List<Integer> visted = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(key);
        while (!stack.isEmpty()){
            int node = stack.pop();
            if (!visted.contains(node)) {
                visted.add(node);
                for (GraphNode gn : adjNodes.get(node)) {
                    stack.push(gn.data);
                }
            }
        }
        return visted;
    }
    public List<Integer> BFS(int key) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(key);
        visited.add(key);
        while(!que.isEmpty()) {
            int node = que.poll();
            for (GraphNode gn : adjNodes.get(node)) {
                if (!visited.contains(gn.data)) {
                    visited.add(gn.data);
                    que.add(gn.data);
                }
            }
        }
        return visited;
    }
    public int minNumberOfEdges(int node1, int node2) {
        GraphNode gn1 = new GraphNode(node1);
        GraphNode gn2 = new GraphNode(node2);
        Vector<Integer>[] edges = addEdgeHelper(node1, node2);
        int count = adjNodes.size();
        Vector<Boolean> visited = new Vector<>();
        for (int i = 0; i < count ; i++) {
            visited.addElement(false);
        }
        Vector<Integer> distance = new Vector<>();
        for (int i = 0; i < count; i++) {
            distance.addElement(0);
        }
        Queue<Integer> que = new LinkedList<>();
        distance.setElementAt(0, node1);

        que.add(node1);
        visited.setElementAt(true, node1);
        while (!que.isEmpty()) {
            int x = que.peek();
            que.poll();
            for (int i = 0; i < edges[x].size(); i++) {
                if (visited.elementAt(edges[x].get(i)))
                    continue;
                distance.setElementAt(distance.get(x) + 1, edges[x].get(i));
                que.add(edges[x].get(i));
                visited.setElementAt(true, edges[x].get(i));
            }
        }
        return distance.get(node2);
    }
    public static Vector<Integer>[] addEdgeHelper(int node1, int node2) {
        Vector<Integer> edge[] = new Vector[adjNodes.size() + 1];
        for (int i = 0; i < adjNodes.size(); i++) {
            edge[node1].add(node2);
            edge[node2].add(node1);
        }
        return edge;
    }
//    static final int ROW = 5, COL = 5;
//
//    // A function to check if a given cell (row, col) can
//    // be included in DFS
//    boolean isSafe(int M[][], int row, int col,
//                   boolean visited[][])
//    {
//        // row number is in range, column number is in range
//        // and value is 1 and not yet visited
//        return (row >= 0) && (row < ROW) && (col >= 0) &&
//                (col < COL) && (M[row][col] == 1 && !visited[row][col]);
//    }
//
//    // A utility function to do DFS for a 2D boolean matrix.
//    // It only considers the 8 neighbors as adjacent vertices
//    void DFS(int M[][], int row, int col, boolean visited[][])
//    {
//        // These arrays are used to get row and column numbers
//        // of 8 neighbors of a given cell
//        int rowNbr[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
//        int colNbr[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
//
//        // Mark this cell as visited
//        visited[row][col] = true;
//
//        // Recur for all connected neighbours
//        for (int k = 0; k < 8; ++k)
//            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited))
//                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
//    }
//
//    // The main function that returns count of islands in a given
//    // boolean 2D matrix
//    int countIslands(int M[][])
//    {
//        // Make a bool array to mark visited cells.
//        // Initially all cells are unvisited
//        boolean visited[][] = new boolean[ROW][COL];
//
//        // Initialize count as 0 and travese through the all cells
//        // of given matrix
//        int count = 0;
//        for (int i = 0; i < ROW; ++i)
//            for (int j = 0; j < COL; ++j)
//                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
//                { // value 1 is not
//                    // visited yet, then new island found, Visit all
//                    // cells in this island and increment island count
//                    DFS(M, i, j, visited);
//                    ++count;
//                }
//
//        return count;
//
//
//    }

    public static void main(String[] args) {
        int two = 2;
        int one = 1;
        int three = 3;
        int zero = 0;
        GraphWithAdjacencyList gwaj = new GraphWithAdjacencyList();
        gwaj.addNode(two);
        gwaj.addNode(three);
        gwaj.addNode(one);
        gwaj.addNode(zero);

        //gwaj.addEdge(two, one);

        System.out.println(gwaj.adjNodes.size());
        //  System.out.println(gwaj.adjNodes.keySet().toString());
        //System.out.println(gwaj.getAdjNodes(two).toString());
        //Stream.of(gwaj.adjNodes.keySet().toString()).forEach(System.out::println);
        for (GraphNode gn : adjNodes.keySet()) {
            String key = gn.toString();
            String value = adjNodes.get(gn).toString();
            System.out.println(key + value);
        }
    }
}
