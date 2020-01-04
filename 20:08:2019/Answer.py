class Solution:
    def lengthOfLongestSubstring(self, s):
        startIndex = 0
        endIndex = 0
        result = 1
        start = 0
        chars = {}
        i = 0
        
        for i in range(0, len(s)):
            c = s[i]

            if chars.get(c) == None or startIndex > chars.get(c):
                endIndex = i
            else:
                startIndex = chars[c]

            chars[c] = i
            if endIndex - startIndex > result:
                result = endIndex - startIndex
                start = startIndex + 1
        
        return (start, result)


print ("Please enter the string: ")
inputString = input()

(start, result) = Solution().lengthOfLongestSubstring(inputString)

print ("Length of longest substring without repeating characters is {0}".format(result))
print ("The substring is: \"{0}\"".format(inputString[ start : start+result ]))