from typing import List

class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        # Define the sets for each row on the keyboard
        row1 = set("qwertyuiop")
        row2 = set("asdfghjkl")
        row3 = set("zxcvbnm")
        
        # List to store words that can be typed using one row
        result = []
        
        # Check each word
        for word in words:
            # Convert the word to lowercase to handle both uppercase and lowercase
            lower_word = set(word.lower())
            
            # Check if all letters in the word belong to one of the rows
            if lower_word.issubset(row1) or lower_word.issubset(row2) or lower_word.issubset(row3):
                result.append(word)
        
        return result