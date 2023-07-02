public class HashCatalog {
    public final int MAX_MULTIPLIER = 1000;
    int alphabetMultiplier;
    List[] buckets;

    HashCatalog(int alphabetMultiplier) {
        if(alphabetMultiplier > 0) {
            if (alphabetMultiplier > MAX_MULTIPLIER) {
                buckets = new List[MAX_MULTIPLIER * 26];
                this.alphabetMultiplier = MAX_MULTIPLIER;
            } else {
                buckets = new List[alphabetMultiplier * 26];
                this.alphabetMultiplier = alphabetMultiplier;
            }
        } else {
            buckets = new List[26];
            this.alphabetMultiplier = 1;
        }
    }

    String add(String word, String description) {
        word = refractWord(word);
        description = description.trim();
        if(word.charAt(0) > 'Z') {
            word = (char)(word.charAt(0) - 32) + word.substring(1);
        }
        if(word.length() == 0) {
            return "Invalid word";
        }
        int hash = calcHash(word);
        if(buckets[hash] == null) {
            buckets[hash] = new List();
        }
        return buckets[hash].add(hash, word, description);
    }

    String remove(String word) {
        word = refractWord(word);
        int hash = calcHash(word);
        if(buckets[hash].remove(word) == null) {
            return "No such record in the catalog";
        }
        return "Word has been deleted.";
    }

    String find(String word) {
        word = refractWord(word);
        int hash = calcHash(word);
        Link current = buckets[hash].findByWord(word);
        if(current == null) {
            return "There is no such word in catalog.";
        }
        return current.word + " - " + current.description;
    }

    String clearPrint() {
        String answer = "";
        int currentSection = 1;
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] != null) {
                answer = answer + "\n-----------Section #" + currentSection + "-----------\n" + buckets[i].listToString("\n");
                currentSection++;
            }
        }
        if (answer.length() == 0) {
            answer = "-----------CATALOG IS EMPTY-----------";
        }
        return answer;
    }

    String print() {
        String answer = "";
        for(int i = 0; i < buckets.length; i++) {
            String str = "";
            if(i % alphabetMultiplier == 0) {
                str = " (" + ((char) (i / alphabetMultiplier + 65)) + ") ";
            }

            answer = answer + "\n-----------Section #" + (i + 1) + str + "-----------\n";

            if(buckets[i] != null) {
                answer = answer + buckets[i].listToString("\n");
            }
        }
        return answer;
    }

    private int calcHash(String word) {
        int offset = 0;
        for(int i = 0; i < word.length(); i++) {
            offset += word.charAt(i);
        }
        return (word.charAt(0) - 65) * alphabetMultiplier + offset % alphabetMultiplier;
    }

    private String refractWord(String word) {
        word = word.trim();
        return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
    }
}
