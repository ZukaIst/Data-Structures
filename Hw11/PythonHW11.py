from collections import deque

def flood_fill(image, sr, sc, color):
    if len(image) < 1 or len(image[0]) < 1 or image[sr][sc] == color:
        print("no required changes")
        return image

    color1 = image[sr][sc]
    queue = deque([(sr, sc)])

    while queue:
        row, col = queue.popleft()
        if image[row][col] == color1:
            image[row][col] = color

            if col >= 1:
                queue.append((row, col - 1))
            if col + 1 < len(image[0]):
                queue.append((row, col + 1))
            if row >= 1:
                queue.append((row - 1, col))
            if row + 1 < len(image):
                queue.append((row + 1, col))

    return image

def main():
    image1 = [[1, 1, 1],
              [1, 1, 0],
              [1, 0, 1]]
    result1 = flood_fill(image1, 1, 1, 2)
    print("Result for image1:")
    for row in result1:
        print(row)

    image2 = [[0, 0, 0],
              [0, 0, 0]]
    result2 = flood_fill(image2, 0, 0, 0)
    print("Result for image2:")
    for row in result2:
        print(row)

if __name__ == "__main__":
    main()
