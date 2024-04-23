def main():
    # Test Case 1: Given test case
    wells1 = [1, 1]
    pipes1 = [[1, 2, 1],
              [1, 2, 2]]
    print(min_cost_to_supply_water(2, wells1, pipes1))  # 2 output

    # Test Case 3: Pipe is cheaper
    wells2 = [10, 20, 30]
    pipes2 = [[1, 2, 5],
              [2, 3, 5],
              [1, 3, 20]]
    print(min_cost_to_supply_water(3, wells2, pipes2))  # 20 output

    # Test Case 4: Cheap pipe tiebreak
    wells3 = [50, 50, 50, 50]
    pipes3 = [[1, 2, 10],
              [2, 3, 10],
              [3, 4, 10],
              [1, 3, 30]]
    print(min_cost_to_supply_water(4, wells3, pipes3))  # 80 output


def min_cost_to_supply_water(n, wells, pipes):
    edges = []
    for i in range(n):
        edges.append([0, i + 1, wells[i]])

    edges.extend(pipes)

    # Sort the edges
    edges.sort(key=lambda x: x[2])

    # Create minimum spanning tree
    min_tree = list(range(n + 1))

    # Initialize count and cost
    count = 0
    cost = 0

    # Iterate over all edges
    for edge in edges:
        if find(min_tree, edge[0]) != find(min_tree, edge[1]):  # If the edge doesn't create a cycle
            union(min_tree, edge[0], edge[1])  # Add it to the minimum spanning tree
            # Increment count and cost
            cost += edge[2]
            count += 1
            if count == n:  # If we've added all of the houses to the MST, finish
                break

    return cost


def find(parent, i):
    if parent[i] != i:
        parent[i] = find(parent, parent[i])
    return parent[i]


def union(parent, i, j):
    root_i = find(parent, i)
    root_j = find(parent, j)
    if root_i != root_j:
        parent[root_i] = root_j


if __name__ == "__main__":
    main()
