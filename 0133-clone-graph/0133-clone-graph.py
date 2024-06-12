"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None
        
        table = {}
        
        def explore(node):
            if node in table:
                return
            table[node] = Node(node.val)
            for neighbor in node.neighbors:
                explore(neighbor)
                table[node].neighbors.append(table[neighbor])
        
        explore(node)
        return table[node]