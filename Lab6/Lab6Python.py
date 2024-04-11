from collections import deque

def can_finish(num_courses, prerequisites):
    indegree = [0] * num_courses
    adj = [[] for _ in range(num_courses)]

    for pre in prerequisites:
        indegree[pre[0]] += 1
        adj[pre[1]].append(pre[0])

    q = deque()
    for i in range(num_courses):
        if indegree[i] == 0:
            q.append(i)

    num = 0
    while q:
        current = q.popleft()
        num += 1
        for i in adj[current]:
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)

    return num == num_courses

# Test cases
test1 = [[1,0]]
print(can_finish(2, test1))

test2 = [[1,0], [0, 1]]
print(can_finish(2, test2))