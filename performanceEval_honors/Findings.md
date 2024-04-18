> [!NOTE]
> The assignment requests that my documentation shouldn't be longer than two pages, however this document may be over the limit given I have formatted this in a .md file. I will try to keep it brief as requested, though. 
# **HONORS - Performance Evaluation**
This assignment consists of two objectives, starting with making 100M, 200M, and 300M large ArrayLists and LinkedLists and comparing how they perform in various operations. The second part is comparing the performance between two iterators, one being a simple for loop with .get(i) taking care of all the values, and the other being a ListIterator set to go until hasNext() is false in a while loop.
# **Tools**
In order to generate my lists, I made a program which lets me make and control them. The program consists of two classes; [Main](src/Main.java) and [ErraticPulse](src/ErraticPulse.java). The names aren't relevant to their function, ErraticPulse is just a reference to a game I've played. 

To monitor the program, I used the software [VisualVM](https://visualvm.github.io/), which is a tool for profiling Java. While I'm quite new to this software (not to mention the 'profiling' tab not working for me) the monitoring tool is quite helpful. Aside from this monitoring tool, I'll mainly be using my own observations or timers to show the differences.
# **Part A - Comparing ArrayLists and LinkedLists**
The first thing I did was comparing the efficiency of each list by seeing the response times given by removing/adding elements. From what I experienced, adding/removing from the end was effectively instant. However, the ArrayList would slow down when tasked to add or remove from the starting index. This disparity only got more noticable as I ramped up the size of the lists. This was tested on 100M and 200M both, I attempted to run 300M with both lists active, but it hit the heap limit and after some time waiting I figured it was going to try to load forever.

(Comparing memory sizes goes here)

# **Part B - Comparing the Loop Iterators**

# **Conclusion**
