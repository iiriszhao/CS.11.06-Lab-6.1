import java.io.*;
import java.net.SocketOption;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fileName12  = "inputOneTwo.txt";
        int [] increase = readFileIntoArray(fileName12);
        System.out.println(countIncreaseInArray(increase));
        System.out.println(challengeTwo(fileName12));

        String fileName34 = "inputThreeFour.txt";
        System.out.println(challengeThree(fileName34));
        System.out.println(challengeFour(fileName34));

    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        int lineCount = 0;
        while  (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }

        return lineCount;
    }

    public static int[] readFileIntoArray (String fileName) throws IOException {
        int linesInFile = challengeOne(fileName);
        int[] array = new int[linesInFile];

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        int index = 0;

        while (scanner.hasNextLine()) {
            array[index++] = Integer.parseInt(scanner.nextLine().trim());
        }
        return array;

    }
    public static int countIncreaseInArray(int[] arr) throws IOException {

        int answer = 0;
        for (int i=0; i<arr.length-1; i++) {
            int difference = arr[i+1] - arr[i];
            if (difference > 0) {
                answer++;
            }
        }
        return answer;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */

    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] arr = readFileIntoArray2(fileName);
        int countIncrease = 0;

        for (int i=1; i < arr.length-2; i++) {
            int sumCurrentWindow = arr[i] + arr[i+1] + arr[i+2];
            int sumPreviousWindow = arr[i-1] + arr[i] + arr[i+1];

            if (sumCurrentWindow > sumPreviousWindow) {
                countIncrease++;
            }
        }
        return countIncrease;
    }
    public static int[] readFileIntoArray2 (String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        int count = 0;
        while(scanner.hasNextLine()) {
            count++;
            scanner.nextLine();
        }
        int[] array = new int[count];

        scanner = new Scanner(file);
        int index = 0;
        while(scanner.hasNextLine()) {
            array[index++] = Integer.parseInt(scanner.nextLine().trim());
        }
        return array;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int horizontal = 0;
        int depth = 0;

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int spaceIndex = line.indexOf(' ');
            int value = Integer.parseInt(line.substring(spaceIndex+1));

            if (line.contains("forward")) {
                horizontal += value;
            } else if (line.contains("down")) {
                depth += value;
            } else if (line.contains("up")) {
                depth -= value;
            }
        }
        scanner.close();
        return horizontal * depth;
    }


    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int horizontal = 0;
        int aim = 0;
        int depth = 0;


        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int spaceIndex = line.indexOf(' ');
            int value = Integer.parseInt(line.substring(spaceIndex+1));

            if (line.contains("forward")) {
                horizontal += value;
                depth += aim * value;
            } else if (line.contains("down")) {
                aim += value;
            } else if (line.contains("up")) {
                aim -= value;
            }
        }
        scanner.close();
        return horizontal * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}