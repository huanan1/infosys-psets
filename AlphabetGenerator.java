import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * <p>
     * This method will try to weigh each character of the alphabet
     * proportional to their occurrence in words in a training set.
     * <p>
     * This method should do the following to generate an alphabet:
     * 1. Count the occurrence of each character a-z in trainingData.
     * 2. Compute the probability of each character a-z by taking
     * (occurrence / total_num_characters).
     * 3. The output generated in step (2) is a PDF of the characters in the
     * training set. Convert this PDF into a CDF for each character.
     * 4. Multiply the CDF value of each character by the base we are
     * converting into.
     * 5. For each index 0 <= i < base,
     * output[i] = (the first character whose CDF * base is > i)
     * <p>
     * A concrete example:
     * 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     * "ccccc..." (198 "c"s)}, base = 93
     * 1. Count(a) = 302, Count(b) = 500, Count(c) = 198
     * 2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     * Pr(c) = 198 / 1000 = .198
     * 3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     * 4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     * 5. Output = {"a", "a", ... (29 As, indexes 0-28),
     * "b", "b", ... (46 Bs, indexes 29-74),
     * "c", "c", ... (18 Cs, indexes 75-92)}
     * <p>
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     * - {"a", "b", "c", "c", "d"} is a valid output.
     * - {"b", "c", "c", "d", "a"} is not.
     * <p>
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     * <p>
     * If base < 0, return null.
     * <p>
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     *
     * @param base         A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     * digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {
       /* if (base < 0) return null;
        if (base == 0) return new char[0];

        HashMap<Character, Integer> characterCount = new HashMap<>();

        int charCount = 0;

        for (String word : trainingData) {
            char[] wordToCharacter = word.toCharArray();
            for (char character : wordToCharacter) {
                if (Character.isLetter(character) == true) {
                    charCount += 1;
                    char lowercase = Character.toLowerCase(character);
                    if (characterCount.containsKey(lowercase) == true) {
                        characterCount.put(lowercase, characterCount.get(lowercase) + 1);
                    } else {
                        characterCount.put(lowercase, 1);
                    }
                }
            }
        }
        final float totalCharCount = charCount;

        HashMap<Character, Float> characterPDF = new HashMap<>();
        characterCount.forEach((k, v) -> {
            characterPDF.put(k, v / totalCharCount);
        });

        HashMap<Character, Float> characterCDF = new HashMap<>();
        float CDF = 0;
        for (Map.Entry<Character, Float> pair : characterPDF.entrySet()) {
            CDF += pair.getValue();
            characterCDF.put(pair.getKey(), CDF);
        }

        char[] output = new char[base];

        float CDFvalue;
        int i = 0;

        for (char character : characterCDF.keySet()) {
            CDFvalue = characterCDF.get(character);
            while (i >= 0 && i < base && CDFvalue > i) {
                output[i] = character;
                i++;
            }
        }
        return output;
    }

*/
        /*myMap.forEach((k, v) -> {//Do stuff;}); // The restriction is that variable used in lamdha
        expression should be final or effectively final (a var whose value never changes after instantiation).
        */




        if (base < 0) return null;
        if (base == 0) return new char[0];
        // calculate frequency of each letter
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        int totalChar = 0;
        for (String str : trainingData) {
            char[] charArray = str.toCharArray();
            for (char character : charArray) {
                char lowerChar = Character.toLowerCase(character);
                if (character == lowerChar && Character.isLetter(character)==true) {
                    totalChar += 1;
                    if (charMap.containsKey(lowerChar))
                        charMap.put(lowerChar, charMap.get(lowerChar) + 1);
                    else {
                        charMap.put(lowerChar, 1);
                    }
                }
            }
        }

        /*
        *  HashMap<Character, Double> PDFMap = new HashMap<>();
        double occurence;
        double probability;
        for (Character character : keys) {
            occurence = charMap.get(character);
            probability = occurence / (double) totalChar;
            PDFMap.put(character, probability);
        }

        HashMap<Character, Double> CDFMap = new HashMap<>();
        double cumulativeprob = 0.0;
        for (Character character : keys) {
            cumulativeprob += PDFMap.get(character);
            CDFMap.put(character, cumulativeprob * base);
        }

        char[] output = new char[base];
        int i = 0;
        double CDFvalue;
        for(char character:keys){
            CDFvalue = CDFMap.get(character);
            while(i>=0 && i<base && CDFvalue>i){
                output[i] = character;
                i++;
            }
        }*/

        Character[] keys = charMap.keySet().toArray(new Character[0]);

        char[] output = new char[base];
        int i = 0;
        double CDFvalue = 0.0;
        for(char character:keys){
            CDFvalue += ((double)charMap.get(character)/totalChar)*base;
            //different from (double)(charMap.get(character)/totalChar)*base because this will
            // result in the inner division giving an integer first before you map it to a double
            while(i<base && CDFvalue>i){
                output[i] = character;
                i++;
            }
        }

        return output;
    }


    public static void main(String[] args) {
        String[] WORD_LIST = {"a", "able", "about", "account", "acid", "across", "act", "addition", "adjustment", "advertisement", "after", "again", "against", "agreement", "air", "all", "almost", "among", "amount", "amusement", "and", "angle", "angry", "animal", "answer", "ant", "any", "apparatus", "apple", "approval", "arch", "argument", "arm", "army", "art", "as", "at", "attack", "attempt", "attention", "attraction", "authority", "automatic", "awake", "baby", "back", "bad", "bag", "balance", "ball", "band", "base", "basin", "basket", "bath", "be", "beautiful", "because", "bed", "bee", "before", "behaviour", "belief", "bell", "bent", "berry", "between", "bird", "birth", "bit", "bite", "bitter", "black", "blade", "blood", "blow", "blue", "board", "boat", "body", "boiling", "bone", "book", "boot", "bottle", "box", "boy", "brain", "brake", "branch", "brass", "bread", "breath", "brick", "bridge", "bright", "broken", "brother", "brown", "brush", "bucket", "building", "bulb", "burn", "burst", "business", "but", "butter", "button", "by", "cake", "camera", "canvas", "card", "care", "carriage", "cart", "cat", "cause", "certain", "chain", "chalk", "chance", "change", "cheap", "cheese", "chemical", "chest", "chief", "chin", "church", "circle", "clean", "clear", "clock", "cloth", "cloud", "coal", "coat", "cold", "collar", "colour", "comb", "come", "comfort", "committee", "common", "company", "comparison", "competition", "complete", "complex", "condition", "connection", "conscious", "control", "cook", "copper", "copy", "cord", "cork", "cotton", "cough", "country", "cover", "cow", "crack", "credit", "crime", "cruel", "crush", "cry", "cup", "cup", "current", "curtain", "curve", "cushion", "damage", "danger", "dark", "daughter", "day", "dead", "dear", "death", "debt", "decision", "deep", "degree", "delicate", "dependent", "design", "desire", "destruction", "detail", "development", "different", "digestion", "direction", "dirty", "discovery", "discussion", "disease", "disgust", "distance", "distribution", "division", "do", "dog", "door", "doubt", "down", "drain", "drawer", "dress", "drink", "driving", "drop", "dry", "dust", "ear", "early", "earth", "east", "edge", "education", "effect", "egg", "elastic", "electric", "end", "engine", "enough", "equal", "error", "even", "event", "ever", "every", "example", "exchange", "existence", "expansion", "experience", "expert", "eye", "face", "fact", "fall", "false", "family", "far", "farm", "fat", "father", "fear", "feather", "feeble", "feeling", "female", "fertile", "fiction", "field", "fight", "finger", "fire", "first", "fish", "fixed", "flag", "flame", "flat", "flight", "floor", "flower", "fly", "fold", "food", "foolish", "foot", "for", "force", "fork", "form", "forward", "fowl", "frame", "free", "frequent", "friend", "from", "front", "fruit", "full", "future", "garden", "general", "get", "girl", "give", "glass", "glove", "go", "goat", "gold", "good", "government", "grain", "grass", "great", "green", "grey", "grip", "group", "growth", "guide", "gun", "hair", "hammer", "hand", "hanging", "happy", "harbour", "hard", "harmony", "hat", "hate", "have", "he", "head", "healthy", "hear", "hearing", "heart", "heat", "help", "high", "history", "hole", "hollow", "hook", "hope", "horn", "horse", "hospital", "hour", "house", "how", "humour", "i", "ice", "idea", "if", "ill", "important", "impulse", "in", "increase", "industry", "ink", "insect", "instrument", "insurance", "interest", "invention", "iron", "island", "jelly", "jewel", "join", "journey", "judge", "jump", "keep", "kettle", "key", "kick", "kind", "kiss", "knee", "knife", "knot", "knowledge", "land", "language", "last", "late", "laugh", "law", "lead", "leaf", "learning", "leather", "left", "leg", "let", "letter", "level", "library", "lift", "light", "like", "limit", "line", "linen", "lip", "liquid", "list", "little", "living", "lock", "long", "look", "loose", "loss", "loud", "love", "low", "machine", "make", "male", "man", "manager", "map", "mark", "market", "married", "mass", "match", "material", "may", "meal", "measure", "meat", "medical", "meeting", "memory", "metal", "middle", "military", "milk", "mind", "mine", "minute", "mist", "mixed", "money", "monkey", "month", "moon", "morning", "mother", "motion", "mountain", "mouth", "move", "much", "muscle", "music", "nail", "name", "narrow", "nation", "natural", "near", "necessary", "neck", "need", "needle", "nerve", "net", "new", "news", "night", "no", "noise", "normal", "north", "nose", "not", "note", "now", "number", "nut", "observation", "of", "off", "offer", "office", "oil", "old", "on", "only", "open", "operation", "opinion", "opposite", "or", "orange", "order", "organization", "ornament", "other", "out", "oven", "over", "owner", "page", "pain", "paint", "paper", "parallel", "parcel", "part", "past", "paste", "payment", "peace", "pen", "pencil", "person", "physical", "picture", "pig", "pin", "pipe", "place", "plane", "plant", "plate", "play", "please", "pleasure", "plough", "pocket", "point", "poison", "polish", "political", "poor", "porter", "position", "possible", "pot", "potato", "powder", "power", "present", "price", "print", "prison", "private", "probable", "process", "produce", "profit", "property", "prose", "protest", "public", "pull", "pump", "punishment", "purpose", "push", "put", "quality", "question", "quick", "quiet", "quite", "rail", "rain", "range", "rat", "rate", "ray", "reaction", "reading", "ready", "reason", "receipt", "record", "red", "regret", "regular", "relation", "religion", "representative", "request", "respect", "responsible", "rest", "reward", "rhythm", "rice", "right", "ring", "river", "road", "rod", "roll", "roof", "room", "root", "rough", "round", "rub", "rule", "run", "sad", "safe", "sail", "salt", "same", "sand", "say", "scale", "school", "science", "scissors", "screw", "sea", "seat", "second", "secret", "secretary", "see", "seed", "seem", "selection", "self", "send", "sense", "separate", "serious", "servant", "sex", "shade", "shake", "shame", "sharp", "sheep", "shelf", "ship", "shirt", "shock", "shoe", "short", "shut", "side", "sign", "silk", "silver", "simple", "sister", "size", "skin", "skirt", "sky", "sleep", "slip", "slope", "slow", "small", "smash", "smell", "smile", "smoke", "smooth", "snake", "sneeze", "snow", "so", "soap", "society", "sock", "soft", "solid", "some", "son", "song", "sort", "sound", "soup", "south", "space", "spade", "special", "sponge", "spoon", "spring", "square", "stage", "stamp", "star", "start", "statement", "station", "steam", "steel", "stem", "step", "stick", "sticky", "stiff", "still", "stitch", "stocking", "stomach", "stone", "stop", "store", "story", "straight", "strange", "street", "stretch", "strong", "structure", "substance", "such", "sudden", "sugar", "suggestion", "summer", "sun", "support", "surprise", "sweet", "swim", "system", "table", "tail", "take", "talk", "tall", "taste", "tax", "teaching", "tendency", "test", "than", "that", "the", "then", "theory", "there", "thick", "thin", "thing", "this", "thought", "thread", "throat", "through", "through", "thumb", "thunder", "ticket", "tight", "till", "time", "tin", "tired", "to", "toe", "together", "tomorrow", "tongue", "tooth", "top", "touch", "town", "trade", "train", "transport", "tray", "tree", "trick", "trouble", "trousers", "true", "turn", "twist", "umbrella", "under", "unit", "up", "use", "value", "verse", "very", "vessel", "view", "violent", "voice", "waiting", "walk", "wall", "war", "warm", "wash", "waste", "watch", "water", "wave", "wax", "way", "weather", "week", "weight", "well", "west", "wet", "wheel", "when", "where", "while", "whip", "whistle", "white", "who", "why", "wide", "will", "wind", "window", "wine", "wing", "winter", "wire", "wise", "with", "woman", "wood", "wool", "word", "work", "worm", "wound", "writing", "wrong", "year", "yellow", "yes", "yesterday", "you", "young"};
        char[] alphabet = AlphabetGenerator.generateFrequencyAlphabet(
                100, WORD_LIST);
        System.out.println(alphabet);

    }

}