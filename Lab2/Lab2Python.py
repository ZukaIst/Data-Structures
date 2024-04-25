def main():
    s = "listen"
    t = "silent"

    print(f"Is \"{t}\" an anagram of \"{s}\"? {anagramic(s, t)}")

def anagramic(s, t):
    if len(s) != len(t):
        return False

    # goes through each letter of string s
    for i in range(len(s)):
        found = False
        # goes through the entire string t comparing s
        for j in range(len(t)):
            # if the current letter is found in t, mark it as found
            if s[i] == t[j]:
                found = True
                break
        # if the current letter is not found in t, return False
        if not found:
            return False

    # return True if all letters in s are found in t
    return True

if __name__ == "__main__":
    main()
