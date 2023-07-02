import java.util.ArrayList;

public class Graph<T> {
    private ArrayList<Node<T>> adjList;
    private T dataInitializer;

    Graph(T dataInitializer) {
        this.dataInitializer = dataInitializer;
        adjList = new ArrayList<>();
    }

    Graph(String adjList, T dataInitializer) {
        this.dataInitializer = dataInitializer;
        this.adjList = strToAdj(adjList);
        refreshEccentricity();
    }

    public void add(String adjLine) {
        splitToNodeAndAdd(adjLine, adjList);
        refreshEccentricity();
    }

    public Node<T> remove(int order) {
        int index = indexOfNode(adjList, order);
        if (index == -1) {
            return null;
        } else {
            Node<T> returnable = copyNode(adjList.remove(index));
            for (Node<T> node : adjList) {
                int i = indexOfNode(node.links, order);
                if (i > -1) {
                    node.links.remove(i);
                }
            }
            refreshEccentricity();
            return returnable;
        }
    }

    public String link(int srcOrder, int destOrder) {
        int srcIndex = indexOfNode(adjList, srcOrder);
        int destIndex = indexOfNode(adjList, destOrder);

        if (srcOrder == -1) {
            return "Source node not found.";
        }
        if (destOrder == -1) {
            return "Destination node not found";
        }

        adjList.get(srcIndex).links.add(adjList.get(destIndex));

        return "";
    }

    public String assignData(int order, T data) {
        int index = indexOfNode(adjList, order);
        if (index == -1) {
            return "Node not found.";
        }
        adjList.get(index).data = data;
        return "";
    }

    public String getData() {
        String answer = "";
        if(adjList.size() == 0) return "EMPTY";

        for(Node<T> node : adjList) {
            answer = answer + node.order + ": " + (node.data.equals(dataInitializer) ? "NO DATA" : node.data) + "\n";
        }
        return answer;
    }

    public Path<T> shortestPath(int srcOrder, int destOrder) {
        if(!isCorrect(srcOrder, destOrder)) return null;
        return recShortest(adjList.get(indexOfNode(adjList, srcOrder)),
                adjList.get(indexOfNode(adjList, destOrder)),
                adjList.get(indexOfNode(adjList, srcOrder)),
                new Path<>(-1)).cloneList();
    }

    private Path<T> recShortest(Node<T> src, Node<T> dest, Node<T> next, Path<T> path) {
        path.add(next);
        if(src == dest) return new Path<>(0);
        if(path.length == adjList.size()) return new Path<>(Integer.MAX_VALUE);
        if(next == dest) return path;
        if(next == src && path.length > 1) return new Path<>(Integer.MAX_VALUE);

        ArrayList<Path<T>> paths = new ArrayList<>();
        for(Node<T> node : next.links) {
            paths.add(recShortest(src, dest, node, path.cloneList()));
        }

        return minOfPaths(paths);
    }

    private Path<T> minOfPaths(ArrayList<Path<T>> paths) {
        Path<T> min = new Path<>(Integer.MAX_VALUE);
        for(int i = 0; i < paths.size(); i++) {
            if(min.length > paths.get(i).length) {
                min = paths.get(i);
            }
        }
        return min;
    }

    public Path<T> longestPath(int srcOrder, int destOrder) {
        if(!isCorrect(srcOrder, destOrder)) return null;
        return recLongest(adjList.get(indexOfNode(adjList, srcOrder)),
                adjList.get(indexOfNode(adjList, destOrder)),
                adjList.get(indexOfNode(adjList, srcOrder)),
                new Path<>(-1)).cloneList();
    }

    private Path<T> recLongest(Node<T> src, Node<T> dest, Node<T> next, Path<T> path) {
        path.add(next);
        if(src == dest) return new Path<>(0);
        if(path.length == adjList.size()) return new Path<>(Integer.MAX_VALUE);
        if(next == dest) return path;
        if(next == src && path.length > 1) return new Path<>(Integer.MAX_VALUE);

        ArrayList<Path<T>> paths = new ArrayList<>();
        for(Node<T> node : next.links) {
            Path<T> addable = recLongest(src, dest, node, path.cloneList());
            if(addable.length < Integer.MAX_VALUE) {
                paths.add(addable);
            }
        }

        if(paths.size() == 0) return new Path<>(Integer.MAX_VALUE);

        return maxOfPaths(paths);
    }

    private Path<T> maxOfPaths(ArrayList<Path<T>> paths) {
        Path<T> max = new Path<>(Integer.MIN_VALUE);
        for(int i = 0; i < paths.size(); i++) {
            if(max.length < paths.get(i).length && paths.get(i).length != Integer.MAX_VALUE) {
                max = paths.get(i);
            }
        }
        return max.length == Integer.MIN_VALUE ? new Path<>(Integer.MAX_VALUE) : max;
    }

    public ArrayList<Path<T>> allPaths(int srcOrder, int destOrder) {
        if(!isCorrect(srcOrder, destOrder)) return null;
        ArrayList<Path<T>> paths = new ArrayList<>();
        for(Node<T> node : adjList.get(indexOfNode(adjList, srcOrder)).links) {
            Path<T> newPath = new Path<>(-1);
            newPath.add(adjList.get(indexOfNode(adjList, srcOrder)));

            Path<T> addable = recShortest(adjList.get(indexOfNode(adjList, srcOrder)),
                    adjList.get(indexOfNode(adjList, destOrder)),
                    adjList.get(indexOfNode(adjList, node.order)),
                    newPath).cloneList();

            if(addable.length < Integer.MAX_VALUE) {
                paths.add(addable);
            }
        }
        return sortPaths(paths);
    }
/*
    private Path<T> recAllPaths(Node<T> src, Node<T> dest, Node<T> next, Path<T> path) {
        path.add(next);
        if(src == dest) return new Path<>(0);
        if(path.length == adjList.size()) return new Path<>(Integer.MAX_VALUE);
        if(next == dest) return path;
        if(next == src && path.length > 1) return new Path<>(Integer.MAX_VALUE);

        Path<T> returnable = new Path<>(Integer.MAX_VALUE);
        for(Node<T> node : next.links) {
            Path<T> addable = recShortest(src, dest, node, path.cloneList());
            if(addable.length < Integer.MAX_VALUE) {
                returnable = addable;
            }
        }

        return returnable;
    }*/

    private ArrayList<Path<T>> sortPaths(ArrayList<Path<T>> paths) {
        for(int i = 0; i < paths.size(); i++) {
            for (int j = paths.size() - i - 1; j < paths.size(); j++) {
                if(paths.get(i).length < paths.get(j).length) {
                    paths = swapPaths(paths, i, j);
                }
            }
        }

        return paths;
    }

    private ArrayList<Path<T>> swapPaths(ArrayList<Path<T>> paths, int i, int j) {
        Path<T> temp = paths.get(i);
        paths.set(i, paths.get(j));
        paths.set(j, temp);
        return paths;
    }

    public ArrayList<Node<T>> center() {
        int radius = findMinEccentricity();
        ArrayList<Node<T>> centres = new ArrayList<>();

        for(Node<T> node : adjList) {
            if(node.eccentricity == radius) {
                centres.add(node);
            }
        }
        return centres;
    }

    public ArrayList<Node<T>> periphery() {
        int diameter = findMaxEccentricity();
        ArrayList<Node<T>> peripheris = new ArrayList<>();

        for(Node<T> node : adjList) {
            if(node.eccentricity == diameter) {
                peripheris.add(node);
            }
        }
        return peripheris;
    }

    private int findMaxEccentricity() {
        int max = Integer.MIN_VALUE;
        for(Node<T> node : adjList) {
            if(node.eccentricity > max && node.eccentricity != Integer.MAX_VALUE) {
                max = node.eccentricity;
            }
        }
        return max == Integer.MIN_VALUE ? Integer.MAX_VALUE : max;
    }

    private int findMinEccentricity() {
        int min = Integer.MAX_VALUE;
        for(Node<T> node : adjList) {
            if(node.eccentricity < min) {
                min = node.eccentricity;
            }
        }
        return min;
    }

    public String printMainCharacteristics(int srcOrder, int destOrder) {
        String answer = "";
        answer = answer + "Shortest path: " + shortestPath(srcOrder, destOrder) + "\n";
        answer = answer + "Longest path: " + longestPath(srcOrder, destOrder) + "\n";
        answer = answer + "All paths: " + allPaths(srcOrder, destOrder) + "\n";
        answer = answer + "Center: " + center() + "\n";
        answer = answer + "Periphery: " + periphery() + "\n";
        answer = answer + "Radius: " + findMinEccentricity() + "\n";
        answer = answer + "Diameter: " + findMaxEccentricity() + "\n";
        return answer;
    }

    public void refreshEccentricity() {
        ArrayList<Path<T>> paths;
        for(Node<T> srcNode : adjList) {
            paths = new ArrayList<>();
            for(Node<T> destNode : adjList) {
                if(srcNode == destNode) continue;
                paths.add(shortestPath(srcNode.order, destNode.order));
            }
            srcNode.eccentricity = maxOfPaths(paths).length;
        }
    }

    public String printAdjList() {
        String answer = "Adjacency list: \n";

        if (adjList.size() == 0) {
            return answer + "EMPTY";
        }

        for (int i = 0; i < adjList.size(); i++) {
            Node<T> node = adjList.get(i);
            answer = answer + node.order + " -> " + listToString(node) + "\n";
        }
        return answer;
    }

    private boolean isCorrect(int srcOrder, int destOrder) {
        if(indexOfNode(adjList, srcOrder) == -1 || indexOfNode(adjList, destOrder) == -1) {
            return false;
        }
        return true;
    }

    private Node<T> copyNode(Node<T> node) {
        Node<T> copy = new Node<>(node.order, node.data);
        for (Node<T> link : node.links) {
            copy.links.add(new Node<>(link.order, link.data));
        }
        return copy;
    }

    private int indexOfNode(ArrayList<Node<T>> list, int order) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).order == order) {
                return i;
            }
        }
        return -1;
    }

    private ArrayList<Node<T>> strToAdj(String listInString) {
        ArrayList<Node<T>> list = new ArrayList<>();
        while (listInString.contains("\n")) {
            splitToNodeAndAdd(listInString.substring(0, listInString.indexOf("\n")), list);
            listInString = listInString.substring(listInString.indexOf("\n") + 1);
        }
           return list;
    }

    private void splitToNodeAndAdd(String line, ArrayList<Node<T>> list) {
        line = line.replaceAll(" +", " ").trim();

        Node<T> node = new Node<>(Integer.parseInt(line.substring(0, getSeparatorIndex(line)).trim()), dataInitializer);
        int index = indexOfNode(list, node.order);

        if(index == -1) {
            list.add(node);
        } else {
            list.get(index).links = node.links;
        }
        line = line.replaceFirst("\\d+\\D*", "");

        while (line.length() > 0) {
            int sepIndex = getSeparatorIndex(line);
            Node<T> newNode = new Node<>(Integer.parseInt(line.substring(0, sepIndex).trim()), dataInitializer);
            index = indexOfNode(list, newNode.order);

            if(index == -1) {
                node.links.add(newNode);
                list.add(newNode);
            } else {
                node.links.add(list.get(index));
            }

            line = line.replaceFirst("\\d+\\D*", "");
        }
    }

    private int getSeparatorIndex(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (!isNumber(line.charAt(i))) {
                return i;
            }
        }
        return line.length();
    }

    private boolean isNumber(char c) {
        return (int) c > 47 && (int) c < 58;
    }

    public String listToString(Node<T> node) {
        if (node.links.size() == 0) return "[ EMPTY ]";
        String answer = "[ ";
        for (int i = 0; i < node.links.size() - 1; i++) {
            answer = answer + node.links.get(i).order + ", ";
        }
        return answer + node.links.get(node.links.size() - 1).order + " ]";
    }
}

class Node<T> {
    T data;
    int order;
    int eccentricity;
    ArrayList<Node<T>> links;

    Node(int order, T data) {
        this.data = data;
        this.order = order;
        eccentricity = Integer.MAX_VALUE;
        links = new ArrayList<>();
    }

    Node(int order, T data, ArrayList<Node<T>> links) {
        this.data = data;
        this.order = order;
        eccentricity = Integer.MAX_VALUE;
        this.links = links;
    }

    @Override
    public String toString() {
        return order + "";
    }
}

class Path<T> {
    int length;
    private ArrayList<Node<T>> path;

    Path(int init) {
        length = init;
        path = new ArrayList<>();
    }

    public Path<T> add(Node<T> node) {
        path.add(node);
        length++;
        return this;
    }

    public String toString() {
        if (length < 1) return "[ EMPTY ]";
        String answer = "[ ";
        for (int i = 0; i < path.size() - 1; i++) {
            answer = answer + path.get(i).order + " -> ";
        }
        return answer + path.get(path.size() - 1).order + " ]";
    }

    public Path<T> cloneList() {
        Path<T> newPath = new Path<>(length);
        for (Node<T> node : path) {
            newPath.path.add(new Node<>(node.order, node.data));
        }
        return newPath;
    }
}