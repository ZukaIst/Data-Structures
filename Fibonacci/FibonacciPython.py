def fibonacci(n):
    first = 0
    second = 1

    if n == 1:
        print(0)
        return
    elif n == 2:
        print("0\n1")
        return

    print("0\n1")
    for i in range(n - 2):
        temp = first
        first = second
        second = first + temp
        print(second)

# Change this for nth value
n = 9
fibonacci(n)
