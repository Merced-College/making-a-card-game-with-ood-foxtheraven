For this assignment you will work in a group and with the given code below to:

Read and interpret the code, adding comments when needed.  One person from the group should share their screen, or use LiveShare with CodeSpaces to share the code.
Make the Card class to make the code work, look at the code to see what methods you should make for your Card class. Your Card class should have constructors, accessors, mutators, and toString methods. Write any other methods for your code edition if you need them.
Add a feature to the code to make it work better. This should be at least 25 lines of quality code. This edition can be converting the array to an ArrayList, or any other code edition.
Make sure to write comments where you add this.  Write your names at the top of the program as comments. Everyone should turn in a copy of the code you worked on as a group.
Groups are assigned during lab.  You can use github CodeSpaces, with the LiveShare extension to easily share your code with your group.

Turn in your source code for this assignment, which should be at least 2 Files.  Turn these in via the github classroom link above.  Everyone in your group can turn in the same code, but should turn this in via their own cloned github repo that was created when you accepted this assignment via the github assignment link above.

You must meet with your group in lab time and work together on this code in order to receive group points.

-----------------

Notes from XQ:
- On Sep 23, 3:34 PM - The Hearts and Diamonds Bug: 
    - I thought I should probably distinctly put this somewhere for reference, but for some reason, the player's cards are only ever hearts or diamonds. Notably, that implies only the first half of the deck is being pulled. I have to investigate why, exactly, this is happening. My best bet is that the shuffle method doesn't work as intended.
    - Update at 3:56 PM: As far as I can tell, it's not necessarily the shuffle method, but the *math* of the shuffle method? By using a print statement to print the deck, you'll see that large swathes of consecutive cards will be the same suit, and that the first cards are always a group of hearts followed by a group of diamonds. *Why* this is happening, I genuinely don't know, but a logic or math error is undeniably present somewhere. This is definitely something to ask about in class.

- On Sep 23, 4:00 PM - Error in .equals:
    - So .equals in Card.java is definitely returning a boolean. But it's always returning false (see comments above the equals method in Card.java for elaboration), and moreover, it's just not comparing what it should for a card pair method.
- On Sep 25, 8:12 AM - Bug fix!
    - I was able to rewrite a very simple, new equals method that works as intended. Now, when two card's names are the same (NOT their values, because a queen and king are both 10 but are not a pair!), the method returns true.