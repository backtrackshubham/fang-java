package shubham.edu.dsalgo.leet.code.practice;

/**
 * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
 * <p>
 * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
 * <p>
 * <p>
 * <p>
 * We may make the following moves:
 * <p>
 * 'U' moves our position up one row, if the position exists on the board;
 * 'D' moves our position down one row, if the position exists on the board;
 * 'L' moves our position left one column, if the position exists on the board;
 * 'R' moves our position right one column, if the position exists on the board;
 * '!' adds the character board[r][c] at our current position (r, c) to the answer.
 * (Here, the only positions that exist on the board are positions with letters on them.)
 * <p>
 * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = "leet"
 * Output: "DDR!UURRR!!DDD!"
 * Example 2:
 * <p>
 * Input: target = "code"
 * Output: "RR!DDRR!UUL!R!"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= target.length <= 100
 * target consists only of English lowercase letters.
 */
class AlphabetBoardPath {
    public static void main(String[] args) {
        AlphabetBoardPathHelper.alphabetBoardPath("");
    }
}

class AlphabetBoardPathHelper{
    static void alphabetBoardPath(String target) {
        StringBuilder builder = new StringBuilder();
        int r = 6;
        int c = 5;
        char[][] board = new char[r][c];
        int starting = 97;
        for (int i = 0; i < 26; i++) {
            int row = i / 5;
            int col = i % 5;
            board[row][col] = (char) (starting + i);
        }

        for (char x : target.toCharArray()){

        }
    }
}

