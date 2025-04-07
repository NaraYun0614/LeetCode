# LeetCode 1768. Merge String Alternately
class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        merge = []
        i ,j = 0,0
        len1, len2 = len(word1),len(word2)

        while i < len1 and j<len2:
            merge.append(word1[i])
            merge.append(word2[j])
            i+=1
            j+=1
        

        if i< len1:
            merge.append(word1[i:])
        

        if j < len2 :
            merge.append(word2[j:])
        
        return ''.join(merge)
        
