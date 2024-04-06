import java.util.LinkedList;
import java.util.Queue;

public class Hw11Java {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image.length < 1 || image[0].length < 1 || image[sr][sc] == color) {
            System.out.println("no required changes");
            return image;
        }

        int color1 = image[sr][sc];

        Queue <int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr,sc});

        while (!queue.isEmpty()) {
            int [] location = queue.remove();
            if (image[location[0]][location[1]] == color1){
                image[location[0]][location[1]] = color;

                if (location[1]>=1)
                    queue.add(new int[] {location[0],location[1]-1});
                if (location [1]+1 < image[0].length)
                    queue.add(new int[] {location[0],location[1]+1});
                if (location [0]>=1)
                    queue.add(new int[] {location[0]-1,location[1]});
                if (location [0]+1 < image.length)
                    queue.add(new int[] {location[0]+1,location[1]});

            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image1 = {{1,1,1},
                {1,1,0},
                {1,0,1}};
        floodFill(image1, 1, 1, 2);

        int[][] image2 = {{0,0,0},
                {0,0,0}};
        floodFill(image2, 0, 0 ,0);
    }
}
