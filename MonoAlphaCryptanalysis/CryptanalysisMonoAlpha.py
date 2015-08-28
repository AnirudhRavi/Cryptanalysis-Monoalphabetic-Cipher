'''
Program to decipher the Cipher Text received by Darth from a conversation between Alice and Bob encrypted using Monoalphabetic Cipher.

Algorithm:
1. Use a random key and set this as the parent key
Do this for 1000 iterations:
    2. Store the fitness score (score based on occurrences of Quadgrams) of the deciphered text using key
    3. Swap 2 characters in the parent key and set this as child. If fitness score calculated using the child is greater than parent then set the parent as child key
4. Print current best key and best plaintext if fitness score is higher than from the earlier iterations and move back to step 1

@author: anirudhravi
'''
from pycipher import SimpleSubstitution as SimpleSub
import time
import re
import random
from ngram_score import ngram_score
fitness = ngram_score('quadgrams.txt') # Import number of times Quadgrams occur in "War and Peace" by Leo Tolstoy

ctext='tpfccdlfdttepcaccplircdtdklpcfrp?qeiqlhpqlipqeodfgpwafopwprtiizxndkiqpkiikrirrifcapncdxkdciqcafmdvkfpcadf'
ctext = re.sub('[^A-Z]','',ctext.upper()) #Remove spaces and make all characters Upper Case

maxkey = list('ABCDEFGHIJKLMNOPQRSTUVWXYZ')
maxscore = -99e9
parentscore,parentkey = maxscore,maxkey[:]
print "Cryptanalysis of Monoalphabetic Cipher. Several Iterations are run to get the correct result."
print "Enter CTRL+C to exit the program"
# Keep going until the program is killed
start_time = time.time()
i = 0
while 1:
    i = i+1
    random.shuffle(parentkey)
    deciphered = SimpleSub(parentkey).decipher(ctext)
    parentscore = fitness.score(deciphered)
    count = 0
    while count < 1000:
        a = random.randint(0,25)
        b = random.randint(0,25)
        child = parentkey[:]
        # Swap 2 characters in the Child Key and calculate the fitness score of deciphered text using this key
        child[a],child[b] = child[b],child[a]
        deciphered = SimpleSub(child).decipher(ctext)
        score = fitness.score(deciphered)
        # If the child has a better score - replace the parent
        if score > parentscore:
            parentscore = score
            parentkey = child[:]
            count = 0
        count = count+1
    # Print out the best score gotten after this iteration
    if parentscore>maxscore:
        maxscore,maxkey = parentscore,parentkey[:]
        print '\nBest fitness score so far: ', maxscore,' on iteration ', i
        ss = SimpleSub(maxkey)
        print '    Best Key: '+''.join(maxkey)
        print '    Best Plaintext: '+ss.decipher(ctext)
        print '    Time Taken: %f s' % (time.time() - start_time)