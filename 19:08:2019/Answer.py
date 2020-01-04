import copy

class List(object):
	class _ListNode(object):
		def __init__(self, x):
			self.val = x
			self.next = None

	def __init__(self, x):
		self.length = 1
		self.root = List._ListNode(x)
		self.nextNode = self.root

	def addRoot(self, x):
		self.length += 1
		temp = self.root
		self.root = List._ListNode(x)
		self.root.next = temp

	def add(self, x):
		self.length += 1
		temp = self.root
		
		while temp.next:
			temp = temp.next
		
		temp.next = List._ListNode(x)
	
	def toString(self):
		string = ""
		self.reset()
		while self.nextNode:
			string += str(self.nextNode.val)
			self.moveToNext()
		self.reset()
		string = string[::-1]
		return string

	def moveToNext(self):
		self.nextNode = self.nextNode.next
		return self.nextNode

	def reset(self):
		self.nextNode = self.root

class Solution:
	def addTwoNumbers(self, l1, l2):
		result = None
		if l2.length > l1.length:
			(l1, l2) = (l2, l1)
		carry = False
		l1.reset()
		l2.reset()
		iterator = l2.nextNode
		while iterator:
			x = iterator.val + l1.nextNode.val
			if carry:
				x += 1
			if x > 9:
				x %= 10
				carry = True
			else:
				carry = False
			if result == None:
				result = List(x)
			else:
				result.add(x)
			iterator = l2.moveToNext()
			l1.moveToNext()

		if l2.length != l1.length:
			i = 0
			while i < (l1.length - l2.length):
				result.add(l1.nextNode.val)
				result.moveToNext()
				l1.moveToNext()
				i += 1
		
		l1.reset()
		l2.reset()
		result.reset()
		return result
		
print ("Please enter the first number: ")
inputString = input()
l1 = None
for c in inputString:
	if l1 == None:
		l1 = List(int(c))
	else:
		l1.addRoot(int(c))

print ("Please enter the second number: ")
inputString = input()
l2 = None
for c in inputString:
	if l2 == None:
		l2 = List(int(c))
	else:
		l2.addRoot(int(c))


result = Solution().addTwoNumbers(l1, l2)
print (result.toString())
