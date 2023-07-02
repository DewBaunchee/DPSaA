package Structs;

import java.util.ArrayList;

public class BinaryTree {
    public class Link {

        int key;
        String data;
        int level;
        Link left, right;

        public Link(int key, String data) {
            this.key = key;
            this.data = data;
            level = 0;
            left = right = null;
        }
    }

    int count, maxLevel;
    Link root;

    public BinaryTree() {
        count = 0;
        root = null;
    }

    // ОПЕРАЦИИ
    public String add(int key, String data) {
        int level = 0;

        Link addable = new Link(key, data);
        Link current = root;
        if(current == null) {
            addable.level = level;
            root = addable;
        } else {
            while(true) {
                if(current.key == key) {
                    return "Entered exist key.";
                }

                if(current.key > key) {
                    if(current.left == null) {
                        addable.level = level + 1;
                        current.left = addable;
                        break;
                    } else {
                        level++;
                        current = current.left;
                    }
                } else {
                    if(current.right == null) {
                        addable.level = level + 1;
                        current.right = addable;
                        break;
                    } else {
                        level++;
                        current = current.right;
                    }
                }

            }
        }
        if(level + 1 > maxLevel) {
            maxLevel = level + 1;
        }
        count++;
        return "";
    }

    public String find(int key) {
        Link current = root;
        while (current != null) {
            if(current.key == key) {
                return current.data;
            }
            if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return "NOT FOUND";
    }

    public String remove(int key) {
        Link current = root;
        Link parent = null;
        boolean isLeft = true;
        while (current != null && current.key != key) {
            if (key < current.key) {
                parent = current;
                isLeft = true;
                current = current.left;
            } else {
                parent = current;
                isLeft = false;
                current = current.right;
            }
        }
        if(current == null) {
            return "Element not found.";
        }

        Link successor = getSuccessor(current);
        count--;

        if(parent == null) {
            if(successor == null) {
                root = null;
                maxLevel = 0;
                return "";
            }
            successor.right = root.right;
            successor.left = root.left;
            successor.level = root.level;
            root = successor;
            return "";
        }

        if(successor == null) {
            if(isLeft) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return "";
        }

        successor.right = current.right;
        successor.left = current.left;
        successor.level = current.level;

        if(isLeft) {
            parent.left = successor;
        } else {
            parent.right = successor;
        }

        return "";
    }

    private Link getSuccessor(Link deletable) {
        if(deletable.right == null && deletable.left == null) {
            return null;
        }

        if(deletable.right == null) {

            Link current = deletable.left;
            if(current.right == null) {
                deletable.left = deletable.left.left;
                return current;
            }
            while (current.right.right != null) {
                current = current.right;
            }
            Link returnable = current.right;
            current.right = current.right.left;
            return returnable;

        } else {

            Link current = deletable.right;
            if(current.left == null) {
                deletable.right = deletable.right.right;
                return current;
            }
            while (current.left.left != null) {
                current = current.left;
            }
            Link returnable = current.left;
            current.left = current.left.right;
            return returnable;

        }
    }

    // ОБХОДЫ
    ArrayList<Link> directRec(Link link, ArrayList<Link> list) {
        if (link != null) {

            list.add(link);

            if (link.left != null) {
                list = directRec(link.left, list);
            }

            if (link.right != null) {
                list = directRec(link.right, list);
            }
        }
        return list;
    }

    ArrayList<Link> reverseRec(Link link, ArrayList<Link> list) {
        if (link != null) {

            if (link.right != null) {
                list = reverseRec(link.right, list);
            }

            if (link.left != null) {
                list = reverseRec(link.left, list);
            }

            list.add(link);
        }
        return list;
    }

    ArrayList<Link> symmetricRec(Link link, ArrayList<Link> list) {
        if (link != null) {
            if (link.left != null) {
                list = symmetricRec(link.left, list);
            }

            list.add(link);

            if (link.right != null) {
                list = symmetricRec(link.right, list);
            }
        }
        return list;
    }

    // ВЫВОД
    public String printDirectRec() {
        return printArrayList(directRec(root, new ArrayList<>()));
    }

    public String printReverseRec() {
        return printArrayList(reverseRec(root, new ArrayList<>()));
    }

    public String printSymmetricRec() {
        return printArrayList(symmetricRec(root, new ArrayList<>()));
    }

    private String printArrayList(ArrayList<Link> list) {
        if(list.size() == 0) return "[ EMPTY ]";
        StringBuilder answer = new StringBuilder("[ ");

        for(int i = 0; i < list.size() - 1; i++) {
            answer.append(list.get(i).key).append(", ");
        }

        return answer.toString() + list.get(list.size() - 1).key + " ]";
    }

    public String printAsTree() {
        int countOnMaxLevel = (int) Math.pow(2, maxLevel);
        ArrayList<Link> arr = new ArrayList<>();
        arr = symmetricRec(root, arr);
        StringBuilder answer = new StringBuilder();
        String[][] matrix = arrToMatrix(arr, countOnMaxLevel);
        for(int i = 0; i < maxLevel + 1; i++) {
            for(int j = 0; j < countOnMaxLevel; j++) {
                answer.append(printSpaces(5));
                if(matrix[i][j] != null) {
                    answer.append(matrix[i][j]);
                }
            }
            answer.append("\n");
        }
        return answer.toString();
    }

    private String printSpaces(int c) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < c; i++) {
            answer.append(" ");
        }
        return answer.toString();
    }

    String[][] arrToMatrix(ArrayList<Link> arr, int countOnMaxLevel) {
        String[][] matrix = new String[maxLevel + 1][];
        for(int i = 0; i < maxLevel + 1; i++) {
            matrix[i] = new String[countOnMaxLevel];
            for(int j = 0; j < countOnMaxLevel; j++) {
                matrix[i][j] = null;
            }
        }
        for(int i = 0; i < count; i++) {
            matrix[arr.get(i).level][i] = arr.get(i).key + ", " + arr.get(i).data;
        }
        return matrix;
    }
}
