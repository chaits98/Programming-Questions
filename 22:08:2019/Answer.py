class Stack:
    class _Node:
        def __init__(self, x):
            self.val = x
            self.next = None

    def __init__(self):
        self.top = None
        self.length = 0

    def push(self, x):
        temp = Stack._Node(x)
        temp.next = self.top
        self.top = temp
        self.length += 1
    
    def pop(self):
        self.length -= 1
        temp = self.top
        self.top = self.top.next
        return temp.val
    
    def peek(self):
        return self.top.val


class Solution:
  def isValid(self, s):
    stack = Stack()
    opening = {
        '(' : ')',
        '{' : '}',
        '[' : ']'
    }
    closing = {
        ')' : '(',
        '}' : '{',
        ']' : '['
    }
    isValid = True
    for i in range(len(s)):
        character = s[i]
        if opening.get(character):
            stack.push(opening[character])
        elif closing.get(character):
            if stack.pop() != character:
                isValid = False
                break
    
    if (stack.length == 0):
        return isValid
    else: return False
 
inputString = input("Please enter the string: ")
print("The input string is {0}".format("valid" if Solution().isValid(inputString) else "invalid"))
