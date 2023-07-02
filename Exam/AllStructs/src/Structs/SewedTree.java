package Structs;

import java.util.ArrayList;

public class SewedTree {
    public class Link {

        int key;
        int level;
        boolean lTag, rTag;
        Link left, right;

        public Link(int key) {
            this.key = key;
            level = 0;
            left = right = null;
            lTag = rTag = false;
        }
    }

    int count, maxLevel;
    Link root;

    public SewedTree() {
        count = 0;
        root = null;
    }

    public String add(int key) {
        int level = 0;

        if (key > 100 || key < -100) {
            return "Number is out of bounds.";
        }
        if (count == 30) {
            return " Max number of elements.";
        }

        Link addable = new Link(key);
        Link current = root;
        if (current == null) {
            addable.level = level;
            root = addable;
        } else {
            while (true) {
                if (current.key == key) {
                    return "Entered exist key.";
                }

                if (current.key > key) {
                    if (current.left == null || current.lTag) {
                        addable.level = level + 1;
                        addable.right = current;
                        addable.left = current.left;
                        current.left = addable;
                        break;
                    } else {
                        level++;
                        current = current.left;
                    }
                } else {
                    if (current.right == null || current.rTag) {
                        addable.level = level + 1;
                        addable.left = current;
                        addable.right = current.right;
                        current.right = addable;
                        break;
                    } else {
                        level++;
                        current = current.right;
                    }
                }

            }
        }
        if (level + 1 > maxLevel) {
            maxLevel = level + 1;
        }
        count++;
        return "";
    }

    public Link find(int key) {
        Link current = root;

        while (current != null) {
            if (current.key == key) {
                return current;
            }

            if (key < current.key) {
                if(current.left != null && !current.lTag) {
                    current = current.left;
                } else {
                    current = null;
                }
            } else {
                if(current.right != null && !current.rTag) {
                    current = current.right;
                } else {
                    current = null;
                }
            }
        }
        return null;
    }

    public String remove(int key) {
        Link current = root;
        Link parent = null;
        boolean isLeft = true;
        while (current != null && current.key != key) {
            if (key < current.key) {
                if (current.lTag) {
                    break;
                }
                parent = current;
                isLeft = true;
                current = current.left;
            } else {
                if (current.rTag) {
                    break;
                }
                parent = current;
                isLeft = false;
                current = current.right;
            }
        }
        if (current == null) {
            return "Element not found.";
        }

        Link successor = getSuccessor(current);
        count--;

        if (parent == null) {
            if (successor == null) {
                root = null;
                maxLevel = 0;
                return "";
            }

            refreshLevels(successor, successor.level);
            successor.right = root.right;
            successor.left = root.left;
            successor.level = root.level;
            successor.rTag = root.rTag;
            successor.lTag = root.lTag;
            resewSuccessor(successor, root);
            root = successor;
            return "";
        }

        if (successor == null) {
            if (isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return "";
        }

        refreshLevels(successor, successor.level);
        successor.right = current.right;
        successor.left = current.left;
        successor.level = current.level;
        successor.rTag = current.rTag;
        successor.lTag = current.lTag;
        resewSuccessor(successor, current);

        if (isLeft) {
            parent.left = successor;
        } else {
            parent.right = successor;
        }
        return "";
    }

    private void resewSuccessor(Link successor, Link deletable) {
        if (successor.key > deletable.key) {
            int level = 0;
            Link current = deletable.left;
            if (current != null) {
                while (current.right != null && current.right.level > level) {
                    current = current.right;
                    level++;
                }
                current.right = successor;
            }
        }
    }

    private Link getSuccessor(Link deletable) {
        int level = deletable.level + 1;
        if ((deletable.right == null || deletable.rTag) && (deletable.left == null || deletable.lTag)) {
            return null;
        }

        if (deletable.right == null || deletable.rTag) {
            level++;
            Link current = deletable.left;

            if (current.right == null || deletable.rTag) {
                deletable.left = deletable.left.left;
                return current;
            }
            while (current.right.right != null && !current.right.rTag) {
                level++;
                current = current.right;
            }

            Link returnable = current.right;
            if (current.right.lTag) {
                current.right = current.right.left;
            }
            return returnable;

        } else {
            level++;
            Link current = deletable.right;

            if (current.left == null || current.left.level < level) {
                deletable.right = deletable.right.right;
                return current;
            }
            while (current.left.left != null && current.left.left.level == level) {
                level++;
                current = current.left;
            }

            Link returnable = current.left;
            if (current.left.right.level > current.level) {
                current.left = current.left.right;
            }
            return returnable;
        }
    }

    ArrayList<Link> symmetricRev(Link beginning) {
        ArrayList<Link> list = new ArrayList<>();
        Link current = beginning;
        Link prev;
        if(current == null) {
            return list;
        }

        while(current.left != null && current.left.level > current.level) {
            current = current.left;
        }
        while(current.right != null) {
            list.add(current);
            prev = current;
            current = current.right;
            if(prev.level < current.level) {
                while (current.left != null && current.left.level > current.level) {
                    current = current.left;
                }
            }
        }
        list.add(current);
        return list;
    }

    private void refreshLevels(Link link, int level) {
        Link current = link;
        Link prev;

        while(current.left != null && current.left.level > current.level) {
            current.level = level;
            level++;
            current = current.left;
        }
        while(current.right != null) {
            prev = current;
            current = current.right;
            if(prev.level < current.level) {
                while (current.left != null && current.left.level > current.level) {
                    level++;
                    current = current.left;
                }
            } else {
                level = current.level;
            }
            current.level = level;
            level++;
        }
    }

    public String printCentralRev() {
        return printArrayList(symmetricRev(root));
    }

    public String printDirectRev() {
        return printArrayList(directRev(root));
    }

    private ArrayList<Link> directRev(Link beginning) {
        ArrayList<Link> list = new ArrayList<>();
        Link current = beginning;
        Link prev;
        if(current == null) {
            return list;
        }

        while(current.left != null && current.left.level > current.level) {
            list.add(current);
            current = current.left;
        }
        list.add(current);

        while(current.right != null) {
            prev = current;
            current = current.right;
            if(prev.level < current.level) {
                while (current.left != null && current.left.level > current.level) {
                    list.add(current);
                    current = current.left;
                }
                list.add(current);
            }
        }
        return list;
    }

    private String printArrayList(ArrayList<Link> list) {
        if (list.size() == 0) {
            return "[ Empty tree ]";
        }
        String answer = "[ ";

        for (int i = 0; i < list.size() - 1; i++) {
            answer = answer + list.get(i).key + ", ";
        }

        return answer + list.get(list.size() - 1).key + " ]";
    }

    public String printAsTree() {
        int countOnMaxLevel = (int) Math.pow(2, maxLevel);
        ArrayList<Link> arr = symmetricRev(root);
        if (arr.size() == 0) {
            return "{ EMPTY }";
        }
        String answer = "";
        int[][] matrix = arrToMatrix(arr, countOnMaxLevel);
        for (int i = 0; i < maxLevel + 1; i++) {
            for (int j = 0; j < countOnMaxLevel; j++) {
                answer = answer + printSpaces(5);
                if (matrix[i][j] > -101) {
                    answer = answer + matrix[i][j];
                }
            }
            answer = answer + "\n";
        }
        return answer;
    }

    private String printSpaces(int c) {
        String answer = "";
        for (int i = 0; i < c; i++) {
            answer += " ";
        }
        return answer;
    }

    int[][] arrToMatrix(ArrayList<Link> arr, int countOnMaxLevel) {
        int[][] matrix = new int[maxLevel + 1][];
        for (int i = 0; i < maxLevel + 1; i++) {
            matrix[i] = new int[countOnMaxLevel];
            for (int j = 0; j < countOnMaxLevel; j++) {
                matrix[i][j] = -999;
            }
        }
        for (int i = 0; i < count; i++) {
            matrix[arr.get(i).level][i] = arr.get(i).key;
        }
        return matrix;
    }
}

