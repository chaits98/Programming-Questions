class Solution: 
    def longestPalindrome(self, s):
        result = 1
        start = 0
        table = [[False for j in range(len(s))] for i in range(len(s))]
        
        for i in range(len(s)):
            table[i][i] = True
        
        for i in range(len(s)-1):
            if s[i] == s[i+1]:
                table[i][i+1] = True
                start = i
                result = 2

        for k in range(3, len(s)):
            for i in range(len(s) - k + 1):
                j = i + k - 1
                if table[i+1][j-1] and s[i] == s[j]:
                    table[i][j] = True
                    if k > result:
                        result = k
                        start = i

        return (start, result)


print ("Please enter the string: ")
inputString = input()

(start, result) = Solution().longestPalindrome(inputString)

print ("The longest palindrome is: \"{0}\"".format(inputString[ start : start+result ]))