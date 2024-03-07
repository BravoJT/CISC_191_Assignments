# **Document Analyser**
[This program](docanalyse_honors/src/Main.java) takes an [input file](docanalyse_honors/song.txt) and attempts to record the number of times each word is used in that file. It then outputs to the System and to an [output file](docanalyse_honors/wordCount.txt).
>[!NOTE]
>This file does not have a database of words, it simply checks what was used. Names and made-up words will appear to it as ordinary words. 
# **Flowchart**
![Flowchart](docanalyse_honors/flowchart.png)
# **Challenges**
My main challenge with this assignment was trying to parse the words. With the help of an ASCII table and some prior experience, I knew I could set it up so only eligible letters would be put into words. However, the results were all wrong. There was a random "m" word which should've existed, and I found out that I'd missed the possibility of contractions. Once found it was an easy fix, though, with OR exception being made for apostrophes. Another weird issue was my ArrayList picking up an empty String, but that was fixed via a bunch of checks to prevent empty Strings from coming through.
